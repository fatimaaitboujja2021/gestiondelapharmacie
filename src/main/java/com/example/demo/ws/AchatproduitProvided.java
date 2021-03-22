package com.example.demo.ws;


import com.example.demo.Service.AchatproduitService;
import com.example.demo.bean.Achatproduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestion-pharmacie/achat-produit")
public class AchatproduitProvided {


    @Autowired
    private AchatproduitService achatproduitService;
}
