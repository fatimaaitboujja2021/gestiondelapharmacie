package com.example.demo.dao;
import com.example.demo.bean.Achat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface AchatDao extends JpaRepository<Achat,Long> {
    Achat findByRef(String Ref);
    int deleteByRef(String Ref);
    Achat findByRefAndFournisseurRef(String Ref,String RefFournisseur);
    int deleteByRefAndFournisseurRef(String Ref,String RefFournisseur);
}
