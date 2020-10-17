<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="bootstrap4/css/bootstrap.css" rel="stylesheet">
<!-- 设置网页标签的logo -->
<link rel="icon" href="images/web_logo.png" type="image/x-icon" />
<link href="bootstraps4/css/floating-labels.css" rel="stylesheet">
<link rel="stylesheet" href="bootstrap4/css/bootstrap.min.css">
<link href="bootstrap4/css/signin.css" rel="stylesheet">

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

<title>找回密码</title>
</head>
<body>
	<form class="form-signin">
		<div class="text-center mb-4">
			<img class="mb-4" src="images/web_logo.png" alt="" width="72"
				height="72">
			<h1 class="h3 mb-3 font-weight-normal">找回密码</h1>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-sm-9">
					<div class="form-label-group" style="margin-bottom: 10px; margin-left:-15px;">
						<input type="email" id="inputEmail" class="form-control"
							placeholder="请输入邮箱地址" required autofocus>
					</div>
				</div>
				<div class="col-sm-3">
					<a class="row btn btn-outline-success btn-sm" style="text-decoration:none; color:black;"><B>获取<br>验证码</B></a>
				</div>
			</div>
		</div>

		<div class="form-label-group" style="margin-bottom: 30px;">
			<input type="text" id="inputCheckCode" class="form-control"
				placeholder="请输入验证码" required>
		</div>
  
		<button class="btn btn-lg btn-primary btn-block" type="submit">确认</button>
		<p class="mt-5 mb-3 text-muted text-center">&copy;
			2020.10-2020.12&nbsp; 锦鲤金服有限公司</p>
	</form>

	<script src="bootstrap4/jquery-3.0.0.min.js"></script>
	<script src="bootstrap4/popper.min.js"></script>
	<script src="bootstrap4/js/bootstrap.min.js"></script>
</body>
</html>