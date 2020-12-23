<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">

<%@ include file="/templates/utils.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<title>锦鲤金服数据中心</title>
${info1}
</head>

<script type="text/javascript">
$(function(){
	// 选择要加载的数据类型
	var type = '${type}'
	if(type != null || type != ""){
		$('#' + type).tab('show')
	}
	else{
		$('#pills-fund-ranking-tab').tab('show')
	}
});

//自选基金 模态控制
$(function() {
	$("#pills-selfchosen-tab").click(function() {
			$.post("${pageContext.request.contextPath}/LoginStatusCheckServlet",
					{
						postName : "fundSelfChosenSimplied"
					}, function(data){
						if(data == "logoutStatus")
							alert("登陆后才能查看自选基金！");
						else{
							$.post("${pageContext.request.contextPath}/customer/LoadSelfChosenFundServlet")
						}
					});
		});
});

</script>

<body>
	<!-- 导航栏 -->
	<%@ include file="/templates/navigationBar.jsp" %>

	<div class="container">
		
		<ul class="nav nav-pills nav-fill" id="pills-tab" role="tablist" style="margin-top:20px;">
		  <li class="nav-item">
		    <a class="nav-link" id="pills-fund-ranking-tab" data-toggle="pill" href="#pills-fund-ranking" role="tab" aria-controls="pills-home" aria-selected="true">基金排行</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="pills-fund-nav-tab" data-toggle="pill" href="#pills-fund-nav" role="tab" aria-controls="pills-profile" aria-selected="false">基金净值</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="pills-selfchosen-tab" data-toggle="pill" href="#pills-selfchosen" role="tab" aria-controls="pills-contact" aria-selected="false">基金自选</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="pills-fund-company-tab" data-toggle="pill" href="#pills-fund-company" role="tab" aria-controls="pills-contact" aria-selected="false">基金公司</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="pills-fund-manager-tab" data-toggle="pill" href="#pills-fund-manager" role="tab" aria-controls="pills-contact" aria-selected="false">基金经理</a>
		  </li>
		</ul>
		
		<hr style="border: none; background: red; height: 3px;">
		
		<div class="tab-content" id="pills-tabContent">
		  
		  <!-- 基金排行 -->
		  <div class="tab-pane fade" id="pills-fund-ranking" role="tabpanel" aria-labelledby="pills-home-tab">
		  	<table class="table table-striped" style="text-align:center;">
			  <thead>
			    <tr>
			      <th scope="col">基金代码</th>
			      <th scope="col">基金名称</th>
			      <th scope="col">季收益</th>
			      <th scope="col">年收益</th>
			      <th scope="col">基金类型</th>
			      <th scope="col">投资类型</th>
			      <th scope="col">操作</th>
			    </tr>
			  </thead>
			  <tbody>
			    <c:forEach items="${funds }" var="item">
				<tr>
					<td><a target="_blank" href="${pageContext.request.contextPath}/FundDetailActionServlet?fundCode=${item.fundCode}">${item.fundCode }</a></td>
					<td><a target="_blank" href="${pageContext.request.contextPath}/FundDetailActionServlet?fundCode=${item.fundCode}">${item.fundName }</a></td>
					<td style="color:red;">${item.fundSeasonYields }%</td>
					<td style="color:red;">${item.fundYearYields }%</td>
					<td>${item.fundType == 1?"开放式": "封闭式" }</td>
					<td>${item.fundInvestTypeToString }</td>
					<td width="90">
						<c:if test="${item.fundBuyStatus == 1 && cusPhone != null}">
							<a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/customer/AddToSelfChosenForDataCenterServlet?fundCode=${item.fundCode}&type=pills-fund-ranking" role="button" data-toggle="popover" data-trigger="focus" data-content="And here's some amazing content. It's very engaging. Right?">加自选</a>
						</c:if>
						<c:if test="${item.fundBuyStatus == 0 || cusPhone == null}">
							<a class="btn btn-secondary btn-sm disabled" href="#" role="button" aria-disabled="true">加自选</a>
						</c:if>
					</td>
				</tr>
				</c:forEach>
			  </tbody>
			</table>
		  </div>
		  
		  <!-- 基金净值 -->
		  <div class="tab-pane fade" id="pills-fund-nav" role="tabpanel" aria-labelledby="pills-profile-tab">
		  	<table class="table table-striped" style="text-align:center;">
			  <thead>
			    <tr>
			      <th scope="col">基金代码</th>
			      <th scope="col">基金名称</th>
			      <th scope="col">单位净值</th>
			      <th scope="col">年收益</th>
			      <th scope="col">申购状态</th>
			      <th scope="col">赎回状态</th>
			      <th scope="col">操作</th>
			    </tr>
			  </thead>
			  <tbody>
			    <c:forEach items="${funds }" var="item">
				<tr>
					<td><a target="_blank" href="${pageContext.request.contextPath}/FundDetailActionServlet?fundCode=${item.fundCode}">${item.fundCode }</a></td>
					<td><a target="_blank" href="${pageContext.request.contextPath}/FundDetailActionServlet?fundCode=${item.fundCode}">${item.fundName }</a></td>
					<td style="color:red;">${item.fundNAV }</td>
					<td style="color:red;">${item.fundYearYields }%</td>
					<td>${item.fundBuyStatus == 1?"开放": "暂停" }</td>
					<td>${item.fundSoldStatus == 1?"开放": "暂停" }</td>
					<td>
						<c:if test="${item.fundBuyStatus == 1 && cusPhone != null}">
							<a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/customer/AddToSelfChosenForDataCenterServlet?fundCode=${item.fundCode}&type=pills-fund-nav" role="button" id="add-to-self" data-toggle="modal"
			data-target="#addToSelfChosenModal">加自选</a>
						</c:if>
						<c:if test="${item.fundBuyStatus == 0 || cusPhone == null}">
							<a class="btn btn-secondary btn-sm disabled" href="#" role="button" aria-disabled="true">加自选</a>
						</c:if>
					</td>
				</tr>
				</c:forEach>
			  </tbody>
			</table>
		  </div>
		  
		  <!-- 基金自选 -->
		  <div class="tab-pane fade" id="pills-selfchosen" role="tabpanel" aria-labelledby="pills-contact-tab">
		  	<c:if test="${cusPhone != null }">
				<table class="table table-striped" style="text-align:center;">
				  <thead>
				    <tr>
				      <th scope="col" style="font-size:13px;">基金代码</th>
				      <th scope="col" style="font-size:13px;">基金名称</th>
				      <th scope="col" style="font-size:13px;">单位净值</th>
				      <th scope="col" style="font-size:13px;">年收益</th>
				      <th scope="col" style="font-size:13px;">基金类型</th>
				      <th scope="col" style="font-size:13px;">投资类型</th>
				      <th scope="col" style="font-size:13px;">申购状态</th>
				      <th scope="col" style="font-size:13px;">数量</th>
				      <th scope="col" style="font-size:13px;">操作</th>
				    </tr>
				  </thead>
				  <tbody>
				    <c:forEach items="${selfChosens }" var="item">
					<tr>
						<td style="font-size:13px;"><a target="_blank" href="${pageContext.request.contextPath}/FundDetailActionServlet?fundCode=${item.fundCode}">${item.fundCode }</a></td>
						<td style="font-size:13px;"><a target="_blank" href="${pageContext.request.contextPath}/FundDetailActionServlet?fundCode=${item.fundCode}">${item.fundName }</a></td>
						<td style="font-size:13px; color:red;">${item.fundNAV }</td>
						<td style="font-size:13px; color:red;">${item.fundYearYields }%</td>
						<td style="font-size:13px;">${item.fundType == 1? "开放式": "封闭式"}</td>
						<td style="font-size:13px;">${item.fundInvestTypeToString}</td>
						<td style="font-size:13px;">${item.fundBuyStatus == 1? "开放": "暂停" }</td>
						<td>
							<input type="number" class="form-control" style="width: 100px;" value="100">
						</td>
						<td>
							<c:if test="${item.fundBuyStatus == 1 }">
								<a class="btn btn-primary btn-sm" href="#" role="button">购买</a>
							</c:if>
							<c:if test="${item.fundBuyStatus == 0 }">
								<a class="btn btn-secondary btn-sm disabled" href="#" role="button" aria-disabled="true">购买</a>
							</c:if>
						</td>
					</tr>
					</c:forEach>
				  </tbody>
				</table>		
			</c:if>
		  </div>
		  
		  <!-- 基金公司 -->
		  <div class="tab-pane fade" id="pills-fund-company" role="tabpanel" aria-labelledby="pills-contact-tab">
		  	<table class="table table-striped" style="text-align:center;">
			  <thead>
			    <tr>
			      <th scope="col">基金公司名称</th>
			      <th scope="col">资产管理规模(亿元)</th>
			      <th scope="col">旗下基金数</th>
			      <th scope="col">成立时间</th>
			      <th scope="col">总经理</th>
			    </tr>
			  </thead>
			  <tbody>
			    <c:forEach items="${fundComs }" var="item">
				<tr>
					<td>${item.comName }</td>
					<td style="color:red;">${item.assetManagementScale }</td>
					<td>${item.fundNum }</td>
					<td>${item.setupTime }</td>
					<td>${item.generalManager }</td>
				</tr>
				</c:forEach>
			  </tbody>
			</table>
		  </div>
		  
		  <!-- 基金经理列表 -->
		  <div class="tab-pane fade" id="pills-fund-manager" role="tabpanel" aria-labelledby="pills-contact-tab">
		  	<table class="table table-striped" style="text-align:center;">
			  <thead>
			    <tr>
			      <th scope="col">姓名</th>
			      <th scope="col">任职基金公司</th>
			      <th scope="col">上任日期</th>
			      <th scope="col">现任基金</th>
			      <th scope="col">平均年化收益</th>
			      <th scope="col">性别</th>
			      <th scope="col">学历</th>
			    </tr>
			  </thead>
			  <tbody>
			    <c:forEach items="${fundManagers }" var="item">
					<tr>
						<td>${item.manName }</td>
						<td>${item.manWorkFor }</td>
						<td>${item.manOnTime }</td>
						<td>${item.manPresentFund }</td>
						<td style="color:red;">${item.manAAR }%</td>
						<td>${item.manGender }</td>
						<td>${item.manEB }</td>
					</tr>
				</c:forEach>
			  </tbody>
			</table>
		  </div>
		</div>
	</div>
	
	<!-- 脚部部分 -->
	<%@ include file="/templates/footer.jsp" %>
</body>
</html>    