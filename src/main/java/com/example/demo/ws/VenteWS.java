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
    @GetMapping("ref/{ref}/refClient/{refClient}")
    public Vente findByRefAndClientRef(String ref, String refClient) {
        return venteService.findByRefAndClientRef(ref, refClient);
    }

    @GetMapping("/")
    public List<Vente> findAll() {
        return venteService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Vente vente) {
        return venteService.save(vente);
    }

    @Autowired
    private VenteService venteService;
}
