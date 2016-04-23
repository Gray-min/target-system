<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://zlzkj.com/tags" prefix="z"%>

<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>zframe整合框架</title>
<script type="text/javascript">
	var ZLZ = window.ZLZ = {
		"ROOT" : "${__root__}",
		"URL" : "${__url__}",
		"STATIC" : "${__static__}"
	}
</script>
</head>
<body>
	<div style="width:60%;margin: 0 auto;padding-top:30px; height: auto;">
		<form id="form" action="${__url__}" method="post" enctype="multipart/form-data">
			<input class="jq-validatebox w300" type="file" name="ImportFile"
				data-options="required:true" />
			<button type="submit" onclick="submit()">submit</button>
		</form>
		<br><br><br><br>
		<a href="${z:u('/findpic')}">查看图片</a>
	</div>
</body>
</html>