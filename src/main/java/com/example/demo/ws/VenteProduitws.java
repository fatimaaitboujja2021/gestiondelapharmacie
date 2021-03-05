package com.example.demo.ws;


import com.example.demo.Service.VenteProduitService;
import com.example.demo.bean.VenteProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestion-pharmacie/venteProduit")
public class VenteProduitws {
    @GetMapping("/refProduit/{refProduit}")
    public List<VenteProduit> findByRefProduit(@PathVariable String refProduit) {
        return venteProduitService.findByProduitRef(refProduit);
    }

    @DeleteMapping("/refProduit/{refProduit}")
    public int deleteByRefProduitAndRefMagasin(@PathVariable String refProduit,@PathVariable String refMagasin) {
        return venteProduitService.deleteByProduitRefAndMagasinReference(refProduit,refMagasin);
    }


    @GetMapping("/")
    public List<VenteProduit> findAll() {
        return venteProduitService.findAll();
    }


    @PostMapping("/")
    public int save(@RequestBody VenteProduit venteProduit) {
        return venteProduitService.save(venteProduit);
    }
    @GetMapping("/refMagasin/{refMagasin}")
    public List<VenteProduit> findByRefMagasin(@PathVariable String refMagasin) {
        return venteProduitService.findByMagasinReference(refMagasin);
    }



    @Autowired
    private VenteProduitService venteProduitService;
}
