<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.study.url.*"%> 
<%@ page import="com.study.dao.*"%>
<%@ page import="com.study.mod.*"%> 
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
    href="${pageContext.request.contextPath}/css/bootstrap.css" />
<style type="text/css">
body {
    font-size: 20px;
    padding-bottom: 40px;
    background-color: white;
    magin:0px;
    padding:0px;
}

a { text-decoration:none; color:blue}
 
.sidebar-nav {
    padding: 9px 0;
}
 
@media ( max-width : 980px) { /* Enable use of floated navbar text */
    .navbar-text.pull-right {
        float: none;
        padding-left: 5px;
        padding-right: 5px;
    }
}
 
.btn {
    position: absolute;
    top: 40%;
    left: 40%;
    color: blue;
    font-size: 20px;
}
.btn2 {
	text-indent:2;
	width:57px;
	height:30px;
	color:blue;
	background:#9999;
	border:1px solid #000;
    position: absolute;
    top: 50%;
    left: 50%;
    color: blue;
    font-size: 20px;
}
#outbox{width:400px;height:400px;border:1px solid #ccc;margin:50px auto;position:relative;background:#17aea8;}
#outbox h4{color:#fff;text-align:center;font-size:26px;margin-top:30px;}
span { position:absolute;button:0px;right:0px}
span a {color:#fff}
#neibox{width:300px;height:300px;font-size:14px;color:#333;position:absolute;top:76px;right:45px;line-height:50px;text-align:center;}
#neibox .sub{margin-right:15px;width:45px;height:30px;border:1px solid #ccc;color:#fff;background:#52f2b9;margin-top:10px}
#neibox .ret{margin-right:15px;width:45px;height:30px;border:1px solid #ccc;color:#fff;background:#ccc;}
</style>
<script type="text/javascript">
            function checkInput() {
                var username = document.form1.username.value;
                var name = document.form1.name.value;
                var password = document.form1.password.value;
                var password2 = document.form1.password2.value;
                if(username == "") {
                    alert("请输入账号!");
                    return false;
                } else if(name == "") {
                    alert("请输入姓名!");
                    return false;
                } else if(password == "") {
                    alert("请输入密码!");
                    return false;
                } else if(password2 == "") {
                    alert("请确认密码!");
                    return false;
                } else if(password!=password2){
                    alert("两次密码不一致!");
                    return false;
                }else
                {
                    return true;
                }
            }
        </script>
</head>
 
<body>
<div id="outbox">
	<h4>欢迎加入学生管理系统！</h4>
	<div id="neibox">
		<form name="form1" action="./zhuceServlet.do" method="post"
        onsubmit="return checkInput()">
		<P>请输入账号:<input type="text" name="username" id="username"autofocus="autofocus"/></P>
		<P>&nbsp;&nbsp;您的姓名:<input type="text" name="name" id="name"/></P>
		<p>请输入密码:<input type="password" name="password" id="password"/></p>
		<p>请确认密码:<input type="password" name="password2" id="password2" /></p>
		<p><input type="submit"name="sub" value="提交" class="sub"/>
		<input type="reset" value="取消" class="sub"><span><a href="Login.jsp">返回登陆页面</a></span></p>
		</form>
	</div>
</div>
</body>
 
</html>