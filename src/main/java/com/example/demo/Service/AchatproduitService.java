package com.example.demo.Service;

import com.example.demo.bean.Achatproduit;
import com.example.demo.dao.AchatproduitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class AchatproduitService {


    public Achatproduit findByProduitRefAndAchatRef(String refProduit, String ref) {
        return achatproduitDao.findByProduitRefAndAchatRef(refProduit, ref);
    }

    public Achatproduit findByProduitRefAndMagasinReferenceAndAchatRef(String refProduit, String ref, String Ref) {
        return achatproduitDao.findByProduitRefAndMagasinReferenceAndAchatRef(refProduit, ref, Ref);
    }
    @Transactional
    public int deleteByProduitRefAndAchatRef(String refProduit, String ref) {
        return achatproduitDao.deleteByProduitRefAndAchatRef(refProduit, ref);
    }
    @Transactional
    public int deleteByProduitRefAndMagasinReferenceAndAchatRef(String refProduit, String ref, String Ref) {
        return achatproduitDao.deleteByProduitRefAndMagasinReferenceAndAchatRef(refProduit, ref, Ref);
    }

    public List<Achatproduit> findAll() {
        return achatproduitDao.findAll();
    }

    @Autowired
    private AchatproduitDao achatproduitDao;
}
