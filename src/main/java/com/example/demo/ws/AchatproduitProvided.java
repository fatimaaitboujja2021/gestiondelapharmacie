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
    public List<Achatproduit> findByAchatRef(@PathVariable String ref) {
        return achatproduitService.findByAchatRef(ref);
    }

    @GetMapping("refa/{refa}")
    public List<Achatproduit> findByProduitRef(@PathVariable String ref) {
        return achatproduitService.findByProduitRef(ref);
    }
    @GetMapping("refProduit/{refProduit}/ref/{ref}")
    public Achatproduit findByProduitRefAndAchatRef(@PathVariable String refProduit,@PathVariable  String ref) {
        return achatproduitService.findByProduitRefAndAchatRef(refProduit, ref);
    }



    @DeleteMapping("refProduit/{refProduit}/ref/{ref}")
    public int deleteByProduitRefAndAchatRef(@PathVariable String refProduit,@PathVariable  String ref) {
        return achatproduitService.deleteByProduitRefAndAchatRef(refProduit, ref);
    }
    @GetMapping("/")
    public List<Achatproduit> findAll() {
        return achatproduitService.findAll();
    }
      @PostMapping("/")
    public int save(@RequestBody Achatproduit achatproduit)  {
        return achatproduitService.save(achatproduit);
    }

    @Autowired
    private AchatproduitService achatproduitService;
}
