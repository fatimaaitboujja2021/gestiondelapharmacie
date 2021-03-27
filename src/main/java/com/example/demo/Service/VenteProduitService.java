package com.example.demo.Service;



import com.example.demo.bean.Magasin;
import com.example.demo.bean.Produit;
import com.example.demo.bean.Vente;
import com.example.demo.bean.VenteProduit;
import com.example.demo.dao.VenteProduitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VenteProduitService {

    public List<VenteProduit> findByProduitRef(String refProduit) {
        return venteproduitDao.findByProduitRef(refProduit);
    }

    public List<VenteProduit> findAll() {
        return venteproduitDao.findAll();
    }

    public List<VenteProduit> findByMagasinReference(String refMagasin) {
        return venteproduitDao.findByMagasinReference(refMagasin);
    }

    public List<VenteProduit> findByProduitRefAndMagasinReference(String refProduit, String refMagasin) {
        return venteproduitDao.findByProduitRefAndMagasinReference(refProduit, refMagasin);
    }

    @Transactional
    public int deleteByProduitRefAndMagasinReference(String refProduit,String refMagasin) {
        if(findByProduitRefAndMagasinReference(refProduit,refMagasin)!=null){
            //rj3 stock refproduit refmagsin qte
            venteproduitDao.deleteByProduitRefAndMagasinReference(refProduit,refMagasin);
            return 1;
        }else{

            return -1;
        }


    }


    public int save(VenteProduit venteProduit) {
        Vente vente=venteService.findByRef(venteProduit.getVente().getRef());
        Produit produit=produitService.findByRef(venteProduit.getProduit().getRef());
        Magasin magasin=magasinService.findByReference(venteProduit.getMagasin().getReference());
        if (magasin==null || produit==null || vente==null){
             return -2;
        }
          else {
            VenteProduit vente1 = new VenteProduit();
            vente1.setVente(vente);
            vente1.setProduit(produit);
            vente1.setMagasin(magasin);
            vente1.setQte(venteProduit.getQte());
            venteproduitDao.save(vente1);
            return 1;
        }

    }






    @Autowired
    private VenteProduitDao venteproduitDao;
    @Autowired
    private  VenteService venteService;
    @Autowired
    private ProduitService produitService;
    @Autowired
    private MagasinService magasinService;
}
