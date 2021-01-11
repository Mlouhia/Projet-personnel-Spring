package com.testCanal.gestionAbonne.controller;

import com.testCanal.gestionAbonne.model.Abonne;
import com.testCanal.gestionAbonne.model.Contrat;
import com.testCanal.gestionAbonne.service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//creating RestController
@RestController
public class ContratController {

    //autowired the StudentService class
    @Autowired
    ContratService contratService;

    //souscrire un contrat
    @PostMapping("/contrat")
    private int creerContrat(@RequestBody Contrat contrat)
    {
        contratService.saveOrUpdate(contrat);
        return contrat.getId();
    }

    //Récupérer les informations sur les contrats d’un abonné
    @GetMapping("/abonneGetContrat/{id}")
    private List<Contrat> getAbonneContrat(@PathVariable("id") int AbonneId)
    {
        return contratService.getAbonneContrats(AbonneId);
    }
}
