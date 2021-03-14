package com.example.demo.ws;


import com.example.demo.Service.ProduitService;
import com.example.demo.bean.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pharmacie/produit")

public class ProduitProvided {
    @Autowired
    private ProduitService produitService;

    @PostMapping("/")
    public int save(@RequestBody Produit produit) {
        return produitService.save(produit);
    }

    @DeleteMapping("/refdpr/{refdpr}")
    public int deleteByRef(@PathVariable String ref) {
        return produitService.deleteByRef(ref);
    }

    @GetMapping("/refpr/{refpr}")
    public Produit findByRef(@PathVariable String ref) {
        return produitService.findByRef(ref);
    }



    @GetMapping("/libelle/{libelle}")

    public Produit findByLibelle(@PathVariable String libelle) {
        return  produitService.findByLibelle(libelle);
    }



    @GetMapping("/")
    public List<Produit> findAll() {
        return produitService.findAll();
    }



}




