package com.testCanal.gestionAbonne.model;

import javax.persistence.*;

//Entity
@Entity
//Table name
@Table
public class Contrat {
    //primary key
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    //column name
    @Column
    private int id;
    //column name
    @Column
    private String adresse;
    //column name
    @ManyToOne
    @JoinColumn
    private Abonne abonne;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }
}
