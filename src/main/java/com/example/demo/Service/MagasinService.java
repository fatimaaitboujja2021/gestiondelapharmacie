
package com.example.demo.Service;


import com.example.demo.bean.*;
import com.example.demo.dao.MagasinDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MagasinService {
    public int save(Magasin magasin){
        if(findByReference(magasin.getReference())!=null){
            return -1;
        }
        Rue rue =rueService.findByCode(magasin.getRue().getCode());
        magasin.setRue(rue);
        if(rue==null){
            return -2;
        }
        Pharmacie pharmacie = pharmacieService.findByreference(magasin.getPharmacie().getreference());
        magasin.setPharmacie(pharmacie);
        if(pharmacie==null){
            return -3;
        }
        else{
            magasinDao.save(magasin);
            return 1;
        }

    }


    public Magasin findByAdresse(String adresse) {
        return magasinDao.findByAdresse(adresse);
    }

    public Magasin findByReference(String Ref) {
        return magasinDao.findByReference(Ref);
    }

    public Magasin findByReferenceAndPharmaciereference(String ref, String reference) {
        return magasinDao.findByReferenceAndPharmaciereference(ref, reference);
    }

    public List<Magasin> findByPharmaciereference(String reference) {
        return magasinDao.findByPharmaciereference(reference);
    }

    public List<Magasin> chercherMagasinparAdresse(String mc) {
        return magasinDao.chercherMagasinparAdresse(mc);
    }

    public List<Magasin> findAll() {
        return magasinDao.findAll();
    }

    public int transferer(String refSource, String refDestination, String refProduit, double qte) {
        Magasin magasinSource = magasinDao.findByReference(refSource);
        Magasin magasinDestination = magasinDao.findByReference(refDestination);
        Produit produit = produitService.findByRef(refProduit);

        if (produit == null || magasinSource == null || magasinDestination == null)
            return -1;

        Stock stockSource = stockService.findByMagasinReferenceAndProduitRef(refSource, refProduit);

        if (stockSource == null) {
            return -2;
        } else {
            Stock stockDestination = stockService.findByMagasinReferenceAndProduitRef(refSource, refProduit);
            if (stockDestination == null) {

                Stock myStock = new Stock();
                myStock.setMagasin(magasinDestination);
                myStock.setProduit(produit);
                myStock.setQte(qte);
                stockService.savestockage(myStock);
                return 1;
            } else {
                stockDestination.setQte(stockDestination.getQte() + qte);
                stockService.savestockage(stockDestination);
                return 2;
            }

        }
    }

    public int transferer(String refPharmacieSource, String refpharmacieDestination){
        Pharmacie pharmaciesource=pharmacieService.findByreference(refPharmacieSource);
        Pharmacie pharmacieDestination=pharmacieService.findByreference(refpharmacieDestination);
        if ( pharmaciesource == null)
            return -1;
        else {
            if (pharmacieDestination == null) {

                Pharmacie newpharmacie = new Pharmacie();
                newpharmacie.setMagasin(pharmaciesource.getMagasin());
                newpharmacie.setRue(pharmaciesource.getRue());
                pharmacieService.save(newpharmacie);

                return 1;
            } else {
                List<Magasin> magasinsource=magasinDao.findByPharmaciereference(refPharmacieSource);


                    for (int i=0; i<magasinsource.size(); i++)
                    {
                        Magasin magasin = magasinsource.get(i);
                        magasinsource.setPharmacieReference(pharmacieDestination.getreference());                    }
                return 2;
            }
                pharmacieService.save(pharmacieDestination);
                

        }
    }


    }



    @Transactional
    public int deleteByPharmaciereference(String reference) {
      /* List <Magasin> magasin=magasinDao.findByPharmaciereference(reference);



        Stock resultstock= stockService.deleteByMagasinReference(stock.magasin().getreference)
Magasin resultmagasin= magasinDao.de
       List <Magasin> magasin = magasinDao.findByPharmaciereference(reference);
        //List<Magasin> magasinList=magasinDao.findByPharmaciereference(magasin.getPharmacie().getreference());
        String lastelement =magasinList.get(magasinList.size()-1).getReference();
        for (Magasin magasin1:magasinList) {
            String refmagasin=magasin1.getReference();
            if(!refmagasin.equals(lastelement)){
                stockService.deleteByMagasinReference(magasin1.getReference());
            }
            else {
                /*
                methode de vente{
                foreach(Produit trouve un fourniseur adequois)

                 */
          //  }
        //}
        //return magasinDao.deleteByPharmaciereference(reference);
    //}


    @Transactional
    public int deleteByReference(String ref) {
            stockresult= stockService.deleteByMagasinReference(ref);

        }
    @Transactional
    public int deleteByAdresse(String adresse) {
        return magasinDao.deleteByAdresse(adresse);
    }

    public List<Magasin> findByRueCode(String Code) {
        return magasinDao.findByRueCode(Code);
    }

    @Transactional
    public int deleteByRueCode(String Code) {
        return  rueService.deleteByCode(Code);
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


}



