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
    public Fournisseur findByRef(@PathVariable String Ref) {
        return fournisseurService.findByRef(Ref);
    }

    @DeleteMapping("Ref/{Ref}")
    public int deleteByRef(@PathVariable String Ref) {
        return fournisseurService.deleteByRef(Ref);
    }

    @GetMapping("/")
    public List<Fournisseur> findAll() {
        return fournisseurService.findAll();
    }



    @PostMapping("/")
    public int save(@RequestBody Fournisseur fournisseur) {
        return fournisseurService.save(fournisseur);
    }
}
