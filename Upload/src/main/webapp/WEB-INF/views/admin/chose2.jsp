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
    
    <title>My JSP 'chose.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="${__static__ }/css/style.css">
	

  </head>
  
  <body>
  
  <div class="main">
  <div class="project">◆选择打分人员</div>
  <div class="chose">
  <div class="chosed">账号</div>
  <div class="chosed">姓名</div>
   <div class="chosed">性别</div>
    <div class="chosed">年龄</div>
     <div class="chosed">手机</div>
      <div class="chosed">选择</div>
  <form action="${z:u('chose2')}" method="post">
   <c:forEach var="users" items="${users}" varStatus="status" >
			<div class="chosed">${users.account }</div>
				<div class="chosed">${users.name }</div>
				<div class="chosed">${users.gender }</div>
				<div class="chosed">${users.age }</div>
				<div class="chosed">${users.phone }</div>
				<div class="chosed"><input type="checkbox" name="account" value="${users.account}"></div>
		</c:forEach>
		<input type="submit" value="提交">
		</form>
  
  </div>
  </div>
  </body>
</html>
