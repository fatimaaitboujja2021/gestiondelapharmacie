package com.example.demo.Service;



import com.example.demo.bean.*;
import com.example.demo.dao.StockDao;
import com.example.demo.dao.VenteProduitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VenteProduitService {

    public List<VenteProduit> findByProduitRef(String refProduit) {
        return venteproduitDao.findByProduitRef(refProduit);
    }

    public List<VenteProduit> findAll() {
        return venteproduitDao.findAll();
    }

    public List<VenteProduit> findByMagasinReference(String refMagasin) {
        return venteproduitDao.findByMagasinReference(refMagasin);
    }

    public VenteProduit findByProduitRefAndMagasinReference(String refProduit, String refMagasin) {
        return venteproduitDao.findByProduitRefAndMagasinReference(refProduit, refMagasin);
    }

    @Transactional
    public int deleteByProduitRefAndMagasinReference(String refProduit,String refMagasin) {
            VenteProduit venteProduit = findByProduitRefAndMagasinReference(refProduit,refMagasin);
            Stock stock= stockService.findByMagasinReferenceAndProduitRef(refMagasin,refProduit);
            if (venteProduit !=null){
                stock.setQte(venteProduit.getQte()+stock.getQte());
                return venteproduitDao.deleteByProduitRefAndMagasinReference(refProduit,refMagasin);
            }else{
                return -1;
            }
    }


    public int save(Vente vente,List<VenteProduit> venteProduits){
        if(venteProduits==null || venteProduits.isEmpty()){
            return -1;
        }else{
            for (VenteProduit venteProduit: venteProduits) {
                venteProduit.setVente(vente);
                venteproduitDao.save(venteProduit);
            }
            return 1;
        }
    }

    public List<VenteProduit> findByVenteRef(Vente vente) {
        return venteproduitDao.findByVenteRef(vente);
    }

    public int deleteByVenteRef(String ref) {
        return venteproduitDao.deleteByVenteRef(ref);
    }







    @Autowired
    private VenteProduitDao venteproduitDao;
    @Autowired
    private  VenteService venteService;
    @Autowired
    private ProduitService produitService;
    @Autowired
    private MagasinService magasinService;
    @Autowired
    private StockService stockService;


}
