package com.example.demo.Service;
import com.example.demo.bean.Achat;
import com.example.demo.bean.Produit;
import com.example.demo.dao.AchatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class AchatService {


    public Achat findByRef(String Ref) {
        return achatDao.findByRef(Ref);
    }
@Transactional
    public int deleteByRef(String Ref) {


    return achatDao.deleteByRef(Ref);
    }
    public List<Achat> findAll() {
        return achatDao.findAll();
    }

    public int acheter(String magasin,List<String> produits) {
        double prixHt=0;
        double prixTTc;
        Achat achat=new Achat();
        achat.setRef(UUID.randomUUID().toString());
        for (String produit: produits) {
            double prixunitaire=fournisseurService.findByProduitRef(produit).getPrixUnitaire();
            Produit produit1=produitService.findByRef(produit);
            double qte= (produit1.getQteSeuilAlert())*3;
            achatproduitService.achatproduit(produit,magasin,qte,achat.getRef());
            prixHt+=prixunitaire*qte;
        }
        prixTTc=prixHt*1.196;
        achat.setPrixHt(prixHt);
        achat.setPrixTtc(prixTTc);
        achatDao.save(achat);
        return 1;
    }
   //
    @Autowired
    private  ProduitService produitService;

    @Autowired
    private  AchatproduitService achatproduitService;
    @Autowired
    private  AchatDao achatDao;
    @Autowired
    private  FournisseurService fournisseurService;
}
