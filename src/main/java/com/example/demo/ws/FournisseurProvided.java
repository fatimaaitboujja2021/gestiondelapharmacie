package com.example.demo.ws;

import com.example.demo.Service.FournisseurService;
import com.example.demo.bean.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("Fournisseur-APi/fourniseur")
public class FournisseurProvided {
    @Autowired
    FournisseurService fournisseurService;
    @GetMapping("Ref/{Ref}")
    public Fournisseur findByRef(String Ref) {
        return fournisseurService.findByRef(Ref);
    }
    @DeleteMapping("Ref/{Ref}")
    public int deleteByRef(String Ref) {
        return fournisseurService.deleteByRef(Ref);
    }
    @GetMapping("/")
    public List<Fournisseur> findAll() {
        return fournisseurService.findAll();
    }
    @GetMapping("Refproduit/{Refproduit}")
    public Fournisseur findByProduitRef(String refproduit) {
        return fournisseurService.findByProduitRef(refproduit);
    }
    @DeleteMapping("Refproduit/{Refproduit}")
    public int deleteByProduitRef(String refProduit) {
        return fournisseurService.deleteByProduitRef(refProduit);
    }
    @PostMapping("/")
    public int save(Fournisseur fournisseur) {
        return fournisseurService.save(fournisseur);
    }
}
