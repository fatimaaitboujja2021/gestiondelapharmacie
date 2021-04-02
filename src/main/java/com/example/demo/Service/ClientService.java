package com.example.demo.Service;

import com.example.demo.bean.Client;
import com.example.demo.bean.Magasin;
import com.example.demo.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientService {
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
    public int save(Client client){
            Magasin magasin =magasinService.findByReference(client.getMagasin().getReference());
            Client clientvent =new Client();
            clientvent.setMagasin(magasin);
            clientvent.setRef(clientvent.getRef());
            clientDao.save(clientvent);
            return 1;
    }
}
