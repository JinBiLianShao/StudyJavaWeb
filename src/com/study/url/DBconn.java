package com.study.url;
/*
 * 数据库链接类
 */
import java.sql.*;

public class DBconn
{
	/*
	 * 数据库链接配置
	 */
    private final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DBURL = "jdbc:mysql://localhost:3306/student"+"?serverTimezone=GMT%2B8&characterEncoding=utf8";
    private final String USER = "root";
    private final String PASSWORD = "123456";
    private Connection conn=null;
    /*
     * 启动驱动
     */
    public DBconn()
    {
        try
        {
            Class.forName(DBDRIVER);
            this.conn = DriverManager.getConnection(DBURL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e)
        {
            System.out.println("加载驱动失败");
        }

    }
    
    public Connection getConnection()
    {
        return this.conn;
    }
    
    public void close()
    {
        if(this.conn!=null)
        {
            try
            {
                this.conn.close();
            } catch (SQLException e)
            {
                System.out.println("数据库连接关闭失败");
            }
        }
    }
}