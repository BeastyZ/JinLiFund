<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>交易账户登录</title>

<%@ include file="templates/utils.jsp"%>
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
</head>
<body class="text-center">
	<form class="form-signin">
		<img class="mb-4" src="images/web_logo.png" alt="" width="72"
			height="72">
		<h1 class="h3 mb-3 font-weight-normal">交易账户登录</h1>
		<label for="inputEmail" class="sr-only">身份证号码</label> <input type="email"
			id="inputEmail" class="form-control" placeholder="请输入身份证号码" required
			autofocus> <label for="inputPassword" class="sr-only">交易密码</label>
		<input type="password" id="inputPassword" class="form-control"
			placeholder="请输入交易密码" required>
		<div class="row">
			<div class="col-sm-9">
				<label for="inputCheckCode" class="sr-only">校验码</label> <input
					type="text" id="inputCheckCode" class="form-control"
					style="margin-top: -11px;" placeholder="请输入校验码" required>
			</div>
			<div class="col-sm-3; align-center" style="margin-left:-5px;">
				<img src="LoginCheckCode.html">
			</div>
		</div>

		<div class="checkbox mb-3" style="margin-top:10px;">
			<label> <input type="checkbox" value="remember-me">
				记住密码
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit" style="margin-top:-10px;">登录</button>
		<p class="mt-5 mb-3 text-muted">&copy;2020.10-2020.12 &nbsp;
			锦鲤金服有限公司</p>
	</form>
</body>
</html>