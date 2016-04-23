<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://zlzkj.com/tags" prefix="z" %>

<!doctype html>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>index</title>
</head>
<body>
注册
<form id="regist" action="${z:u('regist')}" method="post">
账号：<input name="account" type="text"><br>
密码：<input name="password" type="password"><br>
<input type="submit" value="注册">
</form>
</body>
</html>