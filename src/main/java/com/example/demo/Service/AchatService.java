package com.example.demo.Service;


import com.example.demo.bean.Achat;
import com.example.demo.dao.AchatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchatService {

    public List<Achat> findByRef(String ref) {
        return achatDao.findByRef(ref);
    }

    public List<Achat> deleteByRef(String ref) {
        return achatDao.deleteByRef(ref);
    }

  /*  public List<Achat> findByRefAndRefMagasin(String ref, String refMagasin) {
        return achatDao.findByRefAndRefMagasin(ref, refMagasin);
    }*/

    public List<Achat> findByRefAndRefFournisseur(String ref, String refFournisseur) {
        return achatDao.findByRefAndRefFournisseur(ref, refFournisseur);
    }

    public List<Achat> findAll() {
        return achatDao.findAll();
    }

    public int save(Achat achat) {
        if(achat.getRef()==null||findByRef(achat.getRef())!=null)
            return -1;
        else
         achatDao.save(achat);
         return 1;
    }

    @Autowired
    private AchatDao achatDao;
}
