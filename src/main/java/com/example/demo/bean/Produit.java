package com.example.demo.bean;

import javax.persistence.*;
import java.util.List;
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double qteTotalStock;
    private double qteSeuilAlert;
    private String libelle;
    private String type;
    private String  ref;
     @ManyToMany
    private List<Magasin> magasin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getQteTotalStock() {
        return qteTotalStock;
    }

    public void setQteTotalStock(double qteTotalStock) {
        this.qteTotalStock = qteTotalStock;
    }

    public double getQteSeuilAlert() {
        return qteSeuilAlert;
    }

    public void setQteSeuilAlert(double qteSeuilAlert) {
        this.qteSeuilAlert = qteSeuilAlert;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public List<Magasin> getMagasin() {
        return magasin;
    }

    public void setMagasin(List<Magasin> magasin) {
        this.magasin = magasin;
    }
}
