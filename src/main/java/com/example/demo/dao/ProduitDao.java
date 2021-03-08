package com.example.demo.dao;

import com.example.demo.bean.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface
ProduitDao extends JpaRepository <Produit,Long> {
    List<Produit> findByType(String type);
    Produit findByLibelle(String Libelle);
    Produit findByLibelleAndType(String Libelle,String type);
    Produit findByRef(String refProduit);
 //   List<Produit> findByMagasinReference(String magasinreference);
   // Produit findByMagasinReferenceAndRef(String refMagasin,String refProduit);
    List <Produit> findAll();
    //int deleteByMagasinReferenceAndRef(String refMagasin,String refProduit);
    int deleteByRef(String refProduit);
    int deleteByLibelle(String Libelle);
}
