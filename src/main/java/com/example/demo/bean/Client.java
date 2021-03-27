package com.example.demo.bean;

import javax.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private double id;
    private String ref;
    @ManyToOne
    private Magasin magasin;

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }
}
