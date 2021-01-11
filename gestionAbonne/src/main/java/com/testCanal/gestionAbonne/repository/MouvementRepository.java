package com.testCanal.gestionAbonne.repository;

import com.testCanal.gestionAbonne.model.Contrat;
import com.testCanal.gestionAbonne.model.Mouvement;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MouvementRepository extends CrudRepository<Mouvement, Integer> {
    List<Mouvement> findMouvementsByAbonne_Id(int AbonneId);
}
