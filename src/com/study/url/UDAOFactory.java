package com.study.url;

import com.study.dao.UserModDao;
import com.study.dao.UserModDaoImpl;

/*
 * dao工厂类
 */
public class UDAOFactory{  
    public static UserModDao getUserDAOInstance(){  
        return new UserModDaoImpl() ;  
    }  
}  
