package com.nbp.bear.components.controller;

import com.nbp.bear.components.model.NbpPatient;
import com.nbp.bear.components.service.NbpPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/v1/api")
@RestController
@CrossOrigin("*")
public class NbpPatientController {

    @Autowired
    private NbpPatientService nbpPatientService;

    // add one patient
    @PostMapping("/addPatient")
    public ResponseEntity<Object> NbpSavePatient(@RequestBody @Valid NbpPatient nbpPatient ) {
        return nbpPatientService.NbpSavePatientService(nbpPatient);
    }

    // add many patients
    @PostMapping("/addPatients")
    public List<NbpPatient> NbpAddPatients(@RequestBody @Valid List<NbpPatient> nbpPatients) {
        return nbpPatientService.NbpAddPatientsService(nbpPatients);
    }

    // get all patients
    @GetMapping("/patients")
    public ResponseEntity<Object> NbpGetAllPatients() {
        return  nbpPatientService.NbpGetAllPatientsService();
    }

    // get one patient by Id
    @GetMapping("/patientById/{patientId}")
    public NbpPatient NbpGetPatientById(@PathVariable int patientId) {
        return nbpPatientService.NbpGetPatientByIdService(patientId);
    }

    // get one patient by patientName
    @GetMapping("/patient/{patientName}")
    public List<NbpPatient> NbpGetPatientByName(@PathVariable String patientName) {
        return nbpPatientService.NbpGetPatientByNameService(patientName);
    }

    // update one patient
    @PutMapping("/update/{patientId}")
    public ResponseEntity<Object> NbpUpdatePatient(@PathVariable int patientId ,@RequestBody @Valid NbpPatient nbpPatient){
        return nbpPatientService.NbpUpdatePatientService(patientId,nbpPatient);
    }

    // delete one patient
    @DeleteMapping("/delete/{patientId}")
    public ResponseEntity<Object> NbpPatientDelete(@PathVariable int patientId) {
        return nbpPatientService.NbpPatientDeleteService(patientId);
    }
}
