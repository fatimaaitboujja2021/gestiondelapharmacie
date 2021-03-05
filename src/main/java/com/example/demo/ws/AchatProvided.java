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
    public List<Achat> findByRef(@PathVariable String ref) {
        return achatService.findByRef(ref);
    }
@DeleteMapping("ref/{ref}")
    public List<Achat> deleteByRef(@PathVariable String ref) {
        return achatService.deleteByRef(ref);
    }
   // @GetMapping("ref/{ref}/refMagasin/{refMagasin}")
  /*  public List<Achat> findByRefAndRefMagasin(@PathVariable String ref, @PathVariable String refMagasin) {
        return achatService.findByRefAndRefMagasin(ref, refMagasin);
    }*/
    @GetMapping("ref/{ref}/refFournisseur/{refFournisseur}")
    public List<Achat> findByRefAndRefFournisseur(@PathVariable String ref,@PathVariable String refFournisseur) {
        return achatService.findByRefAndRefFournisseur(ref, refFournisseur);
    }
@GetMapping("/")
    public List<Achat> findAll() {
        return achatService.findAll();
    }
@PostMapping("/")
    public int save(@RequestBody Achat achat) {
        return achatService.save(achat);
    }

    @Autowired
    private AchatService achatService;
}
