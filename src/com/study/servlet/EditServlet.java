package com.study.servlet;
/*
 * 修改页面
 */
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.dao.ModDao;
import com.study.mod.Mod;
import com.study.url.MDAOFactory;

import java.io.IOException;

@WebServlet("/editStudent")
public class EditServlet extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	ModDao modDao = MDAOFactory.getUserDAOInstance();
    	String id = req.getParameter("id");
        try{
        Mod mod = new Mod();
        mod = modDao.get(id);
        if(mod != null){
        req.setAttribute("mod", mod);
        req.getRequestDispatcher("/editStudent.jsp").forward(req, resp);
        }else{
        	resp.sendRedirect("error.html");
        }
        }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
