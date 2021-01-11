package com.testCanal.gestionAbonne.service;

import com.testCanal.gestionAbonne.model.Abonne;
import com.testCanal.gestionAbonne.model.Contrat;
import com.testCanal.gestionAbonne.model.Mouvement;
import com.testCanal.gestionAbonne.repository.MouvementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MouvementService {
    @Autowired
    MouvementRepository mouvementRepository;

    //créer ou modifier un mouvement
    public void saveOrUpdate(Mouvement mouvement)
    {
        mouvementRepository.save(mouvement);
    }

    //trouver les mouvements d'un abonné
    public List<Mouvement> getAbonneMouvements(int AbonneId)
    {
        return mouvementRepository.findMouvementsByAbonne_Id(AbonneId);
    }
}
