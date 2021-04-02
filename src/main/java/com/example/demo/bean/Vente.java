package com.example.demo.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vente {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String ref;
    @ManyToOne
    private Client client;
    private double prixHt;
    private double prixTtc;
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "vente")
    private List<VenteProduit> venteProduits;


    public List<VenteProduit> getVenteProduits() {
        return venteProduits;
    }

    public void setVenteProduits(List<VenteProduit> venteProduits) {
        this.venteProduits = venteProduits;
    }
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
