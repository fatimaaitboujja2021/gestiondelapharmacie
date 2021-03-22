package com.example.demo.Service;

import com.example.demo.bean.Achatproduit;
import com.example.demo.bean.Magasin;
import com.example.demo.bean.Produit;
import com.example.demo.bean.Stock;
import com.example.demo.dao.AchatproduitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AchatproduitService {
    public List<Achatproduit> findByProduitRef(String refProduit) {
        return achatproduitDao.findByProduitRef(refProduit);
    }

    public List<Achatproduit> deleteByProduitRef(String refProduit) {
        return achatproduitDao.deleteByProduitRef(refProduit);
    }

    public List<Achatproduit> deleteByProduitRefAndAchatRef(String refProduit, String refAchat) {
        return achatproduitDao.deleteByProduitRefAndAchatRef(refProduit, refAchat);
    }

    public List<Achatproduit> findByProduitRefAndAchatRef(String refProduit, String refAchat) {
        return achatproduitDao.findByProduitRefAndAchatRef(refProduit, refAchat);
    }

    public List<Achatproduit> findByProduitRefAndMagasinReference(String refProduit, String refMagasin) {
        return achatproduitDao.findByProduitRefAndMagasinReference(refProduit, refMagasin);
    }

    public List<Achatproduit> findAll() {
        return achatproduitDao.findAll();
    }

    public int save(Achatproduit achatproduit) {
        if(achatproduit.getProduit().getRef()==null||findByProduitRef(achatproduit.getProduit().getRef())!=null)
            return -1;
                  else
                achatproduitDao.save(achatproduit);
                return 1;
    }
    /*public int acheteproduit(Produit produit, Magasin magasin, double qte){
        List<Fournisseur> fournisseur = fournisseurDao.findByProduitRef(produit.getRef());
        Stock stock = stockDao.findByMagasinReferenceAndProduitRef(magasin.getReference(),produit.getRef());
        for(Fournisseur curseur:fournisseur){

        }
        return 0;
    }*/
    @Autowired
    private AchatproduitDao achatproduitDao;
}
