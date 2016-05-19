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
    
    <title>My JSP 'finish.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${__static__ }/css/style.css">

  </head>
  
  <body>
  <div class="main">
  <div class="title" style="margin-top:20px;padding-left:20px;">◆项目：${sessionScope.project }</div>
  <div class="title" style="margin-top:20px;padding-left:20px;">账号 &nbsp;&nbsp;
             <c:forEach var="fuwa" items="${sessionScope.target }" >
                 <c:out value="${fuwa}" />&nbsp;&nbsp;     
              </c:forEach>
              总和：
 </div>
 <br>
 <div class="account"style="padding-left:20px;">
 <c:forEach var="project" items="${project }" >
                 <c:out value="${project.account}" /><br><br>
              </c:forEach>
</div>

<div class="fs" style="position:fixed;left:120px;top:104px">
 <c:forEach var="fu" items="  ${sessionScope.score }" >
               <c:choose>
    <c:when test="${fu==' f'}">
     <br><br>
    </c:when>
    <c:when test="${fu ==' f]'}">
        <br><br>
    </c:when>
    <c:otherwise>
        ${fu }&nbsp;&nbsp;&nbsp;&nbsp;
    </c:otherwise>
</c:choose>
</c:forEach>
</div>
&nbsp;&nbsp;总分${sessionScope.zf }
</div>
  </body>
</html>
