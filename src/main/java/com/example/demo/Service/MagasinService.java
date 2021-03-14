
package com.example.demo.Service;


import com.example.demo.bean.Magasin;
import com.example.demo.bean.Pharmacie;
import com.example.demo.bean.Rue;
import com.example.demo.dao.MagasinDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MagasinService {
    public int save(Magasin magasin){
        if(findByReference(magasin.getReference())!=null){
            return -1;
        }
        Rue rue =rueService.findByCode(magasin.getRue().getCode());
        magasin.setRue(rue);
        if(rue==null){
            return -2;
        }
        Pharmacie pharmacie = pharmacieService.findByRefrence(magasin.getPharmacie().getRefrence());
        magasin.setPharmacie(pharmacie);
        if(pharmacie==null){
            return -3;
        }
        else{
            magasinDao.save(magasin);
            return 1;
        }

    }


    public Magasin findByAdresse(String adresse) {
        return magasinDao.findByAdresse(adresse);
    }

    public Magasin findByReference(String Ref) {
        return magasinDao.findByReference(Ref);
    }

    public Magasin findByReferenceAndPharmacieRefrence(String ref, String refrence) {
        return magasinDao.findByReferenceAndPharmacieRefrence(ref, refrence);
    }

    public List<Magasin> findByPharmacieRefrence(String refrence) {
        return magasinDao.findByPharmacieRefrence(refrence);
    }

    public List<Magasin> chercherMagasinparAdresse(String mc) {
        return magasinDao.chercherMagasinparAdresse(mc);
    }

    public List<Magasin> findAll() {
        return magasinDao.findAll();
    }


    @Transactional
    public int deleteByPharmacieRefrence(String refrence) {
        Magasin magasin =magasinDao.findByReference(refrence);
        List<Magasin> magasinList=magasinDao.findByPharmacieRefrence(magasin.getPharmacie().getRefrence());
        String lastelement =magasinList.get(magasinList.size()-1).getReference();
        for (Magasin magasin1:magasinList) {
            String refmagasin=magasin1.getReference();
            if(!refmagasin.equals(lastelement)){
                stockService.deleteByMagasinReference(magasin1.getReference());
            }
            else {
                /*
                methode de vente{
                foreach(Produit trouve un fourniseur adequois)

                 */
            }
        }
        return magasinDao.deleteByPharmacieRefrence(refrence);
    }


    @Transactional
    public int deleteByReference(String ref) {

        return stockService.deleteByMagasinReference(ref);

    }
    @Transactional
    public int deleteByAdresse(String adresse) {
        return magasinDao.deleteByAdresse(adresse);
    }

    public List<Magasin> findByRueCode(String Code) {
        return magasinDao.findByRueCode(Code);
    }

    @Transactional
    public int deleteByRueCode(String Code) {
        return  rueService.deleteByCode(Code);
    }

    @Autowired
    private RueService rueService;
    @Autowired
    private StockService stockService;
    @Autowired
    private MagasinDao magasinDao;
    @Autowired
    private PharmacieService pharmacieService;


}



