package com.example.demo.Service;



import com.example.demo.bean.Magasin;
import com.example.demo.bean.Pharmacie;
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
    public Pharmacie findById(long id) {
        return pharmacieDao.findById(id);
    }

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
    public void deleteById(long id) {
        pharmacieDao.deleteById(id);
    }

    @Transactional
    public int deleteByreference(String ref) {
        int resultmagasin=magasinService.deleteByPharmaciereference(ref);
        int resultephamacie=pharmacieDao.deleteByreference(ref);
        return resultephamacie+resultmagasin;

    }

    public int save(Pharmacie pharmacie) {
        Pharmacie foundedPharmacie =findByreference(pharmacie.getreference());

        if(foundedPharmacie != null){
            return -1;
        }
        else{
            pharmacieDao.save(pharmacie);
            return 1;
        }
    }


}
