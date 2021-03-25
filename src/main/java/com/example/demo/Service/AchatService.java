package com.example.demo.Service;
import com.example.demo.bean.Achat;
import com.example.demo.bean.Magasin;
import com.example.demo.bean.Produit;
import com.example.demo.dao.AchatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public int save(String magasin,List<String> produits) {
        Magasin magasin1=magasinService.findByReference(magasin);
        for (String produit: produits) {
            Produit produit1=produitService.findByRef(produit);
        }
       // achatDao.save(magasin,produits);
        return 1;
    }
   //
    @Autowired
    private  ProduitService produitService;
@Autowired
private MagasinService magasinService;
@Autowired
private AchatproduitService achatproduitService;
    @Autowired
    private AchatDao achatDao;
}
