package com.example.demo.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private double id;
    private String ref;

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
}
