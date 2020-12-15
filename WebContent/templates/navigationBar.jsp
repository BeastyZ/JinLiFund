<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<script type="text/javascript">
	// 登录 注册 退出 按钮组的控制
// 	function loginOrLogout() {
// 		if (document.getElementById("loginStatus").style.display == "none") {
// 			document.getElementById("loginStatus").style.display = "block";
// 			document.getElementById("logoutStatus").style.display = "none";
// 		} else {
// 			document.getElementById("loginStatus").style.display = "none";
// 			document.getElementById("logoutStatus").style.display = "block";
// 		}
// 	}
	
	// 登录 注册 退出 按钮组的控制
	$(function() {
		$("#logout")
				.click(
						function() {
								$.post("${pageContext.request.contextPath}/customer/LogoutActionServlet", null, 
										function(){
									alert("退出登录成功！");
								});
								$("#logoutStatus").attr("style", "display:block;");
								$("#loginStatus").attr("style", "display:none;");
						});
	});

	// 响应注册弹窗
	$(function() {
		$("#register")
				.click(
						function() {
							let telephone = $("input[name='regTelephone']")
									.val();
							let password = $("input[name='regPassword']").val();
							let passwordConfirm = $(
									"input[name='regPasswordConfirm']").val();

							if (telephone == "" || password == ""
									|| passwordConfirm == "") {
								alert("内容不能为空！");
							} else {
								if (password == passwordConfirm) {
									$
											.post(
													"${pageContext.request.contextPath}/customer/RegisterActionServlet",
													{
														telephone : telephone,
														password : password
													},
													function(data) {
														$("#logoutStatus")
																.attr("style",
																		"display:none;");
														$("#loginStatus")
																.attr("style",
																		"display:block;");
														$("#loginStatus").attr(
																"style",
																"color:white;");

														if (data != null)
															alert(data);
													});
								} else {
									alert("两次输入的密码不一致！");
								}
							}
						});
	});

	// 响应登录弹窗
	$(function() {
		$("#login")
				.click(
						function() {
							let telephone = $("input[name='loginTelephone']")
									.val();
							let password = $("input[name='loginPassword']")
									.val();
							let checkCode = $("input[name='loginCheckCode']")
									.val();
							let choice = $("input[name='identityChoice']")
									.val();

							if (telephone == "" || password == ""
									|| checkCode == "") {
								alert("内容不能为空！");
							} else {
								$.post(
												"${pageContext.request.contextPath}/LoginActionServlet",
												{
													telephone : telephone,
													password : password,
													checkCode : checkCode,
													choice : choice
												},
												function(data) {
													if (data == "accountPasswordWrong") {
														alert("账号或密码错误！");
													} else if (data == "checkCodeWrong") {
														alert("校验码错误！");
													} else if(data == "cusStatusOpen"){
														$("#logoutStatus")
																.attr("style",
																		"display:none;");
														$("#loginStatus")
																.attr("style",
																		"display:block;");
														$("#loginStatus").attr(
																"style",
																"color:white;");
														$("#cusPhone").html(telephone + "(已开户)");
													}else if(data == "cusNotExist"){
														alert("此用户不存在，请注册！");
													}
													else{
														$("#logoutStatus")
														.attr("style",
																"display:none;");
														$("#loginStatus")
																.attr("style",
																		"display:block;");
														$("#loginStatus").attr(
																"style",
																"color:white;");
														$("#cusPhone").html(telephone);
															}
												});
							}
						});
	});

	// 更新校验码
	function updateCheckCode() {
		document.getElementById("loginCheckCodeImg").src = "${pageContext.request.contextPath}/CheckCodeServlet?"
				+ Math.random();
	}
	
	// 页面刷新就执行
	$(document).ready(function(){
		var cusPhone = '<%=session.getAttribute("cusPhone")%>';
		if(cusPhone != "null"){
			$("#logoutStatus")
			.attr("style",
							"display:none;");
			$("#loginStatus")
					.attr("style",
							"display:block;");
			$("#loginStatus").attr(
					"style",
					"color:white;");
		}
		}
      );
	
	// 注销账号
	$(function() {
		$("#deleteAccButton")
				.click(
						function() {
								$.post("${pageContext.request.contextPath}/customer/DeleteAccountServlet", null, 
										function(){
									alert("注销账户成功！");
								});
								$("#logoutStatus").attr("style", "display:block;");
								$("#loginStatus").attr("style", "display:none;");
						});
	});
</script>

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
			<li class="nav-item active"><a class="nav-link" href="#">自选基金</a></li>
			<li class="nav-item active"><a class="nav-link" href="#">基金市场</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle active" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">基金交易</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="#">我的基金</a> <a class="dropdown-item"
						href="#">我的定投</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item"
						href="${pageContext.request.contextPath}/jsp/openAccount.jsp"
						target="_blank">免费开户</a>
				</div></li>
		</ul>

		<div id="logoutStatus" style="display: block;">
			<!-- 登录按钮触发模态 -->
			<button style="color: white; margin-right: 20px" type="button"
				class="btn btn-primary" data-toggle="modal"
				onclick="updateCheckCode()" data-target="#loginModalCenter">登录</button>

			<!-- 注册按钮触发模态 -->
			<button type="button" class="btn btn-light" data-toggle="modal"
				data-target="#registerModalCenter">注册</button>

			<a target="_blank" href="jsp/resetPassword.jsp"
				style="color: white; margin-left: 20px">忘记密码?</a>
		</div>

	</div>

	<!-- 登录 退出 区块的更换 -->
	<div id="loginStatus" style="display: none; color: white">
		<span id="cusPhone">${cusPhone }</span>&nbsp;|&nbsp; 
		<span><a href="#" style="color: white" id="logout">退出</a></span>&nbsp;|&nbsp; <span><a
			href="#" style="color: white" data-toggle="modal"
			data-target="#deleteAccButtonModal">注销账号</a></span>
	</div>

	<!-- 注册按钮模态 -->
	<div class="modal fade bd-example-modal-sm" id="registerModalCenter"
		tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-sm modal-dialog-centered"
			role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalCenterTitle">用户注册</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="regTelephone" class="col-form-label">手机号</label> <input
								type="text" class="form-control" id="regTelephone"
								name="regTelephone" placeholder="请输入11位手机号" pattern="[0-9]{11}"
								required>
						</div>
						<div class="form-group" style="margin-top: -15px;">
							<label for="regPassword" class="col-form-label">密码</label> <input
								type="password" class="form-control" id="regPassword"
								name="regPassword" placeholder="请输入密码" required>
						</div>
						<div class="form-group" style="margin-top: -15px;">
							<label for="regPasswordConfirm" class="col-form-label">确认密码</label>
							<input type="password" class="form-control"
								id="regPasswordConfirm" name="regPasswordConfirm"
								placeholder="请确认密码" required>
						</div>
						<hr>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary" data-dismiss="modal"
							style="margin-left: 145px;" id="register">注册</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- 登录按钮模态 -->
	<div class="modal fade bd-example-modal-sm" id="loginModalCenter"
		tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-sm modal-dialog-centered"
			role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalCenterTitle">欢迎登录</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="loginTelephone" class="col-form-label">手机号</label> <input
								type="text" class="form-control" id="loginTelephone"
								name="loginTelephone" placeholder="请输入11位手机号"
								pattern="[0-9]{11}" required>
						</div>
						<div class="form-group" style="margin-top: -15px;">
							<label for="loginPassword" class="col-form-label">密码</label> <input
								type="password" class="form-control" id="loginPassword"
								name="loginPassword" placeholder="请输入密码" required>
						</div>
						<div class="form-group" style="margin-top: -15px;">
							<label for="loginCheckCode" class="col-form-label">校验码</label>
							<div class="row" style="margin-left: 1px;">
								<input type="text" class="form-control" id="loginCheckCode"
									style="width: 10rem;" name="loginCheckCode"
									placeholder="请输入校验码" required> <img
									style="margin-left: 35px;" id="loginCheckCodeImg"
									src="${pageContext.request.contextPath}/CheckCodeServlet"
									onclick="updateCheckCode()">
							</div>
						</div>
						<div class="form-group" align="center">
							<div class="btn-group" data-toggle="buttons">
								<label class="btn btn-light active"> <input type="radio"
									name="identityChoice" id="customer" autocomplete="off"
									value="customer" checked> 用户
								</label> <label class="btn btn-light"> <input type="radio"
									name="identityChoice" id="administrator" autocomplete="off"
									value="administrator"> 管理员
								</label>
							</div>
						</div>
						<hr>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary" data-dismiss="modal"
							style="margin-left: 145px;" id="login">登录</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- 注销账号提示框模态 -->
	<div class="modal fade" id="deleteAccButtonModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="resetPasswordTip">注销提示</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p id="model-body-content" style="text-indent: 2em;">账号注销后将<b style="color:red;">删除所有记录</b>，如需交易，需重新注册账号，是否确认注销？</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal"
						id="deleteAccButton">确认注销</button>
				</div>
			</div>
		</div>
	</div>
</nav>
