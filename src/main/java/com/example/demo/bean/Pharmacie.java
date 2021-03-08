package com.example.demo.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pharmacie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String refrence;
    private String libelle;
    @ManyToOne
    private Rue rue;

    public Rue getRue() {
        return rue;
    }

    public void setRue(Rue rue) {
        this.rue = rue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefrence() {
        return refrence;
    }

    public void setRefrence(String refrence) {
        this.refrence = refrence;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
