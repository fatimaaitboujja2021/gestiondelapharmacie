package com.example.demo.ws;

import com.example.demo.Service.MagasinService;
import com.example.demo.bean.Magasin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("pharmacie/magasin")
public class
MagasinProvided {

    @PostMapping("/")
    public int save(@RequestBody Magasin magasin) {
        return magasinService.save(magasin);
    }

    @GetMapping("/refmphar/{refmphar}")
    public Magasin findByReferenceAndPharmaciereference(@PathVariable String ref, @PathVariable String reference) {
        return magasinService.findByReferenceAndPharmaciereference(ref, reference);
    }

    @GetMapping("/refmpharS/{refmpharD}")
    public int changerlepharmaciedeMagasin (@PathVariable String refS, @PathVariable String refD) {
        return magasinService.changerlepharmaciedeMagasin(refS, refD);
    }
    @DeleteMapping("/refm/{refm}")
    public int deleteByReference(@PathVariable String ref) {
        return magasinService.deleteByReference(ref);
    }

    @GetMapping("/refmd/{refmd}")
    public Magasin findByReference(@PathVariable String ref) {
        return magasinService.findByReference(ref);
    }
    @DeleteMapping("/refpd/{refpd}")
    public int deleteByPharmacieReference(@PathVariable String ref) {
        return magasinService.deleteByPharmacieReference(ref);
    }
    @GetMapping("/refp/{refp}")
    public List<Magasin> findByPharmacieRefrence(@PathVariable String ref) {
        return magasinService.findByPharmaciereference(ref);
    }
    @GetMapping("/refma/{refma}")
    public List<Magasin> chercherMagasinparAdresse( @PathVariable String mc) {
        return magasinService.chercherMagasinparAdresse(mc);
    }

    @GetMapping("/adresse/{adresse}")
    public Magasin findByAdresse(@PathVariable String adresse) {
        return  magasinService.findByAdresse(adresse);
    }

    @GetMapping("/Rue/Code/{Code}")
    public List<Magasin> findByRueCode(@PathVariable String Code){
        return magasinService.findByRueCode(Code);
    }

    @GetMapping("/")
    public List<Magasin> findAll() {
        return magasinService.findAll();
    }


    @Autowired
    private MagasinService magasinService;
}


