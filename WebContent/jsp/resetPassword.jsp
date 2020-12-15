<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<%@ include file="/templates/utils.jsp"%>

<link
	href="${pageContext.request.contextPath}/bootstrap4/css/bootstrap.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/bootstraps4/css/floating-labels.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/bootstrap4/css/signin.css"
	rel="stylesheet">

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

<script type="text/javascript">
	//响应"重置密码"弹窗
	$(function() {
		$("#resetPasswordButton")
				.click(
						function() {
							let telephone = $("input[name='telephone']").val();
							let emailAddress = $("input[name='emailAddress']")
									.val();

							if (telephone == "" || emailAddress == "") {
								$("#resetPasswordTip").html("提示");
								$("#model-body-content").html("内容不能为空！");
							} else {
								$
										.post(
												"${pageContext.request.contextPath}/customer/SendCheckCodeServlet",
												{
													telephone : telephone,
													emailAddress : emailAddress
												},
												function(data) {
													if (data == "invalid") {
														$("#resetPasswordTip")
																.html("提示");
														$("#model-body-content")
																.html(
																		"此账号没有注册！");
													} else {
														$("#resetPasswordTip")
																.html("重置密码");
														$("#model-body-content")
																.html(
																		"验证码已成功发至您的邮箱，请注意查收！");
														$(
																'#writeCheckCodeModal')
																.modal('show');
													}
												});
							}
						});
	});

	// 用户输入校验码后进行确认
	$(function() {
		$("#ConfirmCheckCodeNewPassword")
				.click(
						function() {
							let newPassword = $("input[name='newPassword']").val();
							let newPasswordConfirm = $("input[name='newPasswordConfirm']").val();
							let CheckCodeByCus = $("input[name='CheckCodeByCus']").val();

							if (CheckCodeByCus == "" || newPasswordConfirm == "" || newPassword == "") {
								alert("内容不能为空！");
							} 
							else if(newPassword != newPasswordConfirm){
								alert("两次密码不一致！");
							}
							else {
								$.post(
												"${pageContext.request.contextPath}/customer/ConfirmCheckCodeNewPasswordServlet",
												{
													newPassword : newPassword,
													CheckCodeByCus : CheckCodeByCus
												},
												function(data) {
													if (data == "allValid") {
														alert("密码修改成功！");
														$('#writeCheckCodeModal')
														.modal('hide');
													} else {
														alert("密码修改失败，请重新尝试。");
														$('#writeCheckCodeModal')
														.modal('hide');
													}
												});
							}
						});
	});
</script>

<title>重置密码</title>
</head>
<body>
	<form class="form-signin">
		<div class="text-center mb-4">
			<img class="mb-4"
				src="${pageContext.request.contextPath}/images/web_logo.png" alt=""
				width="72" height="72">
			<h1 class="h3 mb-3 font-weight-normal">重置密码</h1>
		</div>

		<div class="form-label-group" style="margin-bottom: 20px;">
			<input type="text" id="inputEmail" class="form-control"
				name="telephone" placeholder="请输入11位手机号" pattern="[0-9]{11}"
				required autofocus>
		</div>

		<div class="form-label-group" style="margin-bottom: 20px;">
			<input type="email" id="inputEmail" class="form-control"
				name="emailAddress" placeholder="请输入QQ邮箱地址" required>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="button"
			id="resetPasswordButton" data-toggle="modal"
			data-target="#resetPassowrdButtonModal">重置密码</button>
		<p class="mt-5 mb-3 text-muted text-center">&copy;
			2020.10-2020.12&nbsp; 锦鲤金服有限公司</p>
	</form>

	<!-- 提示框模态 -->
	<div class="modal fade" id="resetPassowrdButtonModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="resetPasswordTip">重置密码</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p id="model-body-content">验证码已成功发至您的邮箱，请注意查收！</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">确认</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 输入邮箱发送的校验码的模态 -->
	<div class="modal fade bd-example-modal-sm " id="writeCheckCodeModal"
		tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-sm modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalCenterTitle">校验码确认</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<input
								style="border-bottom: 1px solid #000; border-top: none; border-left: none; border-right: none;"
								type="password" class="form-control" name="newPassword"
								id="newPassword" placeholder="请输入新密码" required>
						</div>
						<div class="form-group">
							<input
								style="border-bottom: 1px solid #000; border-top: none; border-left: none; border-right: none;"
								type="password" class="form-control" name="newPasswordConfirm"
								id="newPasswordConfirm" placeholder="请确认新密码" required>
						</div>
						<div class="form-group">
							<input
								style="border-bottom: 1px solid #000; border-top: none; border-left: none; border-right: none;"
								type="text" class="form-control" name="CheckCodeByCus"
								id="CheckCodeByCus" placeholder="请输入6位字母校验码" required>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary"
						id="ConfirmCheckCodeNewPassword">确认</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>