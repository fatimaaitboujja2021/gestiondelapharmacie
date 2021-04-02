package com.example.demo.Service;


import com.example.demo.bean.Client;
import com.example.demo.bean.Vente;
import com.example.demo.bean.VenteProduit;
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
        int resultVenteProduit = venteProduitService.deleteByVenteRef(ref);
        int resultVente = venteDao.deleteByRef(ref);
        return resultVente + resultVenteProduit;
    }

    public Vente findByRefAndClientRef(String ref, String refClient) {
        return venteDao.findByRefAndClientRef(ref, refClient);
    }

    public List<Vente> findAll() {
        return venteDao.findAll();
    }

    public Vente save(Vente vente) {
        calculerTotal(vente, vente.getVenteProduits());
        venteDao.save(vente);
        venteProduitService.save(vente, vente.getVenteProduits());
        return vente;
    }

    private void calculerTotal(Vente vente, List<VenteProduit> venteProduits) {
        double prixTotal = 0;
        if (venteProduits != null && !venteProduits.isEmpty()) {
            for (VenteProduit venteProduit : venteProduits) {
                prixTotal += venteProduit.getPrix() * venteProduit.getQte();
            }
            vente.setPrixHt(prixTotal);
            vente.setPrixTtc(prixTotal * 1.2);
        }
    }


    @Autowired
    private VenteDao venteDao;
    @Autowired
    private ClientService clientService;
    @Autowired
    private VenteProduitService venteProduitService;


}
