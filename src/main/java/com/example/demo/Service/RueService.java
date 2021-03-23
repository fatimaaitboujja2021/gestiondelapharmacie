package com.example.demo.Service;

import com.example.demo.bean.Rue;
import com.example.demo.dao.RueDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RueService {
    public int save(Rue rue){
        if(findByCode(rue.getCode())!=null)
            return -1;
        else if(findByLibelle(rue.getLibelle())!=null)
            return -2;

        else rueDao.save(rue);

        return 1;
    }

    public Rue findByLibelle(String libelle) {
        return rueDao.findByLibelle(libelle);
    }
    @Transactional
    public int deleteByCode(String code) {
        int resultmagasin=magasinService.deleteByRueCode(code);
        int resulterue=rueDao.deleteByCode(code);
        return resulterue+resultmagasin;
    }
    @Transactional
    public int deleteByLibelle(String libelle) {
        return rueDao.deleteByLibelle(libelle);
    }

    public  Rue findByCode(String code) {
        return rueDao.findByCode(code);
    }

    public List<Rue> findAll() {
        return rueDao.findAll();
    }
    @Autowired
    private MagasinService magasinService;

    @Autowired
    private RueDao rueDao;
}
