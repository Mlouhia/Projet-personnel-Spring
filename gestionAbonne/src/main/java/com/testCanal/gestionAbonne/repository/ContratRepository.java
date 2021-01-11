package com.testCanal.gestionAbonne.repository;

import com.testCanal.gestionAbonne.model.Contrat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContratRepository extends CrudRepository<Contrat, Integer> {
    List<Contrat> findContratsByAbonne_Id(int AbonneId);
    Contrat findFirstByAbonne_Id(int AbonneId);
}
