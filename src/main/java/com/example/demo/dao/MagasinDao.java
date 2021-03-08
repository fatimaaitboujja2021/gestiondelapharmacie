package com.example.demo.dao;

import com.example.demo.bean.Magasin;
import com.example.demo.bean.Pharmacie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MagasinDao extends JpaRepository<Magasin,Long> {
    Magasin findByAdresse(String adresse);
    Magasin findByReference(String Ref);
    Magasin findByStockMagasin(String Ref);

    Magasin findByReferenceAndPharmacieRefrence(String ref, String refrence);
    List <Magasin> findByPharmacieRefrence(String refrence);
    List<Magasin> findAll();
    int deleteByPharmacieRefrence(String refrence);
    int deleteByReference(String ref);
    int deleteByAdresse(String adresse);
    List<Magasin> findByRueCode(String Code);
    int deleteByRueCode(String Code);

}
