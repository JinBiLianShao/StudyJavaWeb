package com.study.dao;
/*
 * DAO接口类
 */
import java.util.* ;
import com.study.mod.Mod;
import com.study.url.*;

//定义数据库操作方法  
public interface ModDao{  
 // 增加操作  
 public void insert(Mod mod) throws Exception ;  
 // 修改操作  
 public void update(Mod mod) throws Exception ;  
 // 删除操作  
 public void delete(String id) throws Exception ;  
 // 按ID查询操作  
 public Mod queryById(String id) throws Exception ;  
 // 查询全部  
 public List queryAll() throws Exception ;
 
 public List<Mod> list() throws Exception;
 
 public Mod get(String id) throws Exception;
} 
