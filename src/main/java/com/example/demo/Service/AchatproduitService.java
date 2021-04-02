package com.example.demo.Service;

import com.example.demo.bean.*;
import com.example.demo.dao.AchatproduitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class AchatproduitService {

    public List<Achatproduit> findByAchatRef(String ref) {
        return achatproduitDao.findByAchatRef(ref);
    }

    public List<Achatproduit> findByProduitRef(String ref) {
        return achatproduitDao.findByProduitRef(ref);
    }

    public Achatproduit findByProduitRefAndAchatRef(String refProduit, String ref) {
        return achatproduitDao.findByProduitRefAndAchatRef(refProduit, ref);
    }

    @Transactional
    public int deleteByProduitRefAndAchatRef(String refProduit, String ref) {
        Produit produit = produitService.findByRef(refProduit);
        Achat achat = achatService.findByRef(ref);
        Achatproduit achatproduit = findByProduitRefAndAchatRef(produit.getRef(), achat.getRef());
        Magasin magasin = magasinService.findByReference(achatproduit.getMagasin().getReference());
        Stock stock = stockService.findByMagasinReferenceAndProduitRef(magasin.getReference(), refProduit);
        if (achat != null) {
            if (achatproduit != null) {
                //  achat.setPrixHt(achat.getPrixHt()-achatproduit.getPrixUnitaire()*achatproduit.getQte());
                stock.setQte(stock.getQte() - achatproduit.getQte());

            }

        }

        return achatproduitDao.deleteByProduitRefAndAchatRef(refProduit, ref);
    }


    public List<Achatproduit> findAll() {
        return achatproduitDao.findAll();
    }


    public int save(Achatproduit achatproduit) {
        Produit produit = produitService.findByRef(achatproduit.getProduit().getRef());
        Magasin magasin = magasinService.findByReference(achatproduit.getMagasin().getReference());
        Achat achat = achatService.findByRef(achatproduit.getAchat().getRef());
        Stock stock = stockService.findByMagasinReferenceAndProduitRef(magasin.getReference(), produit.getRef());
        double prixunitaire = achatproduit.getPrixUnitaire();
        if (findByProduitRefAndAchatRef(produit.getRef(), achat.getRef()) != null) {
            return -1;
        } else {
            achatproduit = new Achatproduit();
            achatproduit.setAchat(achat);
            achatproduit.setMagasin(magasin);
            achatproduit.setProduit(produit);
            achatproduit.setQte(achatproduit.getQte());
            achatproduit.setPrixUnitaire(prixunitaire);
            achatproduit.setPrixTotal(prixunitaire * achatproduit.getQte());
            achatproduitDao.save(achatproduit);
            stock.setQte(achatproduit.getQte()+ stock.getQte());
            return 1;
        }


    }

    @Autowired
    private StockService stockService;
    @Autowired
    private ProduitService produitService;
    @Autowired
    private AchatproduitDao achatproduitDao;
    @Autowired
    private MagasinService magasinService;
    @Autowired
    private AchatService achatService;
    @Autowired
    private FournisseurService fournisseurService;


}
