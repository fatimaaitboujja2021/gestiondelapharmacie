package com.example.demo.dao;

import com.example.demo.bean.Achatproduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface AchatproduitDao extends JpaRepository<Achatproduit,Long> {
    Achatproduit findByProduitRefAndAchatRef(String refProduit, String ref);
    Achatproduit findByProduitRefAndMagasinReferenceAndAchatRef(String refProduit, String ref,String Ref);
    int deleteByProduitRefAndAchatRef(String refProduit, String ref);
    int deleteByProduitRefAndMagasinReferenceAndAchatRef(String refProduit, String ref,String Ref);
}
