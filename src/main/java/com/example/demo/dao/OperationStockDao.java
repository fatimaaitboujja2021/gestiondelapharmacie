package com.example.demo.dao;

import com.example.demo.bean.OperationStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationStockDao extends JpaRepository<OperationStock,Long> {
    @Query("SELECT v from OperationStock v where v.produit.ref LIKE %:pr% AND v.magasinSource.reference LIKE %:ms%")
    List <OperationStock> trouve(@Param("pr")String refproduit,@Param("ms") String refmagasin);
    @Query("SELECT c from OperationStock c where c.produit.ref LIKE %:pr% AND c.magasinSource.reference LIKE %:ms%")
    List <OperationStock> lookfor(@Param("pr")String refproduit,@Param("ms") String refmagasin);
    List<OperationStock> findAll();
}
