package com.nbp.bear.components.service;

import com.nbp.bear.components.constants.NbpResponse;
import com.nbp.bear.components.model.NbpPatient;
import com.nbp.bear.components.repository.NbpPatientRepository;
import com.nbp.bear.components.response.NbpUtilResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NbpPatientService {

    @Autowired
    private NbpPatientRepository nbpPatientRepository;


    //save patient
    public <nbpPatient> ResponseEntity<Object> NbpSavePatientService(NbpPatient nbpPatient) {
        Optional <nbpPatient> patientById = (Optional<nbpPatient>) nbpPatientRepository.findById(nbpPatient.getPatientId());
        if (!patientById.isPresent()) {
            try {
                nbpPatientRepository.save(nbpPatient);
                return new ResponseEntity<Object>(new NbpUtilResponse(NbpResponse.NBP_PATIENT_CREATED, nbpPatient), HttpStatus.CREATED);
            } catch (Exception ex) {
                return new ResponseEntity<Object>(NbpResponse.NBP_PATIENT_NOT_FOUND, HttpStatus.NOT_FOUND);
            }
        }else{
            return new ResponseEntity<Object>(new NbpUtilResponse(NbpResponse.NBP_PATIENT_ALREADY_EXIST, nbpPatient.getPatientName()), HttpStatus.OK);
        }
    }

    //save many patient
    public List<NbpPatient> NbpAddPatientsService(List<NbpPatient> nbpPatients) {
        return nbpPatientRepository.saveAll(nbpPatients);
    }

    //get all patients
    public ResponseEntity<Object> NbpGetAllPatientsService() {
        try {
            List<NbpPatient> nbpPatients = nbpPatientRepository.findAll();
            return new ResponseEntity<Object>(nbpPatients, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<Object>(NbpResponse.NBP_PATIENT_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    //get patients by id
    public NbpPatient NbpGetPatientByIdService(int patientId) {
        return nbpPatientRepository.findById(patientId).orElse(null);
    }

    //get patient  by PatientName
    public List<NbpPatient> NbpGetPatientByNameService(String patientName) {
        return nbpPatientRepository.findByPatientName(patientName);
    }


    //delete one patient
    public ResponseEntity<Object> NbpPatientDeleteService(int patientId) {
        try {
            NbpPatient nbpPatient = nbpPatientRepository.findById(patientId).get();
            nbpPatientRepository.delete(nbpPatient);
            return new ResponseEntity<Object>(new NbpUtilResponse(NbpResponse.NBP_PATIENT_DELETED, nbpPatient), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<Object>(NbpResponse.NBP_PATIENT_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }


    //update patient
    public ResponseEntity<Object> NbpUpdatePatientService(int patientId,NbpPatient nbpPatient) {
      try{
           nbpPatient.setPatientId(patientId);
           nbpPatientRepository.save(nbpPatient);
          return new ResponseEntity<Object>(new NbpUtilResponse(NbpResponse.NBP_PATIENT_UPDATE_PROFIL,nbpPatient), HttpStatus.OK);
      }
      catch (Exception ex){
          return new ResponseEntity<Object>(NbpResponse.NBP_PATIENT_UPDATE_PROFIL_NOT_FOUND, HttpStatus.NOT_FOUND);
      }
    }
}
