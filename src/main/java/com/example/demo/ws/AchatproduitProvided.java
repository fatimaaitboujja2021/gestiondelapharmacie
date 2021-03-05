package com.example.demo.ws;


import com.example.demo.Service.AchatproduitService;
import com.example.demo.bean.Achatproduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestion-pharmacie/achat-produit")
public class AchatproduitProvided {
    @GetMapping("refProduit/{refProduit}")
    public List<Achatproduit> findByProduitRef(@PathVariable String refProduit) {
        return achatproduitService.findByProduitRef(refProduit);
    }
@DeleteMapping("refProduit/{refProduit}")
    public List<Achatproduit> deleteByProduitRef(@PathVariable String refProduit) {
        return achatproduitService.deleteByProduitRef(refProduit);
    }
@DeleteMapping("refProduit/{refProduit}/refAchat/{refAchat}")
    public List<Achatproduit> deleteByProduitRefAndAchatRef(@PathVariable String refProduit,@PathVariable String refAchat) {
        return achatproduitService.deleteByProduitRefAndAchatRef(refProduit, refAchat);
    }
@GetMapping("refProduit/{refProduit}/refAchat/{refAchat}")
    public List<Achatproduit> findByProduitRefAndAchatRef(@PathVariable String refProduit,@PathVariable String refAchat) {
        return achatproduitService.findByProduitRefAndAchatRef(refProduit, refAchat);
    }
    @GetMapping("refProduit/{refProduit}/refMagasin/{refMagasin}")
    public List<Achatproduit> findByProduitRefAndMagasinReference(@PathVariable String refProduit,@PathVariable String refMagasin) {
        return achatproduitService.findByProduitRefAndMagasinReference(refProduit, refMagasin);
    }
@GetMapping("/")
    public List<Achatproduit> findAll() {
        return achatproduitService.findAll();
    }
@PostMapping("/")
    public int save(@RequestBody Achatproduit achatproduit) {
        return achatproduitService.save(achatproduit);
    }

    @Autowired
    private AchatproduitService achatproduitService;
}
