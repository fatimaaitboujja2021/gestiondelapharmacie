package com.example.demo.dao;

import com.example.demo.bean.Achatproduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface AchatproduitDao extends JpaRepository<Achatproduit,Long> {
    List <Achatproduit> findByProduitRef(String refProduit);
    List <Achatproduit> deleteByProduitRef(String refProduit);
    List <Achatproduit> deleteByProduitRefAndAchatRef(String refProduit,String refAchat);
    List<Achatproduit> findByProduitRefAndAchatRef(String refProduit, String refAchat);
    List<Achatproduit> findByProduitRefAndMagasinReference(String refProduit, String refMagasin);

}
