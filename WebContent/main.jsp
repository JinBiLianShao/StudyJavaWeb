<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*,com.study.mod.*,com.study.servlet.*,com.study.url.*,com.study.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息管理系统</title>
<style>
*{padding:0px;margin:0px;font-family:'楷体';color:#333;}
a{text-decoration:none;}
#bigbox{width:800px;height:500px;margin:20px auto;background:#f5f5f5;position:relative;}
#caxun{width:800px;height:60px;background:url(images/1.png) no-repeat;left:30px top:20px;}
#caxun h1{text-align:center;line-height:60px;}
#cazhao{margin:0px auto;position:absolute;right:0px;}
#from{width:760px;height:120px;margin:50px auto;}
#from h3{text-align:center;}
#from td{text-align:center;}
#add{width:280px;height:240px;margin-left:30px;background:#eee;margin:20px auto;position:absolute;right:10px;top:105px}
#add p{line-height:10px;text-align:center;margin-top:18px;}
#add h4{text-align:center;}
#add .sub{width:45px;height:26px;border:1px solid #eee;margin-right:20px;margin-top:6px;}
#add .ret{width:45px;height:26px;border:1px solid #eee;margin-right:20px;margin-top:6px;}
#add a {position:absolute; right:5px }
</style>
</head>
<body>
<div id="bigbox">
	<div id="caxun">
		<h1>学生信息管理系统</h1>
	</div>
	<div id="cazhao">
		<h4>学生信息查询</h4>
		<form action="./editStudent" id="text" method="post">
		学号：<input type="text" name="id"/><input type="submit" value="查找"/>
		</form>
		<%/*
        ModDao moddao = MDAOFactory.getUserDAOInstance();  
        Mod mod1 = moddao.queryById(request.getParameter("id"));
        out.println("学号：" + mod1.getId()+ "<br>");  
        out.println("姓名：" + mod1.getName()+ "<br>");
        out.println("性别：" + mod1.getSex()+ "<br>");
        out.println("班级：" + mod1.getDept()+ "<br>");
		*/%>
	</div>
	<div id="from">
		<h4>学生信息表</h4>
	<table border="1">
		<tr><td>学号</td><td>姓名</td><td>性别</td><td>班级</td><td>修改</td><td>删除</td></tr>
		<%
		ModDao modDao = MDAOFactory.getUserDAOInstance();  
        //查询所有用户  
        List<Mod> all = modDao.queryAll(); 
        Iterator<Mod> iter = all.iterator();
        while(iter.hasNext()) {  
        	Mod mod = iter.next();
		%>
		<tr>
              <td>&nbsp;<%=mod.getId()%>&nbsp;</td>
              <td>&nbsp;<%=mod.getName()%>&nbsp;</td>
              <td>&nbsp;<%=mod.getSex()%>>&nbsp;</td>
              <td>&nbsp;<%=mod.getDept()%>&nbsp;</td>
              <td>&nbsp;<a href="./editStudent?id=<%= mod.getId()%>">修改</a>&nbsp;</td>
              <td>&nbsp;<a href="./deleteStudent?id=<%= mod.getId()%>">删除</a>&nbsp;</td>
          </tr>
            <%}
       %>
	</table>
	</div>
	<div id="add">
		<h4>增添学生信息</h4>
		<form action="./addStudent" method="post" id="sub">
			学号：<input type="text" name="id"/><br>
			姓名：<input type="text" name="name"/><br>
			性别：<input type="radio" name="sex" value="男">男&nbsp;<input type="radio" name="sex" value="女">女<br>
			班级：<input type="text" name="dept"><br>
			<input type="submit" value="提交"><input type="reset" value="取消">
		</form>
		<a href="Login.jsp">退出登陆</a>
	</div>
</div>
</body>
</html>