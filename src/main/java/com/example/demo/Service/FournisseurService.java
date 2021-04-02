package com.example.demo.Service;

import com.example.demo.bean.Fournisseur;
import com.example.demo.dao.FournisseurDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class FournisseurService {


    public Fournisseur findByRef(String Ref) {
        return fournisseurDao.findByRef(Ref);
    }

    public int deleteByRef(String Ref) {
        return fournisseurDao.deleteByRef(Ref);
    }



    public List<Fournisseur> findAll() {
        return fournisseurDao.findAll();
    }

    public int save(Fournisseur fournisseur) {
        if(fournisseur.getRef()==null){
            return -1;
        }
      else if(findByRef(fournisseur.getRef())!=null)
            return -2;
        else {
            fournisseurDao.save(fournisseur);
        return 1;

        }
    }

    @Autowired
    private FournisseurDao fournisseurDao;
}
