package com.example.demo.ws;


import com.example.demo.Service.AchatService;
import com.example.demo.bean.Achat;
import com.example.demo.bean.Achatproduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestion-pharmacie/achat")
public class AchatProvided {

@GetMapping("ref/{ref}")
    public Achat findByRef(@PathVariable String Ref) {
        return achatService.findByRef(Ref);
    }

@DeleteMapping("ref/{ref}")
    public int deleteByRef(@PathVariable String Ref) {
        return achatService.deleteByRef(Ref);
    }

    @GetMapping("/")
    public List<Achat> findAll() {
        return achatService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Achat achat, @RequestBody  List<Achatproduit> achatproduits) {
            return achatService.save(achat,achatproduits);
    }

    @Autowired
    private AchatService achatService;
}
