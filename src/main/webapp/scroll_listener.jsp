<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="js/bootstrap-4.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="css/common.css">
<title>滚动监听</title>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50" class="scroll_position">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="nav-link" href="#section1">Section 1</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#section2">Section 2</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#section3">Section 3</a>
			</li>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Section 4</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#section41">Link 1</a>
					<a class="dropdown-item" href="#section42">Link 2</a>
				</div>
			</li>
		</ul>
	</nav>
	<div id="section1" class="container-fluid bg-success" style="padding:70px 10px;">
		<h1>Section 1</h1>
	  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
	  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
	</div>
	<div id="section2" class="container-fluid bg-warning" style="padding-top:70px;padding-bottom:70px">
	  <h1>Section 2</h1>
	  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
	  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
	</div>
	<div id="section3" class="container-fluid bg-secondary" style="padding-top:70px;padding-bottom:70px">
	  <h1>Section 3</h1>
	  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
	  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
	</div>
	<div id="section41" class="container-fluid bg-danger" style="padding-top:70px;padding-bottom:70px">
	  <h1>Section 4 Submenu 1</h1>
	  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
	  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
	</div>
	<div id="section42" class="container-fluid bg-info" style="padding-top:70px;padding-bottom:70px">
	  <h1>Section 4 Submenu 2</h1>
	  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
	  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
	</div>

	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="js/popper.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-4.1.1/js/bootstrap.min.js"></script>
</body>
</html>