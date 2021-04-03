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

    @GetMapping("/refmphar/{ref}/refmag/{reference}")
    public Magasin findByReferenceAndPharmaciereference(@PathVariable String ref, @PathVariable String reference) {
        return magasinService.findByReferenceAndPharmaciereference(ref, reference);
    }


    @DeleteMapping("/refmd/{ref}")
    public int deleteByReference(@PathVariable String ref) {
        return magasinService.deleteByReference(ref);
    }

    @GetMapping("/refmd/{ref}")
    public Magasin findByReference(@PathVariable String ref) {
        return magasinService.findByReference(ref);
    }
    @DeleteMapping("/refpd/{ref}")
    public int deleteByPharmacieReference(@PathVariable String ref) {
        return magasinService.deleteByPharmacieReference(ref);
    }
    @GetMapping("/refp/{ref}")
    public List<Magasin> findByPharmacieRefrence(@PathVariable String ref) {
        return magasinService.findByPharmaciereference(ref);
    }
    @GetMapping("/refma/{mc}")
    public List<Magasin> chercherMagasinparAdresse( @PathVariable String mc) {
        return magasinService.chercherMagasinparAdresse(mc);
    }

    @GetMapping("/adresse/{adresse}")
    public List<Magasin> findByAdresse(@PathVariable String adresse) {
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


