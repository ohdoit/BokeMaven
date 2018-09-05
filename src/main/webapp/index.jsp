<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="js/bootstrap-4.1.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="js/jquery-ui-1.12.1/jquery-ui.min.css">
	<link rel="stylesheet" href="css/common.css">
	<title>博客首页</title>
</head>
<body class="bg-light">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="navbar-brand">Welcome to Boke</div>
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active">
			<a class="nav-link" href="#">首页</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="javascript:void(0)" data-toggle="modal" data-target="#myModal">模态框</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#" data-toggle="tooltip" data-placement="bottom" title="提示内容">提示框</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#" data-toggle="popover" data-trigger="hover" title="标题" data-content="内容">弹出框</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="scroll_listener.jsp">滚动监听器</a>
			</li>
			<li class="nav-item dropdown">
				<a id="dropdown1" class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">其他</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#">帮助</a> 
					<a class="dropdown-item" href="#">关于</a> 
				</div>
			</li>
		</ul>
		<form class="form-inline">
			<input class="form-control mr-sm-2" placeholder="搜索" type="text"/>
			<button class="btn btn-success" type="submit">搜索</button>
		</form>
		<ul class="navbar-nav ml-3">
			<li class="nav-item">
				<a class="nav-link" href="boke/login.action">登陆</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="register.jsp">注册</a>
			</li>
		</ul>
	</nav>
	<div class="container-fluid text-muted pt-2 pl-5 pr-5">
		<div class="row">
			<div class="col-2">
				<div class="list-group bg-white">
					<a class="list-group-item list-group-item-action">推荐</a>
					<a class="list-group-item list-group-item-action">推荐</a>
					<a class="list-group-item list-group-item-action">推荐</a>
				</div>
			</div>
			<div class="col-7" style="padding-left:0px;padding-right:0px;">
				<div><img alt="华为云" src="images/huaweiyun.jpg"></div>
				<div class="card mt-2">
					<div class="card-body">
						<h3 class="card-title">SpringMVC</h3>
						<a href="test/testAntOneABC">请求路径使用占位符?（ANT风格1）</a>
					</div>
				</div>
				<div class="card">
					<div class="card-body">
					<a href="test/testAntTwo">请求路径使用占位符*（ANT风格2）</a>
					</div>
				</div>
				<div class="card">
					<div class="card-body">
					<a href="test/testPathVariable/zhangsan">路径参数（PathVariable）</a>
					</div>
				</div>
				<div class="card">
					<div class="card-body">
					<a href="test/testRequestParam?username=lisi">路径参数（PathVariable）</a>
					</div>
				</div>
				<div class="card">
					<div class="card-body">
					<a href="testServlet">自定义Servlet</a>
					</div>
				</div>
				<div class="card">
					<div class="card-body">
					<a href="testHttpServlet">自定义HttpServlet</a>
					</div>
				</div>
			</div>
			<div class="col-3">
				<div id="demo" class="carousel slide" data-ride="carousel">
					<!-- 指示符 -->
					<ul class="carousel-indicators">
						<li data-target="#demo" data-slide-to="0" class="active"></li>
						<li data-target="#demo" data-slide-to="1"></li>
						<li data-target="#demo" data-slide-to="2"></li>
						<li data-target="#demo" data-slide-to="3"></li>
						<li data-target="#demo" data-slide-to="4"></li>
					</ul>
					<!-- 轮播图片 -->
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img alt="" src="images/index_ad/ad1.jpg">
						</div>
						<div class="carousel-item">
							<img alt="" src="images/index_ad/ad2.png">
						</div>
						<div class="carousel-item">
							<img alt="" src="images/index_ad/ad3.gif">
						</div>
						<div class="carousel-item">
							<img alt="" src="images/index_ad/ad4.jpg">
						</div>
						<div class="carousel-item">
							<img alt="" src="images/index_ad/ad5.jpg">
						</div>
						<!-- 左右切换按钮 -->
						<a class="carousel-control-prev" href="#demo" data-slide="prev">
							<span class="carousel-control-prev-icon"></span>
						</a>
						<a class="carousel-control-next" href="#demo" data-slide="next">
							<span class="carousel-control-next-icon"></span>
						</a>
					</div>
				</div>
				<div>
					<div class="card mt-2">
						<div class="card">
							<div class="card-body">
							<a href="file/view.action">文件上传/下载</a>
							</div>
						</div>
						<div class="card">
							<div class="card-body">
							<a href="map.jsp">地图</a>
							</div>
						</div>
						<div class="card">
							<div class="card-body">
							<a href="map3.jsp">地址匹配服务</a>
							</div>
						</div>
					</div>
					<div id="draggable" class="ui-widget-content">
					  <p>JQuery UI</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="myModal">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<!-- 头部 -->
				<div class="modal-header">
					<h4 class="modal-title">弹窗头部</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- 主体 -->
				<div class="modal-body">弹窗内容...</div>
				<!-- 底部 -->
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="js/popper.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-4.1.1/js/bootstrap.min.js"></script>	
	<script type="text/javascript" src="js/jquery-ui-1.12.1/jquery-ui.min.js"></script>
	<script>
		$(document).ready(function(){
			$("[data-toggle='tooltip']").tooltip();
			$("[data-toggle='popover']").popover();
			
			$( "#draggable" ).draggable();
		});
	</script>
</body>
</html>
