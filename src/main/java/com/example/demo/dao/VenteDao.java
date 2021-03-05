package com.example.demo.dao;


import com.example.demo.bean.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenteDao extends JpaRepository<Vente,Long> {
    Vente findByRef(String ref);
    int deleteByRef(String ref);
    Vente findByRefClient(String refClient);
    int deleteByRefClient(String refClient);
    List<Vente> findByPrixHtAndPrixTtc(double prixHt,double prixTtc);
    List<Vente> findAll();
}
