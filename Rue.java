package com.example.demo.bean;

import com.example.demo.bean.Magasin;

import javax.persistence.*;
import java.util.List;

@Entity
public class Rue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String libelle;

    @OneToMany
    private List<Magasin> magasin;

    public List<Magasin> getMagasin() {
        return magasin;
    }

    public void setMagasin(List<Magasin> magasin) {
        this.magasin = magasin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String  getCode() {
        return code;
    }

    public void setCode(String  code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
