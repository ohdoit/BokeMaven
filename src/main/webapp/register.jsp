<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page isELIgnored="false" %> --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>注册</title>
	<link rel="stylesheet" href="js/bootstrap-4.1.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/login.css">
	<link rel="stylesheet" href="css/common.css">
</head>
<body class="text-center" rlt="1">
<div class="container">
<form class="form-signin" action="boke/systemUser.action" method="post">
	<h1 class="h3 mb-3 font-weight-normal">请填写以下信息</h1>
	<label class="sr-only" for="account">账号：</label>
	<input id="account" class="form-control" required autofocus type="text" name="account" 
		placeholder="账号" value="${account }"/>
	<label class="sr-only" for="password">密码：</label>
	<input id="password" class="form-control" required autofocus name="password" type="password" 
		placeholder="密码" value="${password }"/>
	<button class="btn btn-lg btn-primary btn-block mt-3" type="submit" >注册</button>
	<div class="mt-3 text-danger">${message }</div>
	<p class="mt-5 mb-3 text-muted">© 2017-2018</p>
</form>
</div>
</body>
</html>