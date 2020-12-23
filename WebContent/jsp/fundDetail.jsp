<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html style="height: 100%">
<head>
<meta charset="utf-8">

<%@ include file="/templates/utils.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<title>基金详情</title>
<script type="text/javascript">
// 添加到自选 模态控制
$(function() {
	$("#addToSelfChosen").click(function() {
		var fundCode = document.getElementById("fundCode").innerHTML;
		
			$.post("${pageContext.request.contextPath}/customer/AddToSelfChosenServlet",
					{
						fundCode : fundCode
					}, function(data){
						if(data == "success"){
							alert("添加成功！");
						}
						else{
							alert("添加失败，您已添加该基金到您的自选模块当中！或者登录账号后重新尝试一次！");
						}
					});
		});
});

// 购买基金份额 模态控制
$(function() {
	$("#buyFund").click(function() {
		var fundCode = document.getElementById("fundCode").innerHTML;
		var fundShare = document.getElementById("fundShare").value;
		var fundName = document.getElementById("fundName").innerHTML;
		
			$.post("${pageContext.request.contextPath}/customer/BuyFundServlet",
					{
						fundCode : fundCode,
						fundShare : fundShare,
						fundName : fundName
					}, function(data){
						if(data == "success"){
							alert("购买成功！您可以在我的基金中查看已购买的基金，感谢您对锦鲤金服的信赖！");
						}
						else{
							alert("购买失败，请重新尝试！");
						}
					});
		});
});

// 基金份额增加 模态控制
$(function() {
	$("#up").click(function() {
		var fundShare = document.getElementById("fundShare");
		var value = document.getElementById("fundShare").value;
		
		value = parseInt(value) + 100;
		fundShare.value = value;
		});
});

//基金份额减少 模态控制
$(function() {
	$("#down").click(function() {
		var fundShare = document.getElementById("fundShare");
		var value = document.getElementById("fundShare").value;
		value = parseInt(value);
		if(value == 0){
			value = 0;
		}
		else{
			value -= 100;
		}
		fundShare.value = value;
		});
});

</script>
</head>
<body style="height: 100%; margin: 0">
	<!-- 导航栏 -->
	<%@ include file="/templates/navigationBar.jsp" %>

	<div class="container">
		<div class="row align-items-center" style="margin-top:10px; margin-left:3px;">
			<h3><span class="badge badge-secondary" id="fundName">${fund.fundName }</span></h3>
			<span style="margin-left:12px;" id="fundCode">${fund.fundCode }</span>
			<span class="badge badge-pill badge-dark" style="margin-left:12px;">${fund.fundType == 1?"开放式": "封闭式" }</span>
			<c:if test="${fund.fundInvestType == 1 }">
				<span class="badge badge-pill badge-info" style="margin-left:12px;">股票型</span>
			</c:if>
			<c:if test="${fund.fundInvestType == 2 }">
				<span class="badge badge-pill badge-info" style="margin-left:12px;">债券型</span>
			</c:if>
			<c:if test="${fund.fundInvestType == 3 }">
				<span class="badge badge-pill badge-info" style="margin-left:12px;">指数型</span>
			</c:if>
			<c:if test="${fund.fundInvestType == 4 }">
				<span class="badge badge-pill badge-info" style="margin-left:12px;">混合型</span>
			</c:if>
			
		</div>
		
		<hr>
	
		<div class="card mb-3">
		  <div class="row no-gutters">
		    <div class="col-md-4">
		    <div class="jumbotron jumbotron" style="margin-top: 20px; margin-left:10px; width: 300px; height: 350px;">
			  <div class="container">
			    <h5>暂无历史价格记录</h5>
			  </div>
			</div>
		    </div>
		    <div class="col-md-8">
		      <div class="card-body">
		      	<div class="row">
		      		<div class="col">
		      			<font size="6" color="red"><b>${fund.fundNAV }</b></font>
		      			<p>单位净值</p>
		      		</div>
		      		<div class="col" style="margin-top:10px;">
		      			<font size="3">季收益率</font>
		      			<p style="color:red; font-size:20px">${fund.fundSeasonYields }%</p>
		      		</div>
		      		<div class="col" style="margin-top:10px;">
		      			<font size="3">年收益率</font>
		      			<p style="color:red; font-size:20px">${fund.fundYearYields }%</p>
		      		</div>
		      	</div>
		      	
		      	<hr style="border: none;">
		      	
		      	<div class="row">
		      		<div class="col-4">
		      			基金规模：<span style="color:red;">${fund.fundScale }</span>亿元
		      		</div>
		      		<div class="col-4">
		      			成立时间：${fund.fundEstablishedTime }
		      		</div>
		      	</div>	
		      	
	      		<div class="row" style="margin-top:20px;">
		      		<div class="col-4">
		      			基金经理：${fund.fundManager }
		      		</div>
		      		<div class="col-4">
		      			基金评级：暂无评级
		      		</div>
		      	</div>
		      	
		      	<div class="row" style="margin-top:20px;">
		      		<div class="col">管理人：${fund.fundOwner }</div>
		      	</div>	
		      	
		      	<hr>
		      	
			 	 <div class="row" style="margin-top:20px;">
			 		<div class="col-4">
			 			申购状态：<span style="color:red;">${fund.fundBuyStatus == 1?"开放": "暂停" }</span>
			 		</div>
			 		<div class="col-4">
			 			赎回状态：<span style="color:red;">${fund.fundSoldStatus == 1?"开放": "暂停"}</span>
			 		</div>
			 	</div> 
			 	
			 	<div class="row" style="margin-top:20px;">
			 		<div class="col-3" style="margin-top:7px;">
			 			份额数量：
			 		</div>
			 		<div class="col-5" style="margin-left:-70px;">
			 			<!-- 基金份额加减 -->
			 			<div class="input-group">
						  <input type="text" class="form-control" aria-label="Recipient's username" aria-describedby="basic-addon2" value="100" id="fundShare">
						  <div class="input-group-append">
						    <button class="btn btn-outline-secondary" type="button" id="down">-</button>
						    <button class="btn btn-outline-secondary" type="button" id="up">+</button>
						  </div>
						</div>
			 		</div>
			 		<div class="col=2" style="margin-left:-10px; margin-top:3px;">
				 		<a role="button" class="btn btn-danger btn-sm" href="#" id="buyFund">购买</a>
			 		</div>
			 		<div class="col-2" style="margin-top:3px;">
			 			<a role="button" class="btn btn-outline-danger btn-sm" href="#" id="addToSelfChosen">加自选</a>
			 		</div>
			 		<div class="col-3" style="margin-left:-30px;">
			 			<a class="btn btn-primary" href="${pageContext.request.contextPath}/jsp/openAccount.jsp" role="button" target="_blank">8秒开户</a>
			 		</div>
			 	</div>   
			 	
			 	<div class="row">
			 		<div class="col">费率：<span style="color:red;">0.00%</span></div>
			 	</div>   
		      </div>  
		    </div>		    
		  </div>
		</div>
		
	</div>

	<!-- 脚部部分 -->
	<%@ include file="/templates/footer.jsp" %>
</body>
</html>