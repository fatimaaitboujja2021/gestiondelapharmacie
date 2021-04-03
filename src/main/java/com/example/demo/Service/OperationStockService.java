package com.example.demo.Service;

import com.example.demo.bean.Magasin;
import com.example.demo.bean.OperationStock;
import com.example.demo.bean.Produit;
import com.example.demo.bean.Stock;
import com.example.demo.dao.OperationStockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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

    public List<OperationStock> trouve(String refproduit, String refmagasin) {
        return operationStockDao.trouve(refproduit, refmagasin);
    }

    public List<OperationStock> findAll() {
        return operationStockDao.findAll();
    }

    public int transferer(OperationStock operationStock) {
        Magasin magasinSource = magasinService.findByReference(operationStock.getMagasinSource().getReference());
        Magasin magasinDestination = magasinService.findByReference(operationStock.getMagasinDestination().getReference());
        Produit produit = produitService.findByRef(operationStock.getProduit().getRef());

        if (produit == null || magasinSource == null || magasinDestination == null)
            return -1;

        Stock stockSource = stokage.findByMagasinReferenceAndProduitRef(operationStock.getMagasinSource().getReference(), operationStock.getProduit().getRef());

        if (stockSource == null) {
            return -2;
        } else {
            Stock stockDestination = stokage.findByMagasinReferenceAndProduitRef(operationStock.getMagasinDestination().getReference(), operationStock.getProduit().getRef());
            if (stockDestination == null) {
                Stock myStock = new Stock();
                myStock.setMagasin(magasinDestination);
                myStock.setProduit(produit);
                myStock.setQte(operationStock.getQte());
                stokage.savestockage(myStock);
                return 1;
            } else {
                stockDestination.setQte(stockDestination.getQte() + operationStock.getQte());
                stockSource.setQte(stockSource.getQte()-operationStock.getQte());
                OperationStock transport=new OperationStock();
                transport.setQte(operationStock.getQte());
                transport.setDescrition("transport "+operationStock.getQte()+" de "+operationStock.getProduit().getRef()+" de magasin "+operationStock.getMagasinSource().getReference()+" a le magasin "+operationStock.getMagasinDestination().getReference());
                transport.setProduit(produit);
                transport.setMagasinDestination(magasinDestination);
                transport.setMagasinSource(magasinSource);
                operationStockDao.save(transport);
                return 2;
            }

        }
    }

    public List<OperationStock> lookfor(String refproduit, String refmagasin) {
        return operationStockDao.lookfor(refproduit, refmagasin);
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
