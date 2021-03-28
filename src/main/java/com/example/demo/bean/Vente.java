package com.example.demo.bean;

import javax.persistence.*;

@Entity
public class Vente {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String ref;
    @ManyToOne
    private Client client;
    private double prixHt;
    private double prixTtc;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
