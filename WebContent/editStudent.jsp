<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*,com.study.mod.*,com.study.servlet.*,com.study.url.*,com.study.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询修改学生信息</title>
<style type="text/css">
body {position:relative}
#form {position:absolute;top:0px; right:50%}
</style>
</head>
<body>
	<%
	ModDao modDao = MDAOFactory.getUserDAOInstance();  
    //指定按ID查询  
    Mod mod = modDao.queryById(request.getParameter("id")); 
	%>
	<div id="form">
	<h1>查询修改学生信息</h1>
	<form action="./updateStudent">
	学号: <input type="text" name="id" value="<%= mod.getId() %>"><br>
	姓名: <input type="text" name="name" value="<%= mod.getName() %>"><br>
	性别: <input type="text" name="sex" value="<%= mod.getSex() %>"><br>
	班级: <input type="text" name="dept" value="<%= mod.getDept() %>"><br>
	<input type="submit" value="提交"><input type="reset" value="取消">
	<a href="main.jsp">返回主页面</a>
	</form>
	</div>
</body>
</html>