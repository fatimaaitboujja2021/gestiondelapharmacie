package com.example.demo.dao;


import com.example.demo.bean.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VenteDao extends JpaRepository<Vente,Long> {
    Vente findByRef(String ref);
    Vente findByRefAndClientRef(String ref,String refClient);
    int deleteByRef(String ref);
    List<Vente> findAll();

}
