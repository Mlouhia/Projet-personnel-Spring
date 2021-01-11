package com.testCanal.gestionAbonne.service;

import com.testCanal.gestionAbonne.model.Abonne;
import com.testCanal.gestionAbonne.model.Contrat;
import com.testCanal.gestionAbonne.repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratService {
    @Autowired
    ContratRepository contratRepository;

    //créer ou modifier un contrat
    public void saveOrUpdate(Contrat contrat)
    {
        contratRepository.save(contrat);
    }

    //trouver les contrats d'un abonné
    public List<Contrat> getAbonneContrats(int AbonneId)
    {
        return contratRepository.findContratsByAbonne_Id(AbonneId);
    }

    public Contrat getAbonneFirstContrat(int AbonneId)
    {
        return contratRepository.findFirstByAbonne_Id(AbonneId);
    }

    // Mettre à jour des contrats
    public void updateContrats(List<Contrat> contrats){
        contratRepository.saveAll(contrats);

    }
}
