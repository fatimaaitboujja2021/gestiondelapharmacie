package com.example.demo.dao;

import com.example.demo.bean.Magasin;
import com.example.demo.bean.Pharmacie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PharmacieDao extends JpaRepository<Pharmacie,Long> {
    Pharmacie findById(long id);
    Pharmacie findByreference(String ref);
    @Query("select a from Pharmacie a where a.libelle like '%x%'")
    public List<Pharmacie> chercherPharmacieparLibelle(@Param("x") String motcle);

    List <Pharmacie> findByLibelle(String libelle);
    Pharmacie findByLibelleAndReference(String libelle,String ref);
    List <Pharmacie> findAll();
    void deleteById(long id);
    int deleteByreference(String ref);
}
