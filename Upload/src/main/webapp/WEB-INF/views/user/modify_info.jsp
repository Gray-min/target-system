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
	<script type="text/javascript" src="${__static__}/js/jquery.min.js"></script>
<script type="text/javascript">
	// 提交
	function form_submit(){
		$.ajax({
			url:"${z:u('revise_info')}",
			type:"POST",
			data:{id:$("#id").val(),account:$("#account").val(),name:$("#name").val(),age:$("#age").val(),gender:$("#gender").val(),birth:$("#birth").val(),phone:$("#phone").val()},
			dataType:"json",
			success:function(json){
				//$("#OPass").val("");
				//$("#NPass").val("");
				//$("#msg").removeClass("error").addClass("right").html(json.info);
				alert(json.info);
			},
			error: function(err){
				alert("err");
			}
		});
	}

</script>
  </head>
  
  <body>
   <br>
   <div class="main">
  <div class="project">◆修改信息</div>
 <c:forEach var="userinfo" items="${userinfo }" varStatus="status" >
 <input id="id" type="hidden" value="${userinfo.id }" >
  <div class="infoleft">
		<div class="info">
        <div class="infot">账号</div>
        <div class="infoc">${userinfo.account }</div>
        </div>
	   <div class="info">
       <div class="infot">姓名</div>
       <div class="infoc"><input id="name" type="text" value="${userinfo.name }" name="name"></div>
       </div>
       <div class="info">
       <div class="infot">年龄</div>
       <div class="infoc"><input id="age" type="text" value="${userinfo.age }" name="age"></div>
       </div>
       <div class="info">
       <div class="infot">性别</div>
       <div class="infoc"><input id="gender" type="text" value="${userinfo.gender}" name="gender"></div>
       </div>
       <div class="info">
       <div class="infot">生日</div>
       <div class="infoc"><input id="birth" type="text" value="${userinfo.birth }" name="birth"></div>
       </div>
       <div class="info">
       <div class="infot">电话
        <br>
       <br>
       <button onclick="form_submit()" 	>确定</button>
       </div>
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
       <div class="infoc"><input id="phone" type="text" value="${userinfo.phone }" name="phone">
       </div>
       </div>
		</div>
 </c:forEach>
		</div>
  </body>
  
</html>
