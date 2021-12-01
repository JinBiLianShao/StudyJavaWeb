package com.study.dao;
/*
 * DAO实现类
 */
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.util.ArrayList;  
import java.util.List;
import com.study.mod.Mod;
import com.study.url.DBconn;    
 
public class ModDaoImpl implements ModDao {  
   //添加操作  
	/*
	 * 用于注册页面使用，添加信息。
	 */
   public void insert(Mod mod) throws Exception {  
       String sql = "INSERT INTO student(id,name,sex,dept) VALUES(?,?,?,?)";//SQL语句
       PreparedStatement pstmt = null ; //初始化
       DBconn dbc = null ;  

       try{  
           // 连接数据库  
           dbc = new DBconn() ;  
           pstmt = dbc.getConnection().prepareStatement(sql) ;  
           pstmt.setString(1, mod.getId());  
           pstmt.setString(2, mod.getName());
           pstmt.setString(3, mod.getSex());
           pstmt.setString(4, mod.getDept());
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
   public void update(Mod mod) throws Exception {  
       String sql = "UPDATE student SET name=?,sex=?,dept=? WHERE id=?" ;  
       PreparedStatement pstmt = null ;  
       DBconn dbc = null ;  

       try{  
           // 连接数据库  
    	   dbc = new DBconn() ;  
           pstmt = dbc.getConnection().prepareStatement(sql) ;  
           pstmt.setString(1, mod.getName());  
           pstmt.setString(2, mod.getSex());
           pstmt.setString(3, mod.getDept());
           pstmt.setString(4, mod.getId()); 
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
   public void delete(String id) throws Exception {  
       String sql = "DELETE FROM student WHERE id=?" ;  
       PreparedStatement pstmt = null ;  
       DBconn dbc = null ;    
       try{  
           // 连接数据库  
           dbc = new DBconn() ;  
           pstmt = dbc.getConnection().prepareStatement(sql) ;           
           pstmt.setString(1,id) ;  
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
   public Mod queryById(String id) throws Exception {  
	   Mod mod = null ;  
       String sql = "SELECT * FROM student WHERE id=?" ;  
       PreparedStatement pstmt = null ;  
       DBconn dbc = null ;
       
       try{  
           // 连接数据库  
           dbc = new DBconn() ;  
           pstmt = dbc.getConnection().prepareStatement(sql) ;           
           pstmt.setString(1, id);  
           // 进行数据库查询操作  
           ResultSet rs = pstmt.executeQuery() ;  
           if(rs.next())  
           {  
               // 查询出内容，之后将查询出的内容赋值给mod对象  
               mod = new Mod() ;  
               mod.setId(rs.getString(1));  
               mod.setName(rs.getString(2));  
               mod.setSex(rs.getString(3));
               mod.setDept(rs.getString(4));
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
       return mod ;  
   }  
   /*
    * 修改
    */
   public Mod get(String id) throws Exception{
	   Mod mod = null ;   
       PreparedStatement pstmt = null ;  
       DBconn dbc = null ;
	   

       String sql = "SELECT * FROM student WHERE ID = " + id;
       try {
    	   dbc = new DBconn() ;  
           pstmt = dbc.getConnection().prepareStatement(sql) ;
           ResultSet rs = pstmt.executeQuery() ; 
           if (rs.next()) {
        	   mod = new Mod();
        	   String student_id = rs.getString("student_id");
               String name = rs.getString("name");
               String sex = rs.getString("sex");
               String dept = rs.getString("dept");
               mod.setId(student_id);
               mod.setName(name);
               mod.setSex(sex);
               mod.setDept(dept);
           }
           rs.close() ;  
           pstmt.close() ;
       } catch (Exception e) {
           e.printStackTrace();
       }

       return mod;
   }
   //查询所有数据
   public List<Mod> queryAll() throws Exception {  
       List<Mod> all = new ArrayList<Mod>() ;  
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
               // 查询出内容，之后将查询出的内容赋值给mod对象  
        	   Mod mod = new Mod() ;  
        	   mod.setId(rs.getString(1));  
               mod.setName(rs.getString(2));  
               mod.setSex(rs.getString(3));
               mod.setDept(rs.getString(4)); 
 
               // 将查询出来的数据加入到List对象之中  
               all.add(mod) ;  
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

   public List<Mod> list() throws Exception {

       List<Mod> students = new ArrayList<>();
       PreparedStatement pstmt = null ;  
       DBconn dbc = null ;
       String sql = "SELECT * FROM student ORDER BY student_id desc limit ?,?";

       try {
    	   dbc = new DBconn() ;  
           pstmt = dbc.getConnection().prepareStatement(sql) ;
           ResultSet rs = pstmt.executeQuery();
           while (rs.next()) {
        	   Mod mod = new Mod();
        	   String student_id = rs.getString("student_id");
               String name = rs.getString("name");
               String sex = rs.getString("sex");
               String dept = rs.getString("dept");
               mod.setId(student_id);
               mod.setName(name);
               mod.setSex(sex);
               mod.setDept(dept);
               students.add(mod);
           }

           rs.close();
           pstmt.close() ;

       } catch (Exception e) {
           e.printStackTrace();
       }

       return students;
   }
}  
