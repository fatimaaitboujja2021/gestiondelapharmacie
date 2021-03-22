package com.example.demo.ws;

import com.example.demo.Service.StockService;
import com.example.demo.bean.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Stock/StocckBean")
public class Stockws {
    @Autowired
    StockService stockService;
    @GetMapping("/refProduit/{refProduit}")
    public List<Stock> findByProduitRef(@PathVariable String refProduit) {
        return stockService.findByProduitRef(refProduit);
    }
    @GetMapping("/reference/{reference}")
    public List<Stock> findByMagasinReference(String reference) {
        return stockService.findByMagasinReference(reference);
    }
    @GetMapping("/reference/{reference}/refProduit/{refProduit}")
    public Stock findByMagasinReferenceAndProduitRef(@PathVariable String reference, @PathVariable String refProduit) {
        return stockService.findByMagasinReferenceAndProduitRef(reference, refProduit);
    }
    @GetMapping("/")
    public List<Stock> findAll() {
        return stockService.findAll();
    }
    @DeleteMapping("/reference/{reference}")
    public int deleteByMagasinReference(@PathVariable String reference) {
        return stockService.deleteByMagasinReference(reference);
    }
    @DeleteMapping("/refProduit/{refProduit}/reference/{reference}")
    public int deleteByProduitRefAndMagasinReference(@PathVariable String refProduit,@PathVariable String reference) {
        return stockService.deleteByProduitRefAndMagasinReference(refProduit, reference);
    }
    @PostMapping("/")
    public int savestockage(@RequestBody Stock stockage) {
        return stockService.savestockage(stockage);
    }
}
