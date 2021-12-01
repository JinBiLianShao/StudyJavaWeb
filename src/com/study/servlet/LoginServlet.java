package com.study.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.dao.UserModDao;
import com.study.mod.UserMod;
import com.study.url.UDAOFactory;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username"); //获取前台数据
		String password = request.getParameter("password");
		String time = request.getParameter("time");
		UserModDao usermodDao = UDAOFactory.getUserDAOInstance();
		try{	
				UserMod usermod = usermodDao.queryById(username);
				if(usermod != null){
				if(usermod.getUsername().equals(username)&&usermod.getPassword().equals(password)){
					response.sendRedirect("main.jsp");
				}else if(usermod.getUsername().equals(username)||usermod.getPassword().equals(password)){
					response.sendRedirect("error.html");
				}
				}else{
					response.sendRedirect("error.html");
				}
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	}
