<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page isELIgnored="false" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>登陆</title>
	<link rel="stylesheet" href="../js/bootstrap-4.1.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/login.css">
	<link rel="stylesheet" href="../css/common.css">
</head>
<body class="text-center" rlt="1">
<div class="container">
<div>
	<a href="login.action?locale=zh_CN">中文</a> | <a href="login.action?locale=en_US">English</a>
</div>
<form class="form-signin" action="doLogin.action" method="post">
	<h1 class="h3 mb-3 font-weight-normal"><spring:message code="pleaseLogin" /></h1>
	<label class="sr-only" for="account"><spring:message code="account" /></label>
	<input id="account" class="form-control" required autofocus type="text" name="account" 
		placeholder=<spring:message code="account" /> value="${account }"/>
	<label class="sr-only" for="password"><spring:message code="password" /></label>
	<input id="password" class="form-control" required autofocus name="password" type="password" 
		placeholder=<spring:message code="password" /> value="${password }"/>
	<button class="btn btn-lg btn-primary btn-block mt-3" type="submit" ><spring:message code="login" /></button>
	<div class="mt-3 text-danger">${message }</div>
	<p class="mt-5 mb-3 text-muted">© 2017-2018</p>
</form>
</div>
</body>
</html>