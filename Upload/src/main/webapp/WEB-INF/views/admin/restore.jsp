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
    
    <title>prolist.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="${__static__ }/css/style.css">
	

  </head>
  
  <body>
  <div class="main">
  <div class="project">◆我的项目</div>
  <div class="pro">
  <div class="prod">项目名称</div>
  <div class="prod">情况</div>
  <div class="prod">操作</div>
   <c:forEach var="mark" items="${mark}" varStatus="status" >
			<div class="prod">${mark.project}</div>
          
				<div class="prod">已删除</div>
				<div class="prod"><a href="restore?project=${mark.project }" target="iframe0">还原</a></div>
			
			
		</c:forEach>
		
		 	<c:if test="${param.currentpage>1 }">
   		<a href="delete_prolist?&currentpage=${param.currentpage-1}">上一页</a>
   	</c:if>
   	<c:if test="${param.currentpage<=1 }">
   		<a>上一页</a>
   	</c:if>
   	
   	<c:if test="${totalpage>param.currentpage }">
   		<a href="delete_prolist?&currentpage=${param.currentpage+1}">下一页</a>
   	</c:if>
   	<c:if test="${totalpage<=param.currentpage }">
   		<a>下一页</a>
   	</c:if>
  </div>
  </div>
   
  </body>
</html>
