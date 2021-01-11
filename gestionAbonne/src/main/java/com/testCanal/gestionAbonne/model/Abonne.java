package com.testCanal.gestionAbonne.model;

import javax.persistence.*;

//Entity
@Entity
//Table name
@Table
public class Abonne
{
    //primary key
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    //column name
    @Column
    private int id;
    //column name
    @Column
    private String nom;
    //column name
    @Column
    private String prenom;
    //column name
    @Column
    private String adressePrincipale;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdressePrincipale() {
        return adressePrincipale;
    }

    public void setAdressePrincipale(String adressePrincipale) {
        this.adressePrincipale = adressePrincipale;
    }
}
