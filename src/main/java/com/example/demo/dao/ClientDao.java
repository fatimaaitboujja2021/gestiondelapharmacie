package com.example.demo.dao;

import com.example.demo.bean.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<Client,Long> {
    Client findByRef(String ref);
    Client findByRefAndMagasinReference(String ref,String refMagasin);
    int deleteByRef(String ref);

}
