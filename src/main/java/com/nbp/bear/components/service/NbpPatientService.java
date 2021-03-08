package com.nbp.bear.components.service;

import com.nbp.bear.components.constants.NbpResponse;
import com.nbp.bear.components.model.NbpPatient;
import com.nbp.bear.components.repository.NbpPatientRepository;
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
    public ResponseEntity<Object> NbpSavePatientService(NbpPatient nbpPatient) {
        try {
            nbpPatientRepository.save(nbpPatient);
            return new ResponseEntity<Object>(nbpPatient, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<Object>(NbpResponse.NBP_PATIENT_NOT_FOUND, HttpStatus.NOT_FOUND);
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
            return new ResponseEntity<Object>(nbpPatient, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<Object>(NbpResponse.NBP_PATIENT_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }


    //update patient
    public ResponseEntity<Object> NbpUpdatePatientService(int patientId,NbpPatient nbpPatient) {

      try{
          NbpPatient existingPatient = nbpPatientRepository.findById(patientId).orElse(null);

          existingPatient.setPatientId(patientId);
          existingPatient.setPatientCode(nbpPatient.getPatientCode());
          existingPatient.setPatientName(nbpPatient.getPatientName());
          existingPatient.setPatientLassName(nbpPatient.getPatientLassName());
          existingPatient.setPatientBirthday(nbpPatient.getPatientBirthday());
          existingPatient.setPatientAge(nbpPatient.getPatientAge());
          existingPatient.setPatientSexe(nbpPatient.getPatientSexe());
          existingPatient.setPatientAddress(nbpPatient.getPatientAddress());
          existingPatient.setPatientPostcode(nbpPatient.getPatientPostcode());
          existingPatient.setPatientInfoSuppl(nbpPatient.getPatientInfoSuppl());
          existingPatient.setPatientEmail(nbpPatient.getPatientEmail());
          existingPatient.setPatientPhoneNumber(nbpPatient.getPatientPhoneNumber());
          existingPatient.setPatientFixNumber(nbpPatient.getPatientFixNumber());
          existingPatient.setPatientDiseases(nbpPatient.getPatientDiseases());

          nbpPatientRepository.save(existingPatient);
          return new ResponseEntity<Object>(existingPatient, HttpStatus.OK);
      }
      catch (Exception ex){
          return new ResponseEntity<Object>(NbpResponse.NBP_PATIENT_UPDATE_PROFIL_NOT_FOUND, HttpStatus.NOT_FOUND);
      }
    }
}
