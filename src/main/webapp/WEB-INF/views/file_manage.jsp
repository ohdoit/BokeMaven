<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> -->
<!-- EL表达式生效 -->
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件管理</title>
</head>
<body>
<div>欢迎您</div> 
<h4>采用流的方式上传文件</h4>
<form action="upload1.action" method="post" enctype="multipart/form-data">
	<label>请选择</label>
	<input type="file" name="file"/>
	<input type="submit" value="上传" />
</form>

<h4>采用Spring mvc提供的CommonsMultipartFile提供的file.transfer方法上传文件</h4>
<form action="upload2.action" method="post" enctype="multipart/form-data">
	<label>请选择</label>
	<input type="file" name="file"/>
	<input type="submit" value="上传" />
</form>

<h4>采用Spring mvc提供的MultipartHttpServletRequest上传文件</h4>
<form action="upload3.action" method="post" enctype="multipart/form-data">
	<label>请选择</label>
	<input type="file" name="file"/>
	<input type="submit" value="上传" />
</form>

<a href="download.action">下载</a>
</body>
</html>