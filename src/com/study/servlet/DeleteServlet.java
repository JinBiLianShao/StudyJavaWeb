package com.study.servlet;
/*
 * 删除学生数据
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.dao.ModDao;
import com.study.url.MDAOFactory;

import java.io.IOException;

@WebServlet("/deleteStudent")
public class DeleteServlet extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	String id = req.getParameter("id");
        ModDao modDao = MDAOFactory.getUserDAOInstance();
        try{
        	modDao.delete(id);
        	resp.sendRedirect("main.jsp");
        }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}