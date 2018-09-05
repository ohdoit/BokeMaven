<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>请求路径 ANT 风格</div>
	<div>1.使用?作为路径的占位符，一个?表示一个字符。</div>
	<div>2.使用*作为路径的占位符，表示0个或多个字符，表示请求路径可以补充任意个字符。</div>
	<br/>
	
	<div>路径参数：${user }</div>
	<div>请求参数：${username }，注意：该参数名username以路径参数名user开始，所以会取得值</div>
</body>
</html>