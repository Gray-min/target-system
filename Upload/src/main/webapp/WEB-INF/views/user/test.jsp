<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://zlzkj.com/tags" prefix="z" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${__static__}/js/jquery-1.9.0.js"></script>
<link rel="stylesheet" type="text/css" href="${__static__ }/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>test</title>
	<script type="text/javascript">
		var ZLZ = window.ZLZ = {
			"ROOT"   : "${__root__}",
			"URL"    : "${__url__}",
			"STATIC" : "${__static__}"
		}
/* function getTest(){ */
window.onload=function(){
	$("#div").html("");
	$.post("${z:u('test/test2')}",{},function(result){
		$.each(result.all_user,function(index,content){
			var div_ = "<div userId="+content.id+" >"+
							"<div>"+
								"id :"+"&nbsp;"+content.id+"&nbsp;&nbsp;&nbsp;&nbsp;name:&nbsp; "+content.name+"&nbsp;&nbsp;&nbsp;&nbsp;account:&nbsp;"+content.account+"&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"button\" onclick=\"deleteUser(this,"+content.id+")\" value=\"重置密码\" />"
							"</div>"+
							
							//"<div><input type=\"button\" onclick=\"deleteUser(this,"+content.id+")\" value=\"删除\" /></div>"+ 
						"</div>";
			$("#div").append(div_);
		});
	},"json");
}
function deleteUser(this_,userId){
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
function getLastUserId(){
	//alert($("#div").find("div:last").attr("userId"));
	alert($("#div").children("div:last").attr("userId"));
}
/* $(document).on("click", "input[type=button]", function() {  
	alert($(this).parent().parent().attr("userId"));
    //...  
});   */
	</script>
	<style type="text/css">
	#div {height:600px;width:1260px;border:1px #000 solid;margin-top:25px; margin-left:10px;}
	#div div{height:35px;width:800x;float:left}
	#div div div{height:35px;width:800px;margin-top:20px;margin-left:15px;}
	</style>
</head>
<body>
	<div id="div">
	</div>
	
</body>
</html>