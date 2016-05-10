<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://zlzkj.com/tags" prefix="z"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'info.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="${__static__ }/css/style.css">
	
</script>
  </head>
  
  <body>
   <br>
   <div class="main">
  <div class="project">◆个人信息</div>
 <c:forEach var="userinfo" items="${userinfo }" varStatus="status" >
  <div class="infoleft">
		<div class="info">
        <div class="infot">账号</div>
        <div class="infoc">${userinfo.account }</div>
        </div>
	   <div class="info">
       <div class="infot">姓名</div>
       <div class="infoc">${userinfo.name }</div>
       </div>
       <div class="info">
       <div class="infot">年龄</div>
       <div class="infoc">${userinfo.age }</div>
       </div>
       <div class="info">
       <div class="infot">性别</div>
       <div class="infoc">${userinfo.gender}</div>
       </div>
       <div class="info">
       <div class="infot">生日</div>
       <div class="infoc">${userinfo.birth }</div>
       </div>
       <div class="info">
       <div class="infot">电话</div>
       <div class="inforight">
        <img width="215px" height="280px" src="${userinfo.picture }">
        <br>
        <br>
         <form id="form" action="savepic" method="post" enctype="multipart/form-data">
           <input class="jq-validatebox w300" type="file" name="ImportFile"
				data-options="required:true" />
           <button type="submit" onClick="submit()">submit</button>
         </form>
       </div>
       <div class="infoc">${userinfo.phone }</div>
       </div>
		</div>
 </c:forEach>
		</div>
  </body>
  
</html>
