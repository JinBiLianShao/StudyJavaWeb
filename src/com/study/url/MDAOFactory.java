package com.study.url;

import com.study.dao.ModDao;
import com.study.dao.ModDaoImpl;

/*
 * dao工厂类
 */
public class MDAOFactory{  
    public static ModDao getUserDAOInstance(){  
        return new ModDaoImpl() ;  
    }  
}  
