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
        Magasin magasin =magasinService.findByReference(referenceMagasin);
        List<Stock> stockList=findByMagasinReference(referenceMagasin);
        if(magasin!=null) {
            for (Stock stock : stockList) {
                operationStockService.soustractionDeLaquantiteDefectueuse(stock);
                String produitref=stock.getProduit().getRef();
                Stock stock1=ordreDeMagasinStock(referenceMagasin,produitref);
                String magasindes=stock1.getMagasin().getReference();
                if (stock.getQte() > 0) {
                    operationStockService.transferer(referenceMagasin,magasindes,produitref,stock.getQte());
                }
                deleteByProduitRefAndMagasinReference(stock.getProduit().getRef(), referenceMagasin);
            }
            return 1;
        }
        else return -2;
    }

    Stock ordreDeMagasinStock(String refmagasin,String refProduit){
        Magasin magasin=magasinService.findByReference(refmagasin);
        List<Magasin> magasins=magasinService.findByPharmacieRefrence(magasin.getPharmacie().getRefrence());
        HashMap<Long,Double> stockList=new HashMap<>();
        String reference=magasin.getReference();
        for (Magasin magasine:magasins) {
            if (!reference.equals(magasine.getReference())){
                Stock stock=findByMagasinReferenceAndProduitRef(magasine.getReference(),refProduit);
                operationStockService.soustractionDeLaquantiteDefectueuse(stock);
                stockList.put(stock.getId(),stock.getQte());
            }
        }
        Map.Entry<Long, Double> maxEntry = null;
        for (Map.Entry<Long, Double> entry : stockList.entrySet())
        {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
            }
        }
        return stockDao.findByIdAndQte(maxEntry.getKey(),maxEntry.getValue());
    }
    @Transactional
    public int deleteByProduitRefAndMagasinReference(String refProduit, String referenceMagasin) {
        Stock stock=findByMagasinReferenceAndProduitRef(referenceMagasin, refProduit);
        List<Magasin> magasins=magasinService.findByPharmacieRefrence(magasinService.findByReference(referenceMagasin).getPharmacie().getRefrence());
        if (stock.getQte() >0){
            for (Magasin curseur : magasins) {
                Stock findMagProd=findByMagasinReferenceAndProduitRef(curseur.getReference(),refProduit);
                if (findMagProd.getQte() >= 0 && !referenceMagasin.equals(curseur.getReference())) {
                    findMagProd.setQte(findMagProd.getQte()+stock.getQte());
                    stock.setQte(0);
                    break;
                }
            }
        }
        produitService.deleteByRef(refProduit);
        magasinService.deleteByReference(referenceMagasin);
        return deleteByProduitRefAndMagasinReference(refProduit, referenceMagasin);
    }

    public int savestockage(Stock stockage) {
        Produit produit = produitService.findByRef(stockage.getProduit().getRef());
        Magasin magasin = magasinService.findByReference(stockage.getMagasin().getReference());
        Stock stockBean = findByMagasinReferenceAndProduitRef(stockage.getProduit().getRef(), stockage.getMagasin().getReference());

        if(stockBean==null){
            Stock myStockBean= new Stock();
            myStockBean.setProduit(produit);
            myStockBean.setMagasin(magasin);
            myStockBean.setQte(stockage.getQte());
            stockDao.save(myStockBean);
            return 1;
        }else{
            stockBean.setQte(stockBean.getQte()+stockage.getQte());
            stockDao.save(stockBean);
            return 2;
        }
    }
    public void checkredLine(Stock stock){
        Produit produit =produitService.findByRef(stock.getProduit().getRef());
        Magasin magasin = magasinService.findByReference(stock.getMagasin().getReference());
        double redline= produit.getQteSeuilAlert();
        operationStockService.soustractionDeLaquantiteDefectueuse(stock);//pour trouve la quantite reel
        if(redline>stock.getQte()){
            double qte=redline*3;
           // achatproduitService.acheteproduit(produit,magasin,qte);
        }
    }

    @Autowired
    private StockDao stockDao;
    @Autowired
    private ProduitService produitService;
    @Autowired
    private MagasinService magasinService;
    @Autowired
    private AchatproduitService achatproduitService;
    @Autowired
    private OperationStockService operationStockService;
}
