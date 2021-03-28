package com.example.demo.ws;

import com.example.demo.Service.ClientService;
import com.example.demo.bean.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Client-api/Client")
public class ClientWs {
    @Autowired
    private ClientService clientService;
    @GetMapping("Ref/{ref}")
    public Client findByRef(@PathVariable String ref) {
        return clientService.findByRef(ref);
    }
    @GetMapping("Ref/{Ref}/RefMagasin/{refMagasin}")
    public Client findByRefAndMagasinReference(@PathVariable String ref,@PathVariable String refMagasin) {
        return clientService.findByRefAndMagasinReference(ref, refMagasin);
    }
    @DeleteMapping("/ref")
    public int deleteByRef(@PathVariable String ref) {
        return clientService.deleteByRef(ref);
    }
    @GetMapping("/")
    public List<Client> findAll() {
        return clientService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Client client) {
        return clientService.save(client);
    }
}
