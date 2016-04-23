<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  
 发起项目
  <form id="add" action="${z:u('add2')}" method="post">
  项目名称：<input type="text" name="project"/><br>
项目指标数：<input type="text" name="num"><br>
 <input type="submit" value="提交"/>
  </form>
  
  <%-- 登陆
<form id="login" action="${z:u('login')}" method="post">
账号：<input name="account" type="text"><br>
密码：<input name="password" type="password"><br>
<input type="submit" value="登陆">
</form> --%>
  </body>
</html>
