package com.example.demo.Service;

import com.example.demo.bean.Achatproduit;
import com.example.demo.bean.Magasin;
import com.example.demo.bean.Produit;
import com.example.demo.bean.Stock;
import com.example.demo.dao.AchatproduitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
public class AchatproduitService {


    public Achatproduit findByProduitRef(String ref) {
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

    public int   save(Achatproduit achatproduit) {

        if (findByProduitRefAndAchatRef(achatproduit.getProduit().getRef(),achatproduit.getAchat().getRef())!=null)
        {
            return -1;
        }
        else {

            Magasin magasin=magasinService.findByReference(achatproduit.getMagasin().getReference());
            Produit produit=produitService.findByRef(achatproduit.getProduit().getRef());
            Stock stock=stockService.findByMagasinReferenceAndProduitRef(magasin.getReference(),produit.getRef());
            stock.setQte(stock.getQte()+achatproduit.getQte());
            Achatproduit achatproduit1=new Achatproduit();
            achatproduit1.setMagasin(magasin);
            achatproduit1.setProduit(produit);
            achatService.save(achatproduit.getAchat());
            achatproduitDao.save(achatproduit);

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

}
