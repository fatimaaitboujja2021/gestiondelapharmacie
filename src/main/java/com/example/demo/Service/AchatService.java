package com.example.demo.Service;

import com.example.demo.bean.*;
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
        Achat achat = findByRef(Ref);
        List<Achatproduit> achatproduits = achatproduitService.findByAchatRef(Ref);
        for (Achatproduit achatproduit : achatproduits) {
            achatproduitService.deleteByProduitRefAndAchatRef(achatproduit.getProduit().getRef(), Ref);

        }
        return achatDao.deleteByRef(Ref);
    }

    public List<Achat> findAll() {
        return achatDao.findAll();
    }


    public int save(Achat achat) {
        List<Achatproduit> achatproduits=achatproduitService.findByAchatRef(achat.getRef());

        if (findByRef(achat.getRef()) != null) {
            return -1;
        }else{
            Achat achat1=new Achat();

            achat1.setRef(achat.getRef());
            achat1.setPrixHt(achat.getPrixHt());
            achat1.setPrixTtc(achat.getPrixTtc());
            achatDao.save(achat1);


            for (Achatproduit achatproduit : achatproduits) {
               achatproduit.setAchat(achat1);
               achatproduitService.save(achatproduit);
            }

            return 1;
        }

    }


    @Autowired
    private ProduitService produitService;

    @Autowired
    private AchatproduitService achatproduitService;
    @Autowired
    private AchatDao achatDao;
    @Autowired
    private FournisseurService fournisseurService;
}
