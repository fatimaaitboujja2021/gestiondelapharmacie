package com.example.demo.Service;

import com.example.demo.bean.Client;
import com.example.demo.bean.Magasin;
import com.example.demo.bean.Produit;
import com.example.demo.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CLientService {
    @Autowired
    private ClientDao clientDao;
    @Autowired
    private MagasinService magasinService;
    @Autowired
    private VenteService venteService;
    public Client findByRef(String ref) {
        return clientDao.findByRef(ref);
    }

    public Client findByRefAndMagasinReference(String ref, String refMagasin) {
        return clientDao.findByRefAndMagasinReference(ref, refMagasin);
    }

    public int deleteByRef(String ref) {
        return clientDao.deleteByRef(ref);
    }

    public List<Client> findAll() {
        return clientDao.findAll();
    }
    public int save(Client client, List<Produit> produitList){
        Magasin magasin =magasinService.findByReference(client.getMagasin().getReference());
            Client client2=new Client();
            client2.setMagasin(magasin);
            client2.setRef(client.getRef());
            clientDao.save(client2);
            venteService.Vente()
            return 1;
    }
}
