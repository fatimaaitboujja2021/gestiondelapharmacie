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
    private double qteDeffectueuse;
    private String libelle;
    private String type;
    private String  ref;
    @ManyToOne
    private Stock stock;


    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public double getQteDeffectueuse() {
        return qteDeffectueuse;
    }

    public void setQteDeffectueuse(double qteDeffectueuse) {
        this.qteDeffectueuse = qteDeffectueuse;
    }

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

   /* public List<Magasin> getMagasin() {
        return magasin;
    }

    public void setMagasin(List<Magasin> magasin) {
        this.magasin = magasin;
    }*/
}
