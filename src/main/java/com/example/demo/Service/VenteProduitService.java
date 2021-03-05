package com.example.demo.Service;



import com.example.demo.bean.VenteProduit;
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
        if(findByProduitRefAndMagasinReference(refProduit,refMagasin)!=null){
            //rj3 stock refproduit refmagsin qte
            venteproduitDao.deleteByProduitRefAndMagasinReference(refProduit,refMagasin);
            return 1;
        }else{

            return -1;
        }


    }


    public int save(VenteProduit venteProduit) {
       if (findByProduitRefAndMagasinReference(venteProduit.getProduit().getRef(),venteProduit.getMagasin().getReference())!=null){
           return -1;
        } else {
            //stockage(venteProduit.getRefMagasin(), venteProduit.getRefProduit(), venteProduit.getQte());
            venteproduitDao.save(venteProduit);
            return 1;
        }

    }






    @Autowired
    private VenteProduitDao venteproduitDao;
}
