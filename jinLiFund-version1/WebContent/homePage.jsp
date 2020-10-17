<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">

<!-- 设置网页标签的logo -->
<link rel="icon" href="images/web_logo.png" type="image/x-icon" />
<link rel="stylesheet" href="bootstrap4/css/bootstrap.min.css">

<script type="text/javascript">
	function loginOrLogout() {
		if (document.getElementById("login").style.display == "none") {
			document.getElementById("login").style.display = "block";
			document.getElementById("logout").style.display = "none";
		} else {
			document.getElementById("login").style.display = "none";
			document.getElementById("logout").style.display = "block";
		}
	}
</script>

<title>锦鲤金服首页</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="homePage.jsp">锦鲤金服首页</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Dropdown </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">Action</a> <a
							class="dropdown-item" href="#">Another action</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Something else here</a>
					</div></li>
			</ul>

			<div id="logout" style="display: block; color: white">
				<span class="l-username">欢迎您，INNO三生三世</span>&nbsp;|&nbsp; 
				<span class="l-quit" onclick="loginOrLogout()"><a href="#" style="color:white">退出</a></span>&nbsp;|&nbsp; 
				<span class="l-delete"><a href="#" style="color:white">注销账号</a></span>
			</div>

		</div>
		<div id="login" style="display: none;">
			<a href="register.jsp" target="_blank"
				style="color: white; margin-right: 20px">注册</a>
			<div class="btn btn-outline-success">
				<a href="login.jsp" target="_blank" style="color: white">登录</a>
			</div>
			<a target="_blank" href="findPassword.jsp" style="color: white; margin-left: 20px">忘记密码?</a>
		</div>

	</nav>

	<script src="bootstrap4/jquery-3.0.0.min.js"></script>
	<script src="bootstrap4/popper.min.js"></script>
	<script src="bootstrap4/js/bootstrap.min.js"></script>
</body>
</html>