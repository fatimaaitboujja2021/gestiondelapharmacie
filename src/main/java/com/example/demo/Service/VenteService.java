package com.example.demo.Service;


import com.example.demo.bean.Client;
import com.example.demo.bean.Vente;
import com.example.demo.dao.VenteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VenteService {

    public Vente findByRef(String ref) {
        return venteDao.findByRef(ref);
    }
    @Transactional
    public int deleteByRef(String ref) {
        return venteDao.deleteByRef(ref);
    }
    public Vente findByRefAndClientRef(String ref, String refClient) {
        return venteDao.findByRefAndClientRef(ref, refClient);
    }

    public List<Vente> findAll() {
        return venteDao.findAll();
    }

    public int save(Vente vente) {
        Vente vente1=findByRef(vente.getRef());
        Client client=clientService.findByRef(vente.getClient().getRef());
        if(vente1==null){
            Vente vente2=new Vente();
            vente2.setClient(client);
            vente2.setRef(vente.getRef());
            vente2.setPrixHt(vente.getPrixHt());
            vente2.setPrixTtc(vente.getPrixTtc());
            venteDao.save(vente2);
            return 1;
        }
        else return -2;

    }


    @Autowired
    private VenteDao venteDao;
    @Autowired
    private ClientService clientService;
}
