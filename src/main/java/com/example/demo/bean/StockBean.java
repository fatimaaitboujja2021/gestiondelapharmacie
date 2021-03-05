package com.example.demo.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
public class StockBean implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<Produit> produit;
    @OneToOne
    private Magasin magasin;
    private double qte;
    private double qteDeffectueuse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Produit> getProduit() {
        return produit;
    }

    public void setProduit(List<Produit> produit) {
        this.produit = produit;
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
}
