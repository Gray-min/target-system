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
   <table border="1">
   <tr><td>项目名称</td><td>已打分</td><td>打分情况</td><td>操作</td></tr>
  
   <c:forEach var="mark" items="${mark}" varStatus="status" >
			<tr>
				<td>${mark.project}</td>
				<td>${mark.point }</td>
				<td>
				<c:if test="${mark.status=='0' }">
				未打分
				</c:if>
				</td>
				<td><a href="doit?project=${mark.project }" target="iframe0">打分</a></td>
			
			</tr>
		</c:forEach>
		<!-- <input type="submit" value="提交"> -->
		
		</table>
		
  </body>
</html>
