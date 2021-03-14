package com.example.demo.ws;


import com.example.demo.Service.RueService;
import com.example.demo.bean.Rue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pharmacie/rue")
public class RueProvided {
    @Autowired
    private RueService rueService;
    @PostMapping("/")
    public int save(@RequestBody Rue rue) {
        return rueService.save(rue);
    }
    @GetMapping("/libelle/{libelle}")
    public Rue findByLibelle(@PathVariable String libelle) {
        return rueService.findByLibelle(libelle);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return rueService.deleteByCode(code);
    }
    @DeleteMapping ("/libelle/{libelle}")
    public int deleteByLibelle(@PathVariable String libelle) {
        return rueService.deleteByLibelle(libelle);
    }
    @GetMapping("/code/{code}")
    public  Rue findByCode(@PathVariable String code) {
        return rueService.findByCode(code);
    }
    @GetMapping("/")
    public List<Rue> findAll() {
        return rueService.findAll();
    }
}
