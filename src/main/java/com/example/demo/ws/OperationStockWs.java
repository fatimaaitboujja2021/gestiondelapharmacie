package com.example.demo.ws;

import com.example.demo.Service.OperationStockService;
import com.example.demo.bean.OperationStock;
import com.example.demo.bean.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Stock/OperationStockBean")
public class OperationStockWs {
    @Autowired
    OperationStockService operationStockService;
    @GetMapping("/trouve/refproduit/{refproduit}/refmagasin/{refmagasin}")
    public List<OperationStock> trouve(@PathVariable String refproduit,@PathVariable String refmagasinsource) {
        return operationStockService.trouve(refproduit, refmagasinsource);
    }
    @PostMapping("/")
    public int transferer(@RequestBody OperationStock operationStock) {
        return operationStockService.transferer(operationStock);
    }
    @GetMapping("/lookfor/refproduit/{refproduit}/refmagasin/{refmagasindestination}")
    public List<OperationStock> lookfor(String refproduit, String refmagasindestination) {
        return operationStockService.lookfor(refproduit, refmagasindestination);
    }



    @GetMapping("/")
   public List<OperationStock> findAll() {
        return operationStockService.findAll();
    }

}
