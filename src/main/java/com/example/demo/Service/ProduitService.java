package com.example.demo.Service;


import com.example.demo.bean.Produit;
import com.example.demo.dao.ProduitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class ProduitService {

    public List<Produit> findByType(String type) {
        return produitDao.findByType(type);
    }

    public Produit findByRef(String refProduit) {
        return produitDao.findByRef(refProduit);
    }
    @Transactional
    public int deleteByRef(String refProduit) {
        return produitDao.deleteByRef(refProduit);
    }


    public Produit findByLibelle(String libelle) {
        return produitDao.findByLibelle(libelle);
    }

    public Produit findByLibelleAndType(String Libelle, String type) {
        return produitDao.findByLibelleAndType(Libelle, type);
    }

    @Transactional
    public int deleteByLibelle(String libelle) {
        return produitDao.deleteByLibelle(libelle);
    }
    @Transactional

    public List<Produit> findAll() {
        return produitDao.findAll();
    }


    @Autowired
    private ProduitDao produitDao;

    public int save(Produit produit) {
        Produit foundedProduit =findByRef(produit.getRef());

        if(foundedProduit != null){
            return -1;
        }
        else{
            produitDao.save(produit);
            return 1;
        }
    }
}

