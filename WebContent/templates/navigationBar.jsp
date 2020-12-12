<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<script type="text/javascript">
	// 登录 退出 按钮组的控制
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
					<a class="dropdown-item" href="openAccount.jsp" target="_blank">免费开户</a>
				</div></li>
		</ul>

		<div id="logout" style="display: block; color: white">
			<span class="l-username">欢迎您，INNO三生三世</span>&nbsp;|&nbsp; <span
				class="l-quit" onclick="loginOrLogout()"><a href="#"
				style="color: white">退出</a></span>&nbsp;|&nbsp; <span class="l-delete"><a
				href="#" style="color: white">注销账号</a></span>
		</div>

	</div>
	
	<div id="login" style="display: none;">
		<a href="register.jsp" target="_blank"
			style="color: white; margin-right: 20px">注册</a>
		<div class="btn btn-outline-success">
			<a href="login.jsp" target="_blank" style="color: white">登录</a>
		</div>
		<a target="_blank" href="findPassword.jsp"
			style="color: white; margin-left: 20px">忘记密码?</a>
	</div>

</nav>
