package com.example.demo.ws;


import com.example.demo.Service.AchatproduitService;
import com.example.demo.bean.Achatproduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestion-pharmacie/achat-produit")
public class AchatproduitProvided {
    @GetMapping("ref/{ref}")
    public List<Achatproduit> findByAchatRef(String ref) {
        return achatproduitService.findByAchatRef(ref);
    }

    @GetMapping("ref/{ref}")
    public List<Achatproduit> findByProduitRef(String ref) {
        return achatproduitService.findByProduitRef(ref);
    }
    @GetMapping("refProduit/{refProduit}/ref/{ref}")
    public Achatproduit findByProduitRefAndAchatRef(String refProduit, String ref) {
        return achatproduitService.findByProduitRefAndAchatRef(refProduit, ref);
    }



    @DeleteMapping("refProduit/{refProduit}/ref/{ref}")
    public int deleteByProduitRefAndAchatRef(String refProduit, String ref) {
        return achatproduitService.deleteByProduitRefAndAchatRef(refProduit, ref);
    }
    @GetMapping("/")
    public List<Achatproduit> findAll() {
        return achatproduitService.findAll();
    }
      @PostMapping("refproduit/{refproduit}/refMagasin/{refMagasin}/qte/{qte}/refAchat/{refAchat}")
    public int achatproduit(String refproduit, String refMagasin, double qte, String refAchat) {
        return achatproduitService.achatproduit(refproduit, refMagasin, qte, refAchat);
    }

    @Autowired
    private AchatproduitService achatproduitService;
}
