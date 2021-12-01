<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>登录页面</title>
<style>
*{padding:0px;margin:0px;font-family:'微软雅黑'}
a{text-decoration:none}
img{border:none}
#bg{width:658px;height:438px;border:1px solid #ccc;margin:0px auto;background:url(images/13.jpg) no-repeat;position:relative}
#sbg{width:100px;height:200px;position:absolute;top:80px;right:48px;line-height:25px;text-align:center}
#sbg p{font-size:14px;color:#fff}
#sbg a{font-size:14px;color:#FF0}
#sbg .sub{margin-right:15px;width:36px;height:21px;border:1px solid #ccc;color:#fff;background:#52f2b9}
#boxp{width:150px;height:150px;border:1px solid #333;position:absolute;top:30px;left:0px}
#boxp p{text-align:center;line-height:30px;color:#666}
</style>
</head>

<body>
<body id="bg">
    <div id="sbg">
        <h4>管理员</h4>
        <form action="LoginServlet.do" method="post">
            <p>用户名：<input type="text" name="username" class="txt1" autofocus="autofocus"/></p>
            <p>&nbsp;&nbsp;&nbsp; 密码：<input type="password" name="password" class="txt2"/></p>
			<p>&nbsp;&nbsp;自动登录:<input type="radio" name="time" value="0"/>
			不自动登录 <input type="radio" name="time" value="1"/>1天 
			<input type="radio" name="time" value="7" checked="checked"/>7天</p>
			<p><input type="submit"name="sub" value="提交" class="sub"/>
			<input type="reset" value="取消" class="sub"></p>
			<p><a href="zhuce.jsp">还没有账号？点我注册！</a></p><br/>
        </form>
</div>
</body>
</body>