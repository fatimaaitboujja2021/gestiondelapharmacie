package com.example.demo.Service;
import com.example.demo.bean.Achat;
import com.example.demo.bean.Achatproduit;
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
       Achat achat=findByRef(Ref);
       List<Achatproduit> achatproduits=achatproduitService.findByAchatRef(Ref);
    for (Achatproduit achatproduit: achatproduits ) {
                 achatproduitService.deleteByProduitRefAndAchatRef(achatproduit.getProduit().getRef(),Ref);

    }
    return achatDao.deleteByRef(Ref);
    }

    public List<Achat> findAll() {
        return achatDao.findAll();
    }

    public int acheter(Achat achat,String magasin,List<String> produits) {
        double prixHt=0;
        double prixTTc;
        achat=findByRef(achat.getRef());
        if(achat!=null)
        {
            return -1;
        }
        else {
            for (String refproduit: produits) {
                double prixunitaire=fournisseurService.findByProduitRef(refproduit).getPrixUnitaire();
                Produit produit1=produitService.findByRef(refproduit);
                double qte= (produit1.getQteSeuilAlert())*3;
                achatproduitService.achatproduit(refproduit,magasin,qte,achat.getRef());
                prixHt+=prixunitaire*qte;
            }
            prixTTc=prixHt*1.196;
            achat.setPrixHt(prixHt);
            achat.setPrixTtc(prixTTc);
            achatDao.save(achat);
            return 1;
        }

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
