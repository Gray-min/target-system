<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://zlzkj.com/tags" prefix="z"%>
<heand>
<script type="text/javascript" src="${__static__}/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${__static__ }/css/style.css">
<script type="text/javascript">
	// 提交
	function form_submit(){
		$.ajax({
			url:"${z:u('change_pass')}",
			type:"POST",
			data:{account:$("#account").val(),OPass:$("#OPass").val(),NPass:$("#NPass").val()},
			dataType:"json",
			success:function(json){
				$("#OPass").val("");
				$("#NPass").val("");
				//$("#msg").removeClass("error").addClass("right").html(json.info);
				alert(json.info);
			},
			error: function(err){
				alert("err");
			}
		});
	}

</script>

</heand>
<body>
<div class="main">
<div class="project">◆修改密码</div>
    <table align="left" class="form-table" style="margin:40px 50px">
    	<tr>
			<td>账号：</td>
			<td colspan="4" >
				<input id="account" class="w200" name="name" class="jq-validatebox" readonly="readonly"  value='${sessionScope.account}' type="text" data-options="required:true">
			</td>
		</tr>
		<tr><td colspan="5"></td></tr>
		<tr><td colspan="5"></td></tr>
		<tr>
			<td>原密码：</td>
			<td colspan="4" >
				<input id="OPass" class="w200" name="OPass" class="jq-validatebox" value="" type="password" data-options="required:true">
			</td>
		</tr>
		<tr><td colspan="5"></td></tr>
		<tr><td colspan="5"></td></tr>
		<tr>
			<td>新密码：</td>
			<td colspan="4" >
				<input id="NPass" class="w200" name="NPass" class="jq-validatebox" value="" type="password" data-options="required:true">
			</td>
		</tr>
		<tr><td colspan="5"></td></tr>
		<tr><td colspan="5"></td></tr>
		<tr>
			<td><button onclick="form_submit()" class="btn btn-small btn-success">确定</button></td>
			<td>
				&nbsp;
				<!-- <a class="btn btn-primary btn-small" href="">返回</a> -->
			</td>
		</tr>
		<tr><td><span class="error" id="msg"></span></td></tr>
	</table>
	</div>
</body>