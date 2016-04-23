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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <table>
  <form action="${z:u('chose')}" method="post">
   <c:forEach var="doit" items="${doit}" varStatus="status" >
			<tr>
			   <td>项目名称：${doit.project }</td>
		   ${sessionScope.target }
				<td>指标：${doit.target }</td>
				<td>总分：${doit.score }</td>
				<td>你的给分：<input type="text" name="point">
			</tr>
		</c:forEach>
		<input type="submit" value="提交">
		</form>
		</table>
		<c:forEach var="target" items="${target}">
		
		
		</c:forEach>
  </body>
</html>
