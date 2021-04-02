package com.example.demo.dao;


import com.example.demo.bean.Stock;
import com.example.demo.bean.Vente;
import com.example.demo.bean.VenteProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenteProduitDao extends JpaRepository<VenteProduit,Long> {
    List<VenteProduit> findByProduitRef(String refProduit);
    int deleteByProduitRefAndMagasinReference(String refProduit, String refMagasin);
    VenteProduit findByProduitRefAndMagasinReference(String refProduit, String refMagasin);
    List<VenteProduit> findByMagasinReference(String refMagasin);

    List<VenteProduit> findByVenteRef(Vente vente);
    int deleteByVenteRef(String ref);
}
