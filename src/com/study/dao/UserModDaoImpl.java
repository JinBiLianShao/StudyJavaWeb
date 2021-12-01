package com.study.dao;
import java.sql.Connection;
/*
 * DAO实现类
 */
import java.sql.PreparedStatement;  
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;  
import java.util.List;

import com.study.mod.UserMod;
import com.study.url.DBconn;    
 
public class UserModDaoImpl implements UserModDao {  

	    public int getTotal() {

	        int total = 0;

	        String sql = "SELECT COUNT(*) FROM student";
	        PreparedStatement pstmt = null ; //初始化
	        DBconn dbc = null ;  
	        
	        try{
	        	dbc = new DBconn() ;
	        	pstmt = dbc.getConnection().prepareStatement(sql) ;
	        	ResultSet rs = pstmt.executeQuery() ;
	            while (rs.next()) {
	                total = rs.getInt(1);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return total;
	    }
   //添加操作  
	/*
	 * 用于注册页面使用，添加信息。
	 */
   public void insert(UserMod usermod) throws Exception {  
       String sql = "INSERT INTO user(username,password,name) VALUES(?,?,?)";//SQL语句
       PreparedStatement pstmt = null ; //初始化
       DBconn dbc = null ;  

       try{  
           // 连接数据库  
           dbc = new DBconn() ;  
           pstmt = dbc.getConnection().prepareStatement(sql) ;   
           pstmt.setString(1, usermod.getUsername());
           pstmt.setString(2, usermod.getPassword());
           pstmt.setString(3, usermod.getName());
           // 进行数据库更新操作  
           pstmt.executeUpdate() ;  
           pstmt.close() ;  
       }catch (Exception e){  
           throw new Exception("操作出现异常") ;  
       }  
       finally{  
           // 关闭数据库连接  
           dbc.close() ;  
       }  
   }  
   //修改操作  
   /*
    * 根据账号进行修改数据
    */
   public void update(UserMod usermod) throws Exception {  
       String sql = "UPDATE student SET password=?,name=? WHERE username=?" ;  
       PreparedStatement pstmt = null ;  
       DBconn dbc = null ;  

       try{  
           // 连接数据库  
    	   dbc = new DBconn() ;  
           pstmt = dbc.getConnection().prepareStatement(sql) ;  
           pstmt.setString(1, usermod.getPassword());
           pstmt.setString(2, usermod.getName());
           pstmt.setString(3, usermod.getUsername()); 
           // 进行数据库更新操作  
           pstmt.executeUpdate() ;  
           pstmt.close() ;  
       }  
       catch (Exception e){  
           throw new Exception("操作出现异常") ;  
       }  
       finally{  
           // 关闭数据库连接  
           dbc.close() ;  
       }  
   }  
   //删除操作  
   /*
    * 通过账号查询进行删除操作
    */
   public void delete(String username) throws Exception {  
       String sql = "DELETE FROM student WHERE username=?" ;  
       PreparedStatement pstmt = null ;  
       DBconn dbc = null ;    
       try{  
           // 连接数据库  
           dbc = new DBconn() ;  
           pstmt = dbc.getConnection().prepareStatement(sql) ;           
           pstmt.setString(1,username) ;  
           // 进行数据库更新操作  
           pstmt.executeUpdate() ;  
           pstmt.close() ;  
       }catch (Exception e){  
           throw new Exception("操作出现异常") ;  
       }  
       finally{  
           // 关闭数据库连接  
           dbc.close() ;  
       }  
   }  
   //按ID查询  
   /*
    * 用于登陆验证(non-Javadoc)
    * @see com.study.dao.UserModDao#queryById(java.lang.String)
    */
   public UserMod queryById(String username) throws Exception {  
	   UserMod usermod = null ;  
       String sql = "SELECT * FROM user WHERE username=?" ;  
       PreparedStatement pstmt = null ;  
       DBconn dbc = null ;
       
       try{  
           // 连接数据库  
           dbc = new DBconn() ;  
           pstmt = dbc.getConnection().prepareStatement(sql) ;           
           pstmt.setString(1, username);  
           // 进行数据库查询操作  
           ResultSet rs = pstmt.executeQuery() ;  
           if(rs.next())  
           {  
               // 查询出内容，之后将查询出的内容赋值给usermod对象  
               usermod = new UserMod() ;  
               usermod.setUsername(rs.getString(1));  
               usermod.setPassword(rs.getString(2));
               usermod.setName(rs.getString(3));
           }  
           rs.close() ;  
           pstmt.close() ;  
       }catch (Exception e){  
           throw new Exception("操作出现异常") ;  
       }  
       finally{  
           // 关闭数据库连接  
           dbc.close() ;  
       }  
       return usermod ;  
   }  
   //查询所有数据
   public List<UserMod> queryAll() throws Exception {  
       List<UserMod> all = new ArrayList<UserMod>() ;  
       String sql = "SELECT * FROM student " ;  
       PreparedStatement pstmt = null ;  
       DBconn dbc = null ;  
 
       try{  
           // 连接数据库  
           dbc = new DBconn() ;  
           pstmt = dbc.getConnection().prepareStatement(sql) ;   
           // 进行数据库查询操作  
           ResultSet rs = pstmt.executeQuery() ;  
           while(rs.next()){  
               // 查询出内容，之后将查询出的内容赋值给usermod对象  
        	   UserMod usermod = new UserMod() ;  
        	   usermod.setUsername(rs.getString(1));  
        	   usermod.setPassword(rs.getString(2));
        	   usermod.setName(rs.getString(3));
               // 将查询出来的数据加入到List对象之中  
               all.add(usermod) ;  
           }  
           rs.close() ;  
           pstmt.close() ;  
       }  
       catch (Exception e){  
           throw new Exception("操作出现异常") ;  
       }  
       finally{  
           // 关闭数据库连接  
           dbc.close() ;  
       }  
       return all ;  
   }
}  

