package com.example.demo.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pharmacie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    private String libelle;
    @ManyToOne
    private Rue rue;
    @OneToMany
    private List<Magasin> magasin;

    public List<Magasin> getMagasin() {
        return magasin;
    }

    public void setMagasin(List<Magasin> magasin) {
        this.magasin = magasin;
    }

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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
