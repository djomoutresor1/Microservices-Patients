package components.service;

import components.constants.NbpResponse;
import components.model.NbpPatient;
import components.repository.NbpPatientRepository;
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

    //save one patient
    public NbpPatient savePatient(NbpPatient nbpPatient) {
        return nbpPatientRepository.save(nbpPatient);
    }

    //save many patient
    public List<NbpPatient> savePatients(List<NbpPatient> nbpPatients) {
        return nbpPatientRepository.saveAll(nbpPatients);
    }

    //get patients by id
    public NbpPatient getPatientById(int patientId) {
        return nbpPatientRepository.findById(patientId).orElse(null);
    }

    //get patient  by PatientName
    public Optional<NbpPatient> getPatientByPatientName(String patientName) {
        return nbpPatientRepository.findByPatientName(patientName);
    }

    //get all patients
    public List<NbpPatient> getAllPatients() {
        return nbpPatientRepository.findAll();
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
    public ResponseEntity<Object> NbpUpdatePatientService(NbpPatient nbpPatient) {

      try{
          NbpPatient existingPatient = nbpPatientRepository.findById(nbpPatient.getPatientId()).orElse(null);

          existingPatient.setPatientId(nbpPatient.getPatientId());
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
  //        existingPatient.setPatientDiseases(nbpPatient.getPatientDiseases());

          nbpPatientRepository.save(existingPatient);
          return new ResponseEntity<Object>(existingPatient, HttpStatus.OK);
      }
      catch (Exception ex){
          return new ResponseEntity<Object>(NbpResponse.NBP_PATIENT_UPDATE_PROFIL_NOT_FOUND, HttpStatus.NOT_FOUND);
      }
    }
}
