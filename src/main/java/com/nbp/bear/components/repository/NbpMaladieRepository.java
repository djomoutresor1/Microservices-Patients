package com.nbp.bear.components.repository;

import com.nbp.bear.components.model.NbpDiseases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NbpMaladieRepository extends JpaRepository<NbpDiseases,Integer> {

}
