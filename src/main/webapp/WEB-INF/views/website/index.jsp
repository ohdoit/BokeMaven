<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> -->
<!-- EL表达式生效 -->
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人首页</title>
</head>
<body>
<div>欢迎您，${username } </div> 
<div>博客首页</div>
<div><a href="./personInfo.jsp">个人信息</a></div>
</body>
</html>