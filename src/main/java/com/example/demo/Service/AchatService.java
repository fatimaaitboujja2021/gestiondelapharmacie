package com.example.demo.Service;
import com.example.demo.bean.Achat;
import com.example.demo.bean.Produit;
import com.example.demo.dao.AchatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AchatService {


    public Achat findByRef(String Ref) {
        return achatDao.findByRef(Ref);
    }
@Transactional
    public int deleteByRef(String Ref) {


    return achatDao.deleteByRef(Ref);
    }
    public List<Achat> findAll() {
        return achatDao.findAll();
    }

    public int save(Achat achat) {
        if(findByRef(achat.getRef())!=null)
        {return -1;}
        else if(achat.getRef()==null){
            return -2;
        }
        achatDao.save(achat);
        return 1;
    }


    @Autowired
    private AchatDao achatDao;
}
