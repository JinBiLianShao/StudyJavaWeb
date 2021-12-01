package com.study.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.dao.ModDao;
import com.study.mod.Mod;
import com.study.url.MDAOFactory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/updateStudent")
public class UpdateServlet extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Mod mod = new Mod();
        //前台数据
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String dept = req.getParameter("dept");
        ModDao modDao = MDAOFactory.getUserDAOInstance();
        try {
        	 mod.setId(id);
             mod.setName(name);
             mod.setSex(sex);
             mod.setDept(dept);
             modDao.update(mod);
             resp.sendRedirect("main.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }

        

        
    }
}
