package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Achat {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String refFournisseur;
    private double prixHt;
    private double prixTtc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getRefFournisseur() {
        return refFournisseur;
    }

    public void setRefFournisseur(String refFournisseur) {
        this.refFournisseur = refFournisseur;
    }

    public double getPrixHt() {
        return prixHt;
    }

    public void setPrixHt(double prixHt) {
        this.prixHt = prixHt;
    }

    public double getPrixTtc() {
        return prixTtc;
    }

    public void setPrixTtc(double prixTtc) {
        this.prixTtc = prixTtc;
    }
}
