package com.example.demo.dao;

import com.example.demo.bean.Achatproduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchatproduitDao extends JpaRepository<Achatproduit,Long> {
    List<Achatproduit>  findByAchatRef(String ref);
    List<Achatproduit> findByProduitRef(String ref);
    Achatproduit findByProduitRefAndAchatRef(String refProduit, String ref);

    int deleteByProduitRefAndAchatRef(String refProduit, String ref);
}
