package com.testCanal.gestionAbonne.controller;

import com.testCanal.gestionAbonne.model.Abonne;
import com.testCanal.gestionAbonne.model.Contrat;
import com.testCanal.gestionAbonne.model.Mouvement;
import com.testCanal.gestionAbonne.service.MouvementService;
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
public class MouvementController {
    //autowired the StudentService class
    @Autowired
    MouvementService mouvementService;

    //Récupérer l'historique des modifications d’un abonné
    @GetMapping("/abonneGetModifications/{id}")
    private List<Mouvement> getAbonneModifications(@PathVariable("id") int abonneId)
    {
        return mouvementService.getAbonneMouvements(abonneId);
    }
}
