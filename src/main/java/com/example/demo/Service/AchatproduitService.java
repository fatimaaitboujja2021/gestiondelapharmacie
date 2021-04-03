package com.example.demo.Service;
import com.example.demo.bean.*;
import com.example.demo.dao.AchatproduitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class AchatproduitService {
    public List<Achatproduit> findByAchatRef(String ref) {
        return achatproduitDao.findByAchatRef(ref);
    }
    public List<Achatproduit> findByProduitRef(String ref) {
        return achatproduitDao.findByProduitRef(ref);
    }
    public Achatproduit findByProduitRefAndAchatRef(String refProduit, String ref) {
        return achatproduitDao.findByProduitRefAndAchatRef(refProduit, ref);
    }
    @Transactional
    public int deleteByProduitRefAndAchatRef(String refProduit, String ref) {
        Produit produit = produitService.findByRef(refProduit);
        Achat achat = achatService.findByRef(ref);
        Achatproduit achatproduit = findByProduitRefAndAchatRef(produit.getRef(), achat.getRef());
        Magasin magasin = magasinService.findByReference(achatproduit.getMagasin().getReference());
        Stock stock = stockService.findByMagasinReferenceAndProduitRef(magasin.getReference(), refProduit);
        if (achat.getRef() != null) {
            if (findByProduitRefAndAchatRef(produit.getRef(), achat.getRef()) != null) {
                stock.setQte(stock.getQte() - achatproduit.getQte());
            }
        }
        return achatproduitDao.deleteByProduitRefAndAchatRef(refProduit, ref);
    }
    public List<Achatproduit> findAll() {
        return achatproduitDao.findAll();
    }
    public int save(Achatproduit achatproduit) {
        Produit produit = produitService.findByRef(achatproduit.getProduit().getRef());
        Magasin magasin = magasinService.findByReference(achatproduit.getMagasin().getReference());
        Achat achat = achatService.findByRef(achatproduit.getAchat().getRef());
        Stock stock = stockService.findByMagasinReferenceAndProduitRef(achatproduit.getMagasin().getReference(), achatproduit.getProduit().getRef());
        if (findByProduitRef(achatproduit.getProduit().getRef())!=null) {
            return -1;
        } else {
            Achatproduit achatproduit1 = new Achatproduit();
            achatproduit1.setAchat(achat);
            achatproduit1.setMagasin(magasin);
            achatproduit1.setProduit(produit);
            achatproduit1.setQte(achatproduit.getQte());
            achatproduit1.setPrixUnitaire(achatproduit.getPrixUnitaire());
            achatproduit1.setPrixTotal(achatproduit.getPrixUnitaire() * achatproduit.getQte());
            achatproduitDao.save(achatproduit1);
            stock.setQte(achatproduit1.getQte() + stock.getQte());
            return 1;
        }
    }

    @Autowired
    private StockService stockService;
    @Autowired
    private ProduitService produitService;
    @Autowired
    private AchatproduitDao achatproduitDao;
    @Autowired
    private MagasinService magasinService;
    @Autowired
    private AchatService achatService;
}
