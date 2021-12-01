package com.study.servlet;
/*
 * 增加学生数据
 */

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.dao.ModDao;
import com.study.mod.Mod;
import com.study.url.MDAOFactory;
import java.io.IOException;

@WebServlet("/addStudent")
public class AddServlet extends HttpServlet {
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Content-Type","text/html;charset=UTF-8");

        ModDao modDao = MDAOFactory.getUserDAOInstance();
        try{
        	String id = request.getParameter("id");
            String name = request.getParameter("name");
            String sex = request.getParameter("sex");
            String dept = request.getParameter("dept");
            Mod mod = new Mod();
            mod.setId(id);
            mod.setName(name);
            mod.setSex(sex);
            mod.setDept(dept);
            modDao.insert(mod);
            response.sendRedirect("main.jsp");
        }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
    }
}