package com.example.demo.Service;
import com.example.demo.bean.Magasin;
import com.example.demo.bean.Produit;
import com.example.demo.bean.Stock;
import com.example.demo.dao.StockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class StockService {

    public List<Stock> findByProduitRef(String refProduit) {
        return stockDao.findByProduitRef(refProduit);
    }
    //recherche multi critere recherche de ref
    //recherche qte stock max min =redline ref

    public List<Stock> findByMagasinReference(String reference) {
        return stockDao.findByMagasinReference(reference);
    }

    public Stock findByMagasinReferenceAndProduitRef(String reference, String refProduit) {
        return stockDao.findByMagasinReferenceAndProduitRef(reference, refProduit);
    }

    public List<Stock> findAll() {
        return stockDao.findAll();
    }
    @Transactional
    public int deleteByMagasinReference(String referenceMagasin) {
      return stockDao.deleteByMagasinReference(referenceMagasin);
    }
    @Transactional
    public int deleteByProduitRefAndMagasinReference(String refProduit, String referenceMagasin) {
        return stockDao.deleteByProduitRefAndMagasinReference(refProduit, referenceMagasin);
    }

    public int savestockage(Stock stockage) {
        Produit produit = produitService.findByRef(stockage.getProduit().getRef());
        Magasin magasin = magasinService.findByReference(stockage.getMagasin().getReference());
        Stock stockBean = findByMagasinReferenceAndProduitRef(stockage.getMagasin().getReference(), stockage.getProduit().getRef());
        if(magasin==null) return -2;
        if(stockBean==null){
            Stock myStockBean= new Stock();
            myStockBean.setProduit(produit);
            myStockBean.setMagasin(magasin);
            myStockBean.setQte(stockage.getQte());
            myStockBean.setQteDeffectueuse(stockage.getQteDeffectueuse());
            stockDao.save(myStockBean);
            return 1;
        }else{
            stockBean.setQte(stockBean.getQte()+stockage.getQte());
            stockBean.setQteDeffectueuse(stockBean.getQteDeffectueuse()+stockage.getQteDeffectueuse());
            stockDao.save(stockBean);
            return 2;
        }
    }

    @Autowired
    private StockDao stockDao;
    @Autowired
    private ProduitService produitService;
    @Autowired
    private MagasinService magasinService;
}
