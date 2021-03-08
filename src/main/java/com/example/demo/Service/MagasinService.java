
package com.example.demo.Service;


import com.example.demo.bean.Magasin;
import com.example.demo.bean.Pharmacie;
import com.example.demo.bean.Rue;
import com.example.demo.dao.MagasinDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Magasin> findAll() {
        return magasinDao.findAll();
    }

    public int deleteByPharmacieRefrence(String refrence) {
        return magasinDao.deleteByPharmacieRefrence(refrence);
    }

    public int deleteByReference(String ref) {

    return stockService.deleteByMagasinReference(ref);
        
    }

    public int deleteByAdresse(String adresse) {
        return magasinDao.deleteByAdresse(adresse);
    }

    public List<Magasin> findByRueCode(String Code) {
        return magasinDao.findByRueCode(Code);
    }

    public int deleteByRueCode(String Code) {
        return magasinDao.deleteByRueCode(Code);
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



