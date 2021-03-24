package com.example.demo.dao;
import com.example.demo.bean.Achat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchatDao extends JpaRepository<Achat,Long> {
    Achat findByRef(String Ref);
    int deleteByRef(String Ref);

}
