package com.example.demo.Service;

import com.example.demo.bean.Magasin;
import com.example.demo.bean.OperationStock;
import com.example.demo.bean.Produit;
import com.example.demo.bean.Stock;
import com.example.demo.dao.OperationStockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class OperationStockService {
    @Autowired
    private OperationStockDao operationStockDao;
    @Autowired
    private StockService stokage;
    @Autowired
    private MagasinService magasinService;
    @Autowired
    private ProduitService produitService;
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

    public int transferer(String refSource, String refDestination, String refProduit, double qte) {
        Magasin magasinSource = magasinService.findByReference(refSource);
        Magasin magasinDestination = magasinService.findByReference(refDestination);
        Produit produit = produitService.findByRef(refProduit);

        if (produit == null || magasinSource == null || magasinDestination == null)
            return -1;

        Stock stockSource = stokage.findByMagasinReferenceAndProduitRef(refSource, refProduit);

        if (stockSource == null) {
            return -2;
        } else {
            Stock stockDestination = stokage.findByMagasinReferenceAndProduitRef(refSource, refProduit);
            if (stockDestination == null) {

                Stock myStock = new Stock();
                myStock.setMagasin(magasinDestination);
                myStock.setProduit(produit);
                myStock.setQte(qte);
                stokage.savestockage(myStock);
                return 1;
            } else {
                stockDestination.setQte(stockDestination.getQte() + qte);
                stokage.savestockage(stockDestination);
                stockSource.setQte(stockSource.getQte()-qte);
                OperationStock transport=new OperationStock();
                transport.setQte(qte);
                transport.setDescrition("transport "+qte+" de "+refProduit+" de magasin "+refSource+" a le magasin "+refDestination);
                transport.setProduit(produit);
                transport.setMagasinDestination(magasinDestination);
                transport.setMagasinSource(magasinSource);
                operationStockDao.save(transport);
                return 2;
            }

        }
    }
    public int soustractionDeLaquantiteDefectueuse(Stock stock){
        if(stock==null){
            return -2;
        }
        else {
            if(stock.getQte()<stock.getQteDeffectueuse()){
                return -1;
            }
            else{
                stock.setQte(stock.getQte()-stock.getQteDeffectueuse());
                return 0;
            }
        }
    }

}
