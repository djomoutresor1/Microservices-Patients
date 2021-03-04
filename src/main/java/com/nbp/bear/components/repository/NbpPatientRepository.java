package com.nbp.bear.components.repository;

import com.nbp.bear.components.model.NbpPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NbpPatientRepository extends JpaRepository<NbpPatient,Integer> {

    Optional<NbpPatient> findByPatientName(String patientName);
}




