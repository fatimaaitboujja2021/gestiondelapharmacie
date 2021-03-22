package com.example.demo.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Produit produit;
    @ManyToOne
    private Magasin magasin;
    private double qte;
    private double qteDeffectueuse;//methode

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public double getQte() {
        return qte;
    }

    public void setQte(double qte) {
        this.qte = qte;
    }

    public double getQteDeffectueuse() {
        return qteDeffectueuse;
    }

    public void setQteDeffectueuse(double qteDeffectueuse) {
        this.qteDeffectueuse = qteDeffectueuse;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
