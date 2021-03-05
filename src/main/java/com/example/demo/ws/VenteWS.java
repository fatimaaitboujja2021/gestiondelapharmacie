package com.example.demo.ws;


import com.example.demo.Service.VenteService;
import com.example.demo.bean.Vente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestion-pharmacie/vente")
public class VenteWS {
    @GetMapping("/ref/{ref}")
    public Vente findByRef(@PathVariable String ref) {
        return venteService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return venteService.deleteByRef(ref);
    }

    @GetMapping("/refClient/{refClient}")
    public Vente findByRefClient(@PathVariable String refClient) {
        return venteService.findByRefClient(refClient);
    }

    @DeleteMapping("/refClient/{refClient}")
    public int deleteByRefClient(@PathVariable String refClient) {
        return venteService.deleteByRefClient(refClient);
    }

    @GetMapping("/prixHt/{prixHt}/prixTtc/{prixTtc}")
    public List<Vente> findByPrixHtAndPrixTtc(@PathVariable double prixHt, @PathVariable double prixTtc) {
        return venteService.findByPrixHtAndPrixTtc(prixHt, prixTtc);
    }

    @GetMapping("/")
    public List<Vente> findAll() {
        return venteService.findAll();
    }

    @GetMapping("/id/{id}")
    public Vente getOne(@PathVariable Long id) {
        return venteService.getOne(id);
    }

    @PostMapping("/")
    public int save(@RequestBody Vente vente) {
        return venteService.save(vente);
    }

    @Autowired
    private VenteService venteService;
}
