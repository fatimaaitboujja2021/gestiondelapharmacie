package com.example.demo.Service;

import com.example.demo.bean.Magasin;
import com.example.demo.bean.OperationStock;
import com.example.demo.bean.Produit;
import com.example.demo.bean.Stock;
import com.example.demo.dao.MagasinDao;
import com.example.demo.dao.OperationStockDao;
import com.example.demo.dao.ProduitDao;
import com.example.demo.dao.StockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class OperationStockService {
    @Autowired
    private OperationStockDao operationStockDao;
    @Autowired
    private StockDao stokage;
    @Autowired
    private MagasinDao magasinDao;
    @Autowired
    private ProduitDao produitDao;
    public List<OperationStock> findByMagasinDestinationReference(String magasindestinationreference) {
        return operationStockDao.findByMagasinDestinationReference(magasindestinationreference);
    }

    public List<OperationStock> findByMagasinSourceReference(String magasinsourcereference) {
        return operationStockDao.findByMagasinSourceReference(magasinsourcereference);
    }

    public List<OperationStock> findByMagasinDestinationReferenceAndMagasinSourceReference(String magasindestinationreference, String magasinsourcereference) {
        return operationStockDao.findByMagasinDestinationReferenceAndMagasinSourceReference(magasindestinationreference, magasinsourcereference);
    }

    public List<OperationStock> findByProduitRef(String refProduit) {
        return operationStockDao.findByProduitRef(refProduit);
    }

    public List<OperationStock> findByMagasinDestinationReferenceAndMagasinSourceReferenceAndProduitRef(String magasindestinationreference, String magasinsourcereference, String refProduit) {
        return operationStockDao.findByMagasinDestinationReferenceAndMagasinSourceReferenceAndProduitRef(magasindestinationreference, magasinsourcereference, refProduit);
    }

    public List<OperationStock> findAll() {
        return operationStockDao.findAll();
    }
    @Transactional
    public void deleteById(Long id) {
        operationStockDao.deleteById(id);
    }

    public int transporterleStock(String refmagasinSource, String refmagasinDestination, double qte, String refproduit){
       Stock  magasinSource=stokage.findByMagasinReferenceAndProduitRef(refmagasinSource,refproduit);
       Stock magasinDestination=stokage.findByMagasinReferenceAndProduitRef(refmagasinDestination,refproduit);
       Magasin magasinsource=magasinDao.findByReference(refmagasinSource);
       Magasin magasindestination=magasinDao.findByReference(refmagasinDestination);
       Produit produit=produitDao.findByRef(refproduit);
       double produitqtesrc=magasinSource.getQte();
       double produitqtedes =magasinDestination.getQte();
       if(magasinDestination!=null && magasinSource!=null && produitqtesrc>qte){
           magasinSource.setQte(produitqtesrc-qte);
           magasinDestination.setQte(produitqtedes+qte);
            OperationStock transport=new OperationStock();
            transport.setQte(qte);
            transport.setDescrition("transport "+qte+" de "+refproduit+" de magasin "+refmagasinSource+" a le magasin "+refmagasinDestination);
            transport.setProduit(produit);
            transport.setMagasinDestination(magasindestination);
            transport.setMagasinSource(magasinsource);
            operationStockDao.save(transport);
           return 1;
       }
      else return -2;
    }



}
