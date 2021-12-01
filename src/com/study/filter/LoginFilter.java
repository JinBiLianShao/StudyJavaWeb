package com.study.filter;
import javax.jws.WebParam;
/*
 * 过滤器
 */
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(
		filterName = "loginFilter",
		urlPatterns = {""},
		initParams = {
				@WebInitParam(name="encoding", value="UTF-8"),
				@WebInitParam(name="loginPage", value="Login.jsp"),
				@WebInitParam(name="proLogin", value=".jsp")
		}
		)
public class LoginFilter implements Filter {
	private FilterConfig config;
	public void init(FilterConfig fConfig) throws ServletException {
		config = fConfig;
    }
    public void destroy() {
    	config=null;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
    	
    	String encoding = config.getInitParameter("encoding");
    	String loginPage = config.getInitParameter("loginPage");
    	String proLogin = config.getInitParameter("proLogin");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(true);
        // 设置编码格式为 UTF-8
        request.setCharacterEncoding("UTF-8");
		String requestPath = request.getServletPath();
		if(session.getAttribute("password") == null
				&&!requestPath.endsWith(loginPage)
				&&!requestPath.endsWith(proLogin)){
			request.setAttribute("message", "您还没有登陆");
			request.getRequestDispatcher(loginPage).forward(req, resp);
		}else{
        chain.doFilter(request, response);
		}
    }
 

   
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

}
