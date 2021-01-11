package com.testCanal.gestionAbonne.controller;

import java.util.Date;
import java.util.List;

import com.testCanal.gestionAbonne.model.Abonne;
import com.testCanal.gestionAbonne.model.Contrat;
import com.testCanal.gestionAbonne.model.Mouvement;
import com.testCanal.gestionAbonne.model.types.TypeModification;
import com.testCanal.gestionAbonne.service.AbonneService;
import com.testCanal.gestionAbonne.service.ContratService;
import com.testCanal.gestionAbonne.service.MouvementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//creating RestController
@RestController
public class AbonneController
{
    //autowired the AbonneService class
    @Autowired
    AbonneService abonneService;

    //autowired the MouvementService class
    @Autowired
    MouvementService mouvementService;

    //autowired the ContratService class
    @Autowired
    ContratService contratService;

    //autowired the Mouvement class
    @Autowired
    Mouvement mouvement;

    //creer un nouvel abonné
    @PostMapping("/abonne")
    private int creerAbonner(@RequestBody Abonne abonne)
    {
        abonneService.saveOrUpdate(abonne);
        return abonne.getId();
    }

    //Modifier l'adresse de l'abonné scénario 1
    @PostMapping("/ModifierAdresseSC1")
    private Abonne modifierAdresseSC1(@RequestBody Abonne abonne)
    {
        //Modifier l'adresse de l'abonné
        Abonne abonneAmodifier = abonneService.getAbonneById(abonne.getId());
        String ancienneAdresse = abonneAmodifier.getAdressePrincipale();
        abonneAmodifier.setAdressePrincipale(abonne.getAdressePrincipale());
        abonneService.saveOrUpdate(abonneAmodifier);

        // il faut créer un nouveau mouvement
        mouvement.setTypeModification(TypeModification.MODIFICATION_ADRESSE_PRINCIPALE);
        mouvement.setDate(new Date());
        mouvement.setAncienneValeur(ancienneAdresse);
        mouvement.setNouvelleValeur(abonne.getAdressePrincipale());
        mouvement.setAbonne(abonne);
        mouvementService.saveOrUpdate(mouvement);

        // il faut mettre à jour tous les contrats
        List<Contrat> contrats = contratService.getAbonneContrats(abonne.getId());
        for (Contrat c : contrats) c.setAdresse(abonne.getAdressePrincipale());
        contratService.updateContrats(contrats);

        return abonneAmodifier;
    }

    //Modifier l'adresse de l'abonné scénario 2
    @PostMapping("/ModifierAdresseSC2")
    private Abonne modifierAdresseSC2(@RequestBody Abonne abonne)
    {
        //Modifier l'adresse de l'abonné
        Abonne abonneAmodifier = abonneService.getAbonneById(abonne.getId());
        String ancienneAdresse = abonneAmodifier.getAdressePrincipale();
        abonneAmodifier.setAdressePrincipale(abonne.getAdressePrincipale());
        abonneService.saveOrUpdate(abonneAmodifier);

        // il faut mettre à jour le premier contrat
        Contrat contrat = contratService.getAbonneFirstContrat(abonne.getId());
        contrat.setAdresse(abonne.getAdressePrincipale());
        contratService.saveOrUpdate(contrat);

        // il faut créer un nouveau mouvement
        mouvement.setTypeModification(TypeModification.MODIFICATION_ADRESSE_PRINCIPALE);
        mouvement.setDate(new Date());
        mouvement.setAncienneValeur(ancienneAdresse);
        mouvement.setNouvelleValeur(abonne.getAdressePrincipale());
        mouvement.setAbonne(abonne);
        mouvement.setContrat(contrat);
        mouvementService.saveOrUpdate(mouvement);

        return abonneAmodifier;
    }
}
