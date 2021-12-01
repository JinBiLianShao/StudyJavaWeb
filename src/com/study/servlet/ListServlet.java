package com.study.servlet;
import javax.servlet.RequestDispatcher;
/*
 * 显示全部信息
 */
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.dao.ModDao;
import com.study.mod.Mod;
import com.study.url.MDAOFactory;

import java.io.IOException;
import java.util.List;

@WebServlet("/listStudent")
public class ListServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	ModDao modDao = MDAOFactory.getUserDAOInstance();
      
        	resp.sendRedirect("main.jsp");
       
    }
}
