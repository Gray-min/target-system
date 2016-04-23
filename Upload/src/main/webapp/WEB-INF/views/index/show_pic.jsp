<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://zlzkj.com/tags" prefix="z"%>

<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
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
	<div id="slidesContainer" style="width: 80%;margin: 0 auto; height:auto;">
		<c:forEach items="${Pic}" var="img">
			<div class="slide">
				<div class="part02">
					<img width="660px" height="340px" src="${img.url }">
				</div>
			</div>
		</c:forEach>
	</div>


	<input type="button" value="返回" onclick="history.go(-1)">
</body>
</html>