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
    
    <title>admin</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${__static__ }/css/style.css">
	<script type="text/javascript" src="${__static__}/js/jquery-1.9.0.js"></script>
	<script type="text/javascript">
		var ZLZ = window.ZLZ = {
			"ROOT"   : "${__root__}",
			"URL"    : "${__url__}",
			"STATIC" : "${__static__}"
		}
function resetUser(this_,userId){
 	if(confirm("确定重置该用户的密码吗？")){
		 $.post("${z:u('reset_pass')}",{userId:userId},function(result){
				if(result.data>0){
					alert("操作成功");
					getTest();
					$(this_).parent().parent().remove();
				}
		},"json");
	 }
}		
	</script>

  </head>
  
  <body>
    
  <div class="main">
  <div class="project">◆重置密码</div>
  <div class="chose">
  <div class="chosed">账号</div>
  <div class="chosed">姓名</div>
   <div class="chosed">性别</div>
    <div class="chosed">年龄</div>
     <div class="chosed">手机</div>
      <div class="chosed">操作</div>
  
   <c:forEach var="users" items="${users}" varStatus="status" >
			<div class="chosed">${users.account }</div>
				<div class="chosed">${users.name }</div>
				<div class="chosed">${users.gender }</div>
				<div class="chosed">${users.age }</div>
				<div class="chosed">${users.phone }</div>
				<div class="chosed">
				<input type="button" onclick="resetUser(this,${users.id})" value="重置密码">
   		        </div>
		</c:forEach>

   	<c:if test="${param.currentpage>1 }">
   		<a href="admin/select_alluser?&currentpage=${param.currentpage-1}">上一页</a>
   	</c:if>
   	<c:if test="${param.currentpage<=1 }">
   		<a>上一页</a>
   	</c:if>
   	
   	<c:if test="${totalpage>param.currentpage }">
   		<a href="admin/select_alluser?&currentpage=${param.currentpage+1}">下一页</a>
   	</c:if>
   	<c:if test="${totalpage<=param.currentpage }">
   		<a>下一页</a>
   	</c:if>
  </div>
  </div>
   	
  </body>
</html>
