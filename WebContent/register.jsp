<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- 设置网页标签的logo -->
<link rel="icon" href="images/web_logo.png" type="image/x-icon" />
<link rel="stylesheet" href="bootstrap4/css/bootstrap.min.css">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<link href="bootstrap4/css/signin.css" rel="stylesheet">
<title>注册</title>
</head>
<body class="text-center">
	<form class="form-signin">
		<img class="mb-4" src="images/web_logo.png" alt="" width="72"
			height="72">
		<h1 class="h3 mb-3 font-weight-normal">欢迎注册</h1>
		
		<label for="inputEmail" class="sr-only">账号</label>
		<input type="text" id="inputEmail" class="form-control" placeholder="请输入账号" required autofocus>
		<label for="inputPassword" class="sr-only">密码</label>
		<input type="password" id="inputPassword" class="form-control" placeholder="请输入密码" required>
		<label for="inputPasswordConfirm" class="sr-only">确认密码</label> 
		<input type="password" id="inputPasswordConfirm" class="form-control" placeholder="请再次输入密码" required style="margin-top:-10px;">
		
		<button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
		<p class="mt-5 mb-3 text-muted">&copy;2020.10-2020.12 &nbsp;
			锦鲤金服有限公司</p>
	</form>

	<script src="bootstrap4/jquery-3.0.0.min.js"></script>
	<script src="bootstrap4/popper.min.js"></script>
	<script src="bootstrap4/js/bootstrap.min.js"></script>
</body>
</html>