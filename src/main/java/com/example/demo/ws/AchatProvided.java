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
    public Achat findByRef(String Ref) {
        return achatService.findByRef(Ref);
    }

@DeleteMapping("ref/{ref}")
    public int deleteByRef(String Ref) {
        return achatService.deleteByRef(Ref);
    }

    public List<Achat> findAll() {
        return achatService.findAll();
    }
    @PostMapping("magasin/{magasin}/produits/{produits}")
    public int acheter(String magasin, List<String> produits) {
        return achatService.acheter(magasin, produits);
    }

    @Autowired
    private AchatService achatService;
}
