package com.example.demo.Service;


import com.example.demo.bean.Vente;
import com.example.demo.dao.VenteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VenteService {

    public Vente findByRef(String ref) {
        return venteDao.findByRef(ref);
    }
    @Transactional
    public int deleteByRef(String ref) {
        return venteDao.deleteByRef(ref);
    }

    public Vente findByRefClient(String refClient) {
        return venteDao.findByRefClient(refClient);
    }
    @Transactional
    public int deleteByRefClient(String refClient) {
        return venteDao.deleteByRefClient(refClient);
    }

    public List<Vente> findByPrixHtAndPrixTtc(double prixHt, double prixTtc) {
        return venteDao.findByPrixHtAndPrixTtc(prixHt, prixTtc);
    }

    public List<Vente> findAll() {
        return venteDao.findAll();
    }

    public Vente getOne(Long aLong) {
        return venteDao.getOne(aLong);
    }

    public int save(Vente vente) {
        if(findByRef(vente.getRef())!=null){
            return -1;
        }else if(findByRefClient(vente.getRefClient())!=null){
            return -2;
        }else{
             venteDao.save(vente);
             return 1;
        }

    }

    //calcule prixHt et prixTtc=>(Prix HT + TVA = Prix TTC)
   /* public double calcul(double prixHt,double prixTtc,String ref){
        double nvVente=get
    }*/


    @Autowired
    private VenteDao venteDao;
}
