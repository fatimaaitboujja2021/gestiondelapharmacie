package com.example.demo.dao;

import com.example.demo.bean.Achatproduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchatproduitDao extends JpaRepository<Achatproduit,Long> {

    Achatproduit findByProduitRef(String ref);
    Achatproduit findByProduitRefAndAchatRef(String refProduit, String ref);
    int deleteByAchatRef(String ref);
    int deleteByProduitRefAndAchatRef(String refProduit, String ref);


}
