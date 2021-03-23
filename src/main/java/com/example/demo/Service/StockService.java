package com.example.demo.Service;
import com.example.demo.bean.Magasin;
import com.example.demo.bean.Produit;
import com.example.demo.bean.Stock;
import com.example.demo.dao.MagasinDao;
import com.example.demo.dao.ProduitDao;
import com.example.demo.dao.StockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class StockService {
    @Autowired
    private StockDao stockDao;
    @Autowired
    private ProduitDao produitDao;
    @Autowired
    private MagasinDao magasinDao;
    @Autowired
    private AchatproduitService achatproduitService;
    public List<Stock> findByProduitRef(String refProduit) {
        return stockDao.findByProduitRef(refProduit);
    }

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
        List<Stock> stock =findByMagasinReference(referenceMagasin);
        List<Magasin>magasin= magasinDao.findByPharmacieReference(magasinDao.findByReference(referenceMagasin).getPharmacie().getReference());
        if (stock != null) {
            for(Stock curseur:stock){
                if (curseur.getProduit().getQteTotalStock() > 0) {
                    for (Magasin curser : magasin) {
                        Stock findMagProd=findByMagasinReferenceAndProduitRef(curser.getReference(),curseur.getProduit().getRef());
                        if (findMagProd.getQte() >= 0 && !referenceMagasin.equals(curser.getReference())) {
                            findMagProd.setQte(findMagProd.getQte()+curseur.getQte());
                            curseur.setQte(0);
                            break;
                        }
                        produitDao.deleteByRef(curseur.getProduit().getRef());
                    }
                    return 1;
                }
            }
            magasinDao.deleteByReference(referenceMagasin);
            return stockDao.deleteByMagasinReference(referenceMagasin);
        }
        else return -2;

    }

    @Transactional
    public int deleteByProduitRefAndMagasinReference(String refProduit, String referenceMagasin) {
        Stock stock=findByMagasinReferenceAndProduitRef(referenceMagasin, refProduit);
        List<Magasin> magasins=magasinDao.findByPharmacieReference(magasinDao.findByReference(referenceMagasin).getPharmacie().getReference());
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
        produitDao.deleteByRef(refProduit);
        magasinDao.deleteByReference(referenceMagasin);
        return deleteByProduitRefAndMagasinReference(refProduit, referenceMagasin);
    }

    public int savestockage(Stock stockage) {
        Produit produit = produitDao.findByRef(stockage.getProduit().getRef());
        Magasin magasin = magasinDao.findByReference(stockage.getMagasin().getReference());
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
        Produit produit =produitDao.findByRef(stock.getProduit().getRef());
        Magasin magasin = magasinDao.findByReference(stock.getMagasin().getReference());
        double redline= produit.getQteSeuilAlert();
        if(redline>stock.getQte()){
            double qte=redline*3;
            //achatproduitService.acheteproduit(produit,magasin,qte);
        }
    }

}
