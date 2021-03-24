package com.example.demo.Service;

import com.example.demo.bean.Achatproduit;
import com.example.demo.dao.AchatproduitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
@Service
public class AchatproduitService {


    public Achatproduit findByProduitRef(String ref) {
        return achatproduitDao.findByProduitRef(ref);
    }

    public Achatproduit findByProduitRefAndAchatRef(String refProduit, String ref) {
        return achatproduitDao.findByProduitRefAndAchatRef(refProduit, ref);
    }
@Transactional
    public int deleteByAchatRef(String ref) {

        return achatproduitDao.deleteByAchatRef(ref);
    }
@Transactional
    public int deleteByProduitRefAndAchatRef(String refProduit, String ref) {

        return achatproduitDao.deleteByProduitRefAndAchatRef(refProduit, ref);
    }

    public List<Achatproduit> findAll() {
        return achatproduitDao.findAll();
    }

    public int   save(Achatproduit achatproduit) {
        if(findByProduitRef(achatproduit.getProduit().getRef())!=null){
            return  -1;
        }
        else if (findByProduitRefAndAchatRef(achatproduit.getProduit().getRef(),achatproduit.getAchat().getRef())!=null)
        {
            return -2;
        }
        else if(achatproduit.getProduit().getRef()==null||achatproduit.getAchat().getRef()==null){
            return -3;
        }
        achatproduitDao.save(achatproduit);
        return 1;
    }

    @Autowired
    private AchatproduitDao achatproduitDao;
}
