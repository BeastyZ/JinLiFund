<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<%@ include file="templates/utils.jsp"%>
<link href="bootstrap4/css/bootstrap.css" rel="stylesheet">
<link href="bootstraps4/css/floating-labels.css" rel="stylesheet">
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

<title>重置密码</title>
</head>
<body>
	<form class="form-signin" method="post" action="EmailGetPassword465Port.html">
		<div class="text-center mb-4">
			<img class="mb-4" src="images/web_logo.png" alt="" width="72"
				height="72">
			<h1 class="h3 mb-3 font-weight-normal">重置密码</h1>
		</div>

		<div class="form-label-group" style="margin-bottom: 20px;">
			<input type="email" id="inputEmail" class="form-control"
				name="emailAddress" placeholder="请输入QQ邮箱地址" required autofocus>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit"
			data-toggle="modal" data-target="#exampleModal">重置密码</button>
		<p class="mt-5 mb-3 text-muted text-center">&copy;
			2020.10-2020.12&nbsp; 锦鲤金服有限公司</p>

		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">重置密码</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">验证码已成功发至您的邮箱，请注意查收！</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">确认</button>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>