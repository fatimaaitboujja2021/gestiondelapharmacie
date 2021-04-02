package com.example.demo.dao;


import com.example.demo.bean.Rue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RueDao extends JpaRepository<Rue,Long> {
    Rue findByCode(String  code);
    Rue findByLibelle(String libelle);
    int deleteByCode(String  code);
    int deleteByLibelle(String libelle);

}
