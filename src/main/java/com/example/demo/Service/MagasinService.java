
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

    public int save(Magasin magasin){
        if(findByReference(magasin.getReference())!=null){
            return -1;
        }
        Rue rue =rueService.findByCode(magasin.getRue().getCode());
        magasin.setRue(rue);
        if(rue==null){
            return -2;
        }
        Pharmacie pharmacie = pharmacieService.findByreference(magasin.getPharmacie().getReference());
        magasin.setPharmacie(pharmacie);
            Magasin magasin1=new Magasin();
            magasin1.setAdresse(magasin.getAdresse());
            magasin1.setPharmacie(pharmacie);
            magasin1.setRue(rue);
            magasin1.setReference(magasin.getReference());
            magasin1.setStock(magasin.getStock());
            magasinDao.save(magasin);
            saveStock(magasin,magasin.getStock());
            magasin1.setStock(magasin1.getStock());
            magasinDao.save(magasin1);
            return 1;
    }

    public int saveStock(Magasin magasin,List<Stock> stocks){
        for (Stock stock:stocks) {
            stock.setMagasin(magasin);
            if(stock.getProduit()!= null && stock.getProduit().getRef() != null) {
                Produit produit = produitService.findByRef(stock.getProduit().getRef());
                stock.setProduit(produit);
            }
            stockDao.save(stock);
        }
            return 1;
        }
//public void save(Magasin magasin, List<Stock> stocks) {
//    for (Stock stock :stocks){
//        stock.setMagasin(magasin);
//        if(stock.getProduit()!= null && stock.getProduit().getRef() != null) {
//            stock.setProduit(produitService.findByRef(stock.getProduit().getRef()));
//        }
//        stockDao.save(stock);
//    }
//}

    public Magasin findByAdresse(String adresse) {
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
        for (Magasin M : magasin )
        {
            int resultstock = stockService.deleteByMagasinReference(M.getReference());
        }
        int resultmagasin=magasinDao.deleteByPharmacieReference(reference);
        int resultepharmacie=pharmacieService.deleteByreference(reference);

return resultepharmacie;
    }

       /* Pharmacie pharmaciesource=pharmacieService.findByreference(reference);
        List<Pharmacie> pharmaciedestination=pharmacieService.findAll();
        if (pharmaciesource==null) {
            return magasinDao.deleteByPharmacieReference(reference) ;
        }
        else{

            for (Pharmacie Ph : pharmaciedestination )
                {
                    if(pharmaciesource.getReference()!=Ph.getReference()){

                        List<Magasin> magasinsource=magasinDao.findByPharmacieReference(reference);

                        for (Magasin Ms: magasinsource){

                        List<Magasin> magasindestination=magasinDao.findByPharmacieReference(Ph.getReference());

                        for (Magasin Md: magasindestination ){

                        if (Ms.getReference()!=Md.getReference())

                        changerlepharmacie(pharmaciesource.getReference(),Ph.getReference());
                }}}}
        }
        return magasinDao.deleteByPharmacieReference(reference) ;*/



    //@Transactional
    //public int deleteByPharmaciereference(String reference) {
      /* List <Magasin> magasin=magasinDao.findByPharmaciereference(reference);

}


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
    //}

    @Transactional
    public int deleteByReference(String ref) {
             int stockresult= stockService.deleteByMagasinReference(ref);
             int magasinresult =magasinDao.deleteByReference(ref);
             return stockresult+magasinresult;
        }

    public List<Magasin> findByRueCode(String Code) {
        return magasinDao.findByRueCode(Code);
    }
    @Transactional
       public int deleteByRueCode(String code){
        List<Magasin> magasin =findByRueCode(code);
        for(Magasin M : magasin){
            int stockresult= stockService.deleteByMagasinReference(M.getReference());
        }
           int magasinresult =magasinDao.deleteByRueCode(code);
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


