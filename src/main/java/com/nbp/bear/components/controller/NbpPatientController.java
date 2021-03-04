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
public class NbpPatientController {

    @Autowired
    private NbpPatientService nbpPatientService;

    @PostMapping("/addPatient/{patientId}")
    public NbpPatient addPatient(@RequestBody NbpPatient nbpPatient) {
        return nbpPatientService.savePatient(nbpPatient);
    }

    @PostMapping("/addPatients")
    public List<NbpPatient> addPatients(@RequestBody @Valid List<NbpPatient> nbpPatients) {
        return nbpPatientService.savePatients(nbpPatients);
    }

    @GetMapping("/patients")
    public List<NbpPatient> findAllPatients() {
        return nbpPatientService.getAllPatients();
    }

    @GetMapping("/patientById/{patientId}")
    public NbpPatient findPatientById(@PathVariable int patientId) {
        return nbpPatientService.getPatientById(patientId);
    }

    @GetMapping("/patient/{patientName}")
    public Optional<NbpPatient> findPatientByName(@PathVariable String patientName) {
        return nbpPatientService.getPatientByPatientName(patientName);
    }


    @PutMapping("/update/{patientId}")
    public ResponseEntity<Object> updatePatient(@RequestBody NbpPatient nbpPatient){
        return nbpPatientService.NbpUpdatePatientService(nbpPatient);
    }

    @DeleteMapping("/delete/{PatientId}")
    public ResponseEntity<Object> deletePatient(@PathVariable int patientId) {
        return nbpPatientService.NbpPatientDeleteService(patientId);
    }
}
