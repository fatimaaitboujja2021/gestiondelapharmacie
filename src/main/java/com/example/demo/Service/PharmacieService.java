package com.example.demo.Service;



import com.example.demo.bean.Magasin;
import com.example.demo.bean.Pharmacie;
import com.example.demo.bean.Rue;
import com.example.demo.dao.PharmacieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service

public class PharmacieService {
    @Autowired
    private PharmacieDao pharmacieDao;
    @Autowired
    private MagasinService magasinService;

    public Pharmacie findByreference(String ref) {
        return pharmacieDao.findByreference(ref);
    }

    public List<Pharmacie> findByLibelle(String libelle) {
        return pharmacieDao.findByLibelle(libelle);
    }

    public Pharmacie findByLibelleAndreference(String libelle, String ref) {
        return pharmacieDao.findByLibelleAndreference(libelle, ref);
    }
    public List<Pharmacie> chercherPharmacieparLibelle(String mc) {
        return pharmacieDao.chercherPharmacieparLibelle(mc);
    }

    public List<Pharmacie> findAll() {
        return pharmacieDao.findAll();
    }


    @Transactional
    public int deleteByreference(String ref) {
        int resultmagasin=magasinService.deleteByPharmacieReference(ref);
        int resultephamacie=pharmacieDao.deleteByreference(ref);
        return resultephamacie+resultmagasin;

    }

    public int save(Pharmacie pharmacie) {
        Pharmacie foundedPharmacie =findByreference(pharmacie.getReference());

        if(foundedPharmacie != null){
            return -1;
        }
        Rue rue =rueService.findByCode(pharmacie.getRue().getCode());
        pharmacie.setRue(rue);
        if(rue==null){
            return -2;
        }
        List<Magasin> magasin =magasinService.findByPharmaciereference(pharmacie.getReference());
        pharmacie.setMagasin(magasin);
        if(magasin==null){
            return -3;
        }
        else{
            pharmacieDao.save(pharmacie);
            return 1;
        }
    }
@Autowired
    RueService rueService;


}
