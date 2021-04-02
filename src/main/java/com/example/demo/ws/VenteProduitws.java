package com.example.demo.ws;


import com.example.demo.Service.VenteProduitService;
import com.example.demo.bean.Vente;
import com.example.demo.bean.VenteProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestion-pharmacie/venteProduit")
public class VenteProduitws {

    @GetMapping("/refProduit/{refProduit}")
    public List<VenteProduit> findByProduitRef(String refProduit) {
        return venteProduitService.findByProduitRef(refProduit);
    }
    @GetMapping("/refMagasin/{refMagasin}")
    public List<VenteProduit> findByMagasinReference(String refMagasin) {
        return venteProduitService.findByMagasinReference(refMagasin);
    }
    @GetMapping("/refProduit/{refProduit}/refMagasin/{refMagasin}")
    public VenteProduit findByProduitRefAndMagasinReference(String refProduit, String refMagasin) {
        return venteProduitService.findByProduitRefAndMagasinReference(refProduit, refMagasin);
    }

    @DeleteMapping("/refProduit/{refProduit}/refMagasin/{refMagasin}")
    public int deleteByProduitRefAndMagasinReference(String refProduit, String refMagasin) {
        return venteProduitService.deleteByProduitRefAndMagasinReference(refProduit, refMagasin);
    }

    @GetMapping("/")
    public List<VenteProduit> findAll() {
        return venteProduitService.findAll();
    }


    @PostMapping("/")
    public int save(@RequestBody Vente vente,@RequestBody List<VenteProduit> venteProduits) {
        return venteProduitService.save(vente, venteProduits);
    }
    @GetMapping("/vente/{vente}")
    public List<VenteProduit> findByVenteRef(Vente vente) {
        return venteProduitService.findByVenteRef(vente);
    }
    @DeleteMapping("/vente/ref/{ref}")
    public int deleteByVenteRef(String ref) {
        return venteProduitService.deleteByVenteRef(ref);
    }

    @Autowired
    private VenteProduitService venteProduitService;
}
