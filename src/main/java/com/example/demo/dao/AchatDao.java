package com.example.demo.dao;
import com.example.demo.bean.Achat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface AchatDao extends JpaRepository<Achat,Long> {
    List<Achat> findByRef(String ref);
    List<Achat> deleteByRef(String ref);

   // List<Achat> findByRefAndRefMagasin(String ref,String refMagasin);
    List<Achat> findByRefAndRefFournisseur(String ref,String refFournisseur);
}
