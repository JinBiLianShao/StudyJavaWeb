package com.study.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.dao.UserModDao;
import com.study.mod.UserMod;
import com.study.url.UDAOFactory;

/**
 * Servlet implementation class zhuceServlet
 */
@WebServlet("/zhuceServlet.do")
public class zhuceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public zhuceServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Content-Type","text/html;charset=UTF-8");
		//调用Dao方法
		UserModDao usermodDao = UDAOFactory.getUserDAOInstance();
		try {
		//调用mod的方法
		UserMod usermod = new UserMod();
		//从前台获取数据
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//往数据库添加数据
		usermod.setName(name);
		usermod.setUsername(username);
		usermod.setPassword(password);
		usermodDao.insert(usermod);
		response.sendRedirect("Login.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
