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

    public Pharmacie findByReference(String ref) {
        return pharmacieDao.findByReference(ref);
    }

    public List<Pharmacie> findByLibelle(String libelle) {
        return pharmacieDao.findByLibelle(libelle);
    }

    public Pharmacie findByLibelleAndReference(String libelle, String ref) {
        return pharmacieDao.findByLibelleAndReference(libelle, ref);
    }

    public List<Pharmacie> chercherPharmacieparLibelle(String mc) {
        return pharmacieDao.chercherPharmacieparLibelle(mc);
    }

    public List<Pharmacie> findAll() {
        return pharmacieDao.findAll();
    }


    @Transactional
    public int deleteByReference(String ref) {
        int resultmagasin = magasinService.deleteByPharmacieReference(ref);
        int resultephamacie = pharmacieDao.deleteByReference(ref);
        return resultephamacie + resultmagasin;

    }

    public int save(Pharmacie pharmacie) {
        Pharmacie foundedPharmacie = findByReference(pharmacie.getReference());
        if (foundedPharmacie != null) {
            return -1;
        } else {
            pharmacieDao.save(pharmacie);
            saveMagasin(pharmacie, pharmacie.getMagasin());
            return 1;
        }
    }

    private void saveMagasin(Pharmacie pharmacie, List<Magasin> magasinList) {
        for (Magasin magasin : magasinList) {
            magasin.setPharmacie(pharmacie);

            magasinService.save(magasin);
        }
    }

    @Autowired
    RueService rueService;


}
