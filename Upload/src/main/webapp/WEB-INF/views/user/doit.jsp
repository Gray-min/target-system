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
   <form action="${z:u('point')}" method="post">
  <div class="project">
  <c:forEach var="doit" items="${doit}" varStatus="status" >
          ◆项目名称：${doit.project }
          <input type="hidden" name="project" value="${doit.project }">
     </c:forEach>
     </div>
 	 <div class="zb">
		   <c:forEach var="fuwa" items="  ${sessionScope.target }" >
                 指标：<c:out value="${fuwa}" /><br><br>        
</c:forEach>
</div>
<div class="point">
		   <c:forEach var="fu" items="  ${sessionScope.score }" >
                总分：<c:out value="${fu}" />&nbsp;&nbsp;
你的给分：<input type="text" name="point"><br><br>
</c:forEach>
		</div>		
	 <div class="project">	<input type="submit" value="提交"></div>
		</form>
  </div>
  </body>
</html>
