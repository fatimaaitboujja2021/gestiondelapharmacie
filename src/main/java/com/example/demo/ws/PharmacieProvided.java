package com.example.demo.ws;


import com.example.demo.Service.PharmacieService;
import com.example.demo.bean.Magasin;
import com.example.demo.bean.Pharmacie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("pharmacie/pharmacy")
public class PharmacieProvided {

    @Autowired
    private PharmacieService pharmacieService;

    @PostMapping("/")
    public int save(@RequestBody Pharmacie pharmacie) {
        return pharmacieService.save(pharmacie);
    }

    @GetMapping("/refpl/{mc}")
    public List<Pharmacie> chercherPharmacieparLibelle(@PathVariable String mc) {
        return pharmacieService.chercherPharmacieparLibelle(mc);
    }
    @GetMapping("libelle/{libelle}/reflr/{ref}")
    public Pharmacie findByLibelleAndReference(@PathVariable String libelle, @PathVariable String ref) {
        return pharmacieService.findByLibelleAndReference(libelle, ref);
    }

    @DeleteMapping("/refpd/{ref}")
    public int deleteByReference(@PathVariable String ref) {
        return pharmacieService.deleteByReference(ref);
    }


    @GetMapping("/refp/{ref}")
    public Pharmacie findByRefPharmacie(@PathVariable String ref) {
        return pharmacieService.findByReference(ref);
    }


    @GetMapping("/libelle/{libelle}")
    public List <Pharmacie> findByLibelle(@PathVariable String libelle) {
        return  pharmacieService.findByLibelle(libelle);
    }



    @GetMapping("/")
    public List<Pharmacie> findAll() {
        return pharmacieService.findAll();
    }



}


