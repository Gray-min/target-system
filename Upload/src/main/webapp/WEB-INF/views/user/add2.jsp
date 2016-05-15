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
    
    <title>My JSP 'add2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${__static__ }/css/style.css">
<script type="text/javascript">

function validate_required(field,alerttxt)
{
with (field)
  {
  if (value==null||value=="")
    {alert(alerttxt);return false}
  else {return true}
  }
}

function validate_form(thisform)
{
with (thisform)
  {
  if (validate_required(target,"指标不能为空！")==false)
    {target.focus();return false}
  }
   if (validate_required(score,"分数不能为空！")==false)
    {score.focus();return false}
}
</script>
  </head>
  
  <body>
  <div class="main">
  <div class="project">
  ◆填写指标和分数
  </div>
   <form id="add" action="${z:u('add')}" method="post">
  <%
  int num =Integer.parseInt(request.getParameter("num"));
 //String project= request.getParameter("project");
for(int i=0;i<num;i++)
   {
   out.print("<div class='project'>指标：");
  out.print("<input type='text' name='target'>");
  out.print("&nbsp;&nbsp;");
   out.print("分数：");
  out.print("<input type='text' name='score'>");
  out.print("</div>");
   }    
%>
<input type="hidden" value="${param.project }" name="project">
<div class="project">
 <input type="submit" value="提交"/>
 </div> 
  </form>
  </div>
  </body>
</html>
