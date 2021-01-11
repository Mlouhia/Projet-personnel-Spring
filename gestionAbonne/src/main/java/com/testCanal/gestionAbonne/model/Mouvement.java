package com.testCanal.gestionAbonne.model;

import javax.persistence.*;
import com.testCanal.gestionAbonne.model.types.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
//Entity
@Entity
//Table name
@Table
public class Mouvement {
    //primary key
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    //column name
    @Column
    private int id;
    //column name
    @ManyToOne
    @JoinColumn
    private Abonne abonne;
    //column name
    @ManyToOne
    @JoinColumn
    private Contrat contrat;
    @Enumerated(EnumType.STRING)
    //column name
    @Column
    private TypeModification typeModification;
    //column name
    @Column
    private Date date;
    //column name
    @Column
    private String ancienneValeur;
    //column name
    @Column
    private String nouvelleValeur;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }

    public TypeModification getTypeModification() {
        return typeModification;
    }

    public void setTypeModification(TypeModification typeModification) {
        this.typeModification = typeModification;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAncienneValeur() {
        return ancienneValeur;
    }

    public void setAncienneValeur(String ancienneValeur) {
        this.ancienneValeur = ancienneValeur;
    }

    public String getNouvelleValeur() {
        return nouvelleValeur;
    }

    public void setNouvelleValeur(String nouvelleValeur) {
        this.nouvelleValeur = nouvelleValeur;
    }
}
