package com.study.dao;
/*
 * DAO接口类(管理员)
 */
import java.util.* ;
import com.study.mod.UserMod;
import com.study.url.*;

//定义数据库操作方法  
public interface UserModDao{  
 // 增加操作  
 public void insert(UserMod usermod) throws Exception ;  
 // 修改操作  
 public void update(UserMod usermod) throws Exception ;  
 // 删除操作  
 public void delete(String username) throws Exception ;  
 // 按ID查询操作  
 public UserMod queryById(String username) throws Exception ;  
 // 查询全部  
 public List queryAll() throws Exception ;  
} 
