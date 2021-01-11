package com.testCanal.gestionAbonne.service;

import com.testCanal.gestionAbonne.model.Abonne;
import com.testCanal.gestionAbonne.repository.AbonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbonneService {
    @Autowired
    AbonneRepository abonneRepository;

    //créer ou modifier un abonné
    public void saveOrUpdate(Abonne abonne)
    {
        abonneRepository.save(abonne);
    }

    //trouver un abonné
    public Abonne getAbonneById(int id)
    {
        return abonneRepository.findById(id).get();
    }

}
