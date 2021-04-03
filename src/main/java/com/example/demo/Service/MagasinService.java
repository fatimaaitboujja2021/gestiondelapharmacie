
package com.example.demo.Service;


import com.example.demo.bean.*;
import com.example.demo.dao.MagasinDao;
import com.example.demo.Service.MagasinService;
import com.example.demo.Service.RueService;

import com.example.demo.dao.StockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MagasinService {

    public int save(Magasin magasin) {
        Pharmacie pharmacie = pharmacieService.findByReference(magasin.getPharmacie().getReference());
        Rue rue = rueService.findByCode(magasin.getRue().getCode());
        if (findByReference(magasin.getReference()) == null && rue != null && pharmacie==null) {
            return -1;
        } else {
            Magasin magasin1=new Magasin();
            magasin1.setPharmacie(pharmacie);
            magasin1.setRue(rue);
            magasin1.setReference(magasin.getReference());
            magasin1.setAdresse(magasin.getAdresse());
            magasinDao.save(magasin1);
            return 1;
        }
    }


        /*Rue rue = rueService.findByCode(magasin.getRue().getCode());
        magasin.setRue(rue);
        if (rue == null) {
            return -3;
        }

        Pharmacie pharmacie = pharmacieService.findByreference(magasin.getPharmacie().getReference());
        magasin.setPharmacie(pharmacie);
        if (pharmacie == null) {
            return -2;
        }
        List<Stock> stock = (List<Stock>) stockService.findByMagasinReference(magasin.getReference());
        if (stock == null) {
            return -1;
        }
        magasin.setAdresse(magasin.getAdresse());
        magasin.setPharmacie(pharmacie);
        magasin.setRue(rue);
        magasin.setReference(magasin.getReference());
        pharmacieService.save(pharmacie);

        rueService.save(rue);
        magasinDao.save(magasin);
        magasin.setStock(stock);
        saveStock(magasin, stock);
        return 1;

*/



 /*   public int saveStock(Magasin magasin, List<Stock> stock) {
        for (Stock stock1 : stock) {
            stock1.setMagasin(magasin);
            Produit produit = produitService.findByRef(stock1.getProduit().getRef());
            stock1.setProduit(produit);
            stockService.savestockage(stock1);
        }
        return 1;
    }*/


    public List<Magasin> findByAdresse(String adresse) {
        return magasinDao.findByAdresse(adresse);
    }

    public Magasin findByReference(String Ref) {
        return magasinDao.findByReference(Ref);
    }

    public Magasin findByReferenceAndPharmaciereference(String ref, String reference) {
        return magasinDao.findByReferenceAndPharmacieReference(ref, reference);
    }

    public List<Magasin> findByPharmaciereference(String reference) {
        return magasinDao.findByPharmacieReference(reference);
    }

    public List<Magasin> chercherMagasinparAdresse(String mc) {
        return magasinDao.chercherMagasinparAdresse(mc);
    }

    public List<Magasin> findAll() {
        return magasinDao.findAll();
    }





    @Transactional
    public int deleteByPharmacieReference(String reference) {
        List<Magasin> magasin = findByPharmaciereference(reference);
        for (Magasin M : magasin) {
            int resultstock = stockService.deleteByMagasinReference(M.getReference());
        }
         return magasinDao.deleteByPharmacieReference(reference);


    }

    @Transactional
    public int deleteByReference(String ref) {
        int stockresult = stockService.deleteByMagasinReference(ref);
        int magasinresult = magasinDao.deleteByReference(ref);
        return stockresult + magasinresult;
    }

    public List<Magasin> findByRueCode(String Code) {
        return magasinDao.findByRueCode(Code);
    }

    @Transactional
    public int deleteByRueCode(String code) {
        List<Magasin> magasin = findByRueCode(code);
        for (Magasin M : magasin) {
            int stockresult = stockService.deleteByMagasinReference(M.getReference());
        }
        int magasinresult = magasinDao.deleteByRueCode(code);
        return magasinresult;
    }

    @Autowired
    private RueService rueService;
    @Autowired
    private StockService stockService;
    @Autowired
    private ProduitService produitService;
    @Autowired
    private MagasinDao magasinDao;
    @Autowired
    private PharmacieService pharmacieService;
    @Autowired
    private StockDao stockDao;


}
