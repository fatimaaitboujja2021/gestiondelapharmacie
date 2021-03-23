package com.example.demo.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private double id;
    private String ref;
@OneToMany
private List<Achatproduit> achatproduit;

    public List<Achatproduit> getAchatproduit() {
        return achatproduit;
    }

    public void setAchatproduit(List<Achatproduit> achatproduit) {
        this.achatproduit = achatproduit;
    }

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
