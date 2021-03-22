package com.example.demo.ws;

import com.example.demo.Service.OperationStockService;
import com.example.demo.bean.OperationStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Stock/OperationStockBean")
public class OperationStockWs {
    @Autowired
    OperationStockService operationStockService;
    @GetMapping("/magasindestinationreference/{magasindestinationreference}")
    public List<OperationStock> findByMagasinDestinationReference(@PathVariable String magasindestinationreference) {
        return operationStockService.findByMagasinDestinationReference(magasindestinationreference);
    }
    @GetMapping("/magasinsourcereference/{magasinsourcereference}")
    public List<OperationStock> findByMagasinSourceReference(@PathVariable String magasinsourcereference) {
        return operationStockService.findByMagasinSourceReference(magasinsourcereference);
    }
    @GetMapping("/magasindestinationreference/{magasindestinationreference}/magasinsourcereference/{magasinsourcereference}")
    public List<OperationStock> findByMagasinDestinationReferenceAndMagasinSourceReference(@PathVariable String magasindestinationreference,@PathVariable String magasinsourcereference) {
        return operationStockService.findByMagasinDestinationReferenceAndMagasinSourceReference(magasindestinationreference, magasinsourcereference);
    }
    @GetMapping("/refProduit/{refProduit}")
    public List<OperationStock> findByProduitRef(@PathVariable String refProduit) {
        return operationStockService.findByProduitRef(refProduit);
    }
    @GetMapping("/magasindestinationreference/{magasindestinationreference}/magasinsourcereference/{magasinsourcereference}/refProduit/{refProduit}")
    public List<OperationStock> findByMagasinDestinationReferenceAndMagasinSourceReferenceAndProduitRef(@PathVariable String magasindestinationreference,@PathVariable String magasinsourcereference,@PathVariable String refProduit) {
        return operationStockService.findByMagasinDestinationReferenceAndMagasinSourceReferenceAndProduitRef(magasindestinationreference, magasinsourcereference, refProduit);
    }
    @GetMapping("/")
    public List<OperationStock> findAll() {
        return operationStockService.findAll();
    }
    @DeleteMapping("/id/{id}")
    public void deleteById(Long id) {
        operationStockService.deleteById(id);
    }
}
