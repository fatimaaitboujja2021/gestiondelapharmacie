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

    @GetMapping("/refpl/{refpl}")
    public List<Pharmacie> chercherPharmacieparLibelle(@PathVariable String mc) {
        return pharmacieService.chercherPharmacieparLibelle(mc);
    }
    @GetMapping("/reflr/{reflr}")
    public Pharmacie findByLibelleAndRefrence(@PathVariable String libelle, @PathVariable String ref) {
        return pharmacieService.findByLibelleAndRefrence(libelle, ref);
    }

    @DeleteMapping("/refpd/{refpd}")
    public int deleteByRefrence(@PathVariable String ref) {
        return pharmacieService.deleteByRefrence(ref);
    }


    @GetMapping("/refp/{refp}")
    public Pharmacie findByRefPharmacie(@PathVariable String ref) {
        return pharmacieService.findByRefrence(ref);
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


