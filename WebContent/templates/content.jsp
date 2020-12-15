<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<style type="text/css">
.serviceList {
	color: gray;
	font-size: 15px;
}

.serviceList:hover {
	color: red;
	text-decoration: none;
	font-size: 15px;
}
</style>

<div class="container" style="margin-top: 20px;">
	<!-- 第一部分 -->
	<div class="row align-items-center text-center">
		<div class="col-5">
			<div class="row">
				<div class="col">
					<img src="${pageContext.request.contextPath}/images/fundIncome.png"
						width="40" height="40">
				</div>
				<div class="col">
					<img src="${pageContext.request.contextPath}/images/fundNAV.png"
						width="40" height="40">
				</div>
				<div class="col">
					<img src="${pageContext.request.contextPath}/images/selfSelect.png"
						width="40" height="40">
				</div>
				<div class="w-100"></div>
				<div class="col">
					<a href="" class="serviceList">收益排行</a>
				</div>
				<div class="col">
					<a href="" class="serviceList">基金净值</a>
				</div>
				<div class="col">
					<a href="" class="serviceList">我的自选</a>
				</div>
			</div>

		</div>
		<div class="col-2">
			<a href="${pageContext.request.contextPath}/homePage.jsp"> <img
				src="${pageContext.request.contextPath}/images/web_logo.png"
				width="60" height="60">
			</a>
			<h5>
				<a style="color: gray; text-decoration: none;"
					href="${pageContext.request.contextPath}/homePage.jsp">锦鲤金服</a>
			</h5>
		</div>
		<div class="col-5">
			<div class="row">
				<div class="col">
					<img
						src="${pageContext.request.contextPath}/images/fundOpenAccount.png"
						width="40" height="40">
				</div>
				<div class="col">
					<img src="${pageContext.request.contextPath}/images/fundTrade.png"
						width="40" height="40">
				</div>
				<div class="col">
					<img
						src="${pageContext.request.contextPath}/images/personCenter.png"
						width="40" height="40">
				</div>
				<div class="w-100"></div>
				<div class="col">
					<a href="" class="serviceList">基金开户</a>
				</div>
				<div class="col">
					<a href="" class="serviceList">基金交易</a>
				</div>
				<div class="col">
					<a href="" class="serviceList">个人中心</a>
				</div>
			</div>
		</div>
	</div>
</div>

<hr style="border: none; background: red; height: 3px;">

<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Username</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row">1</th>
				<td>Mark</td>
				<td>Otto</td>
				<td>@mdo</td>
			</tr>
			<tr>
				<th scope="row">2</th>
				<td>Jacob</td>
				<td>Thornton</td>
				<td>@fat</td>
			</tr>
			<tr>
				<th scope="row">3</th>
				<td>Larry</td>
				<td>the Bird</td>
				<td>@twitter</td>
			</tr>
		</tbody>
	</table>
</div>