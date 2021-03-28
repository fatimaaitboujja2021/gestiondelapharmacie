package com.example.demo.dao;

import com.example.demo.bean.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockDao extends JpaRepository<Stock,Long> {
    List<Stock> findByProduitRef(String refProduit);
    List<Stock> findByMagasinReference(String reference);
    Stock findByMagasinReferenceAndProduitRef(String  reference, String refProduit);
    List <Stock> findAll();
    int deleteByMagasinReference(String reference);
    int deleteByProduitRefAndMagasinReference(String refProduit,String reference);
    @Query("select c from Stock c where c.produit.libelle like '%s%'")
    List <Stock> findStockByProduitName(@Param("s") String libelle);
    Stock findByIdAndQte(Long id,double qte);
}
