package com.example.demo.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class OperationStock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descrition;
    @ManyToOne
    private Magasin magasinSource;
    @ManyToOne
    private Magasin magasinDestination;
    @ManyToOne
    private Produit produit;
    private double qte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public Magasin getMagasinSource() {
        return magasinSource;
    }

    public void setMagasinSource(Magasin magasinSource) {
        this.magasinSource = magasinSource;
    }

    public Magasin getMagasinDestination() {
        return magasinDestination;
    }

    public void setMagasinDestination(Magasin magasinDestination) {
        this.magasinDestination = magasinDestination;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public double getQte() {
        return qte;
    }

    public void setQte(double qte) {
        this.qte = qte;
    }
}
