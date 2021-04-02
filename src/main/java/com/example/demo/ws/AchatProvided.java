package com.example.demo.ws;


import com.example.demo.Service.AchatService;
import com.example.demo.bean.Achat;
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

    public List<Achat> findAll() {
        return achatService.findAll();
    }
    @PostMapping("magasin/{magasin}/produits/{produits}")
    public int acheter(@RequestBody Achat achat,@RequestBody String magasin,@RequestBody List<String> produits) {
        return achatService.acheter(achat,magasin, produits);
    }

    @Autowired
    private AchatService achatService;
}
