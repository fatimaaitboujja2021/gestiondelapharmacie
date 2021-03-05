package com.example.demo.dao;

import com.example.demo.bean.Pharmacie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PharmacieDao extends JpaRepository<Pharmacie,Long> {
    Pharmacie findById(long id);
    Pharmacie findByRefrence(String ref);
    List <Pharmacie> findByLibelle(String libelle);
    Pharmacie findByLibelleAndRefrence(String libelle,String ref);
    List <Pharmacie> findAll();
    void deleteById(long id);
    int deleteByRefrence(String ref);
}
