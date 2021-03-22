package com.example.demo.dao;

import com.example.demo.bean.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FournisseurDao extends JpaRepository<Fournisseur,Long> {
    Fournisseur findByRef(String Ref);
    int deleteByRef(String Ref);

}