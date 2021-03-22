package com.example.demo.Service;

import com.example.demo.bean.Achatproduit;
import com.example.demo.dao.AchatproduitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AchatproduitService {




    @Autowired
    private AchatproduitDao achatproduitDao;
}
