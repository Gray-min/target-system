<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://zlzkj.com/tags" prefix="z" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modify_password.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function password(){
var pas1,pas2;
pas1=document.getElementById("password1").value;
pas2=document.getElementById("password2").value;
if(pas1.length<8){
alert("密码必须大于8位，请重新输入！");
return;
}
if(!(pas1==pas2 && pas2!='')){
alert("两次输入的密码不一致，请重新输入！");
return;
}
}
</script >
  </head>
  
  <body>
    <form method="post" name="${z:u('modify_password')}">
  新密码：
   <input type="text" name="password1"><br>
 确认密码：
    <input type="text" name="password2"><br>
   <input type="submit" onClick="password">
   </form>
  </body>
</html>
