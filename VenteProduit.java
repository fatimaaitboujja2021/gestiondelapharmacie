package com.example.demo.bean;
import com.example.demo.bean.Produit;

import javax.persistence.*;

@Entity
public class VenteProduit {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    @ManyToOne
    private Produit produit;
    @ManyToOne
    private Vente vente;
    private double qte;
    @ManyToOne
    private Magasin magasin;

    public Vente getVente() {
        return vente;
    }

    public void setVente(Vente vente) {
        this.vente = vente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }
}
