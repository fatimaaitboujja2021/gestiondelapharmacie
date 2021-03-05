package com.example.demo.Service;



import com.example.demo.bean.Pharmacie;
import com.example.demo.dao.PharmacieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service

public class PharmacieService {
    @Autowired
    private PharmacieDao pharmacieDao;

    public Pharmacie findById(long id) {
        return pharmacieDao.findById(id);
    }

    public Pharmacie findByRefrence(String ref) {
        return pharmacieDao.findByRefrence(ref);
    }

    public List<Pharmacie> findByLibelle(String libelle) {
        return pharmacieDao.findByLibelle(libelle);
    }

    public Pharmacie findByLibelleAndRefrence(String libelle, String ref) {
        return pharmacieDao.findByLibelleAndRefrence(libelle, ref);
    }

    public List<Pharmacie> findAll() {
        return pharmacieDao.findAll();
    }

    public void deleteById(long id) {
        pharmacieDao.deleteById(id);
    }

    public int deleteByRefrence(String ref) {
        return pharmacieDao.deleteByRefrence(ref);
    }

    public int save(Pharmacie pharmacie) {
        Pharmacie foundedPharmacie =findByRefrence(pharmacie.getRefrence());

        if(foundedPharmacie != null){
            return -1;
        }
        else{
            pharmacieDao.save(pharmacie);
            return 1;
        }
    }


}
