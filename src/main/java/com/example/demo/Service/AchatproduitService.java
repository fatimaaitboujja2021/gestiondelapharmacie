package com.example.demo.Service;

import com.example.demo.bean.*;
import com.example.demo.dao.AchatproduitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
public class AchatproduitService {


    public List<Achatproduit> findByProduitRef(String ref) {
        return achatproduitDao.findByProduitRef(ref);
    }

    public Achatproduit findByProduitRefAndAchatRef(String refProduit, String ref) {
        return achatproduitDao.findByProduitRefAndAchatRef(refProduit, ref);
    }
@Transactional
    public int deleteByAchatRef(String ref) {

        return achatproduitDao.deleteByAchatRef(ref);
    }
@Transactional
    public int deleteByProduitRefAndAchatRef(String refProduit, String ref) {

        return achatproduitDao.deleteByProduitRefAndAchatRef(refProduit, ref);
    }

    public List<Achatproduit> findAll() {
        return achatproduitDao.findAll();
    }

    public int  achatproduit(String refproduit,String refMagasin,double qte,String refAchat) {
    Produit produit=produitService.findByRef(refproduit);
    Magasin magasin =magasinService.findByReference(refMagasin);
    Achat achat=achatService.findByRef(refAchat);
    Achatproduit achatproduit=findByProduitRefAndAchatRef(refproduit,refAchat);
    Stock stock=stockService.findByMagasinReferenceAndProduitRef(refMagasin,refproduit);
    double prixunitaire=fournisseurService.findByProduitRef(produit.getRef()).getPrixUnitaire();
        if(achatproduit==null)
        return -2;
    else {
        Achatproduit achatproduit1=new Achatproduit();
        achatproduit1.setAchat(achat);
        achatproduit1.setMagasin(magasin);
        achatproduit1.setProduit(produit);
        achatproduit1.setQte(qte);
        achatproduit1.setPrixUnitaire(prixunitaire);
        achatproduit1.setPrixTotal(prixunitaire*qte);
        achatproduitDao.save(achatproduit1);
        stock.setQte(qte+stock.getQte());
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
    private  FournisseurService fournisseurService;

}
