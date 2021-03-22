package com.example.demo.Service;


import com.example.demo.bean.Achat;
import com.example.demo.dao.AchatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchatService {



    @Autowired
    private AchatDao achatDao;
}
