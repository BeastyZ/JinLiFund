<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>团队介绍</title>
<%@ include file="/templates/utils.jsp"%>
<link
	href="${pageContext.request.contextPath}/bootstrap4/css/bootstrap.css"
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
<link
	href="${pageContext.request.contextPath}/bootstrap4/css/product.css"
	rel="stylesheet">
</head>
<body>

	<!-- 第一部分 -->
	<div
		class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
		<div class="col-md-5 p-lg-5 mx-auto my-5">
			<h1 class="display-4 font-weight-normal">锦鲤金服团队</h1>
			<p class="lead font-weight-normal">我们是一支专业的团队，我们的成员都来自软件实力强劲的软件工程专业。</p>
			<p class="lead font-weight-normal">我们是一支年轻的团队，我们的平均年龄仅有20岁，充满了朝气和创新精神。</p>
			<p class="lead font-weight-normal">我们是一支专注的团队，我们坚信，品质源自顾客的信任。只有专注，才能做出有品质的好产品。</p>
		</div>
		<div class="product-device shadow-sm d-none d-md-block"></div>
		<div
			class="product-device product-device-2 shadow-sm d-none d-md-block"></div>
	</div>

	<!-- 第二部分 -->
	<div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3">
		<div
			class="bg-primary mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-white overflow-hidden">
			<div class="my-3 py-3">
				<h2 class="display-5">朱长泰</h2>
				<p class="lead">项目经理</p>
			</div>
			<div class="bg-light shadow-sm mx-auto"
				style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;" align="center">
				<img src="${pageContext.request.contextPath}/images/manager.png" width="200" height="200" style="margin-top: 30px;">
			</div>
		</div>
	</div>

	<!-- 第三部分 -->
	<div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3">
		<div
			class="bg-dark mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-white overflow-hidden">
			<div class="my-3 py-3">
				<h2 class="display-5">冯睿隽</h2>
				<p class="lead">配置部署</p>
			</div>
			<div class="bg-light shadow-sm mx-auto"
				style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;">
				<img src="${pageContext.request.contextPath}/images/workerOne.png" width="200" height="200" style="margin-top: 30px;">
				</div>
		</div>
		<div
			class="bg-light mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden">
			<div class="my-3 p-3">
				<h2 class="display-5">敖荟杰</h2>
				<p class="lead">开发测试</p>
			</div>
			<div class="bg-dark shadow-sm mx-auto"
				style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;">
				<img src="${pageContext.request.contextPath}/images/workerTwo.png" width="200" height="200" style="margin-top: 30px;">
				</div>
		</div>
	</div>

	<!-- 脚部部分 -->
	<%@ include file="/templates/footer.jsp"%>

	<script>
		window.jQuery
				|| document
						.write('<script src="${pageContext.request.contextPath}/boostrap4/js/jquery-3.5.1.js"><\/script>')
	</script>
	<script
		src="${pageContext.request.contextPath}/boostrap4/js/bootstrap.bundle.js"></script>
</body>
</html>