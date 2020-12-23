<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%@ include file="/templates/utils.jsp"%>
    <title>个人中心</title>

    <!-- Bootstrap core CSS -->
	<link href="${pageContext.request.contextPath}/bootstrap4/css/bootstrap.css" rel="stylesheet">
	<!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/bootstrap4/css/blog.css" rel="stylesheet">
    
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    
    <script type="text/javascript">
	// 控制内容的显示    
    $(function(){
	    	$("#person-info-visiblity").click(function(){
	    		var flag = document.getElementById("person-info-visiblity").innerHTML;
	    		window.location.href = "${pageContext.request.contextPath}/customer/personInfoVisibilityServlet?flag=" + flag;
	    	});
	    });
	
	// 修改信息的通知状态控制
	$(function(){
		var value = '${tipInfo}';
		if(value != ""){
			alert(value);
		}
	});
    </script>
    
  </head>
  <body> 
  	
    <div class="container">
	  <div class="jumbotron p-4 p-md-5 text-white rounded bg-dark">
	    <div class="col-md-7 px-0">
	      <h1 class="display-4 font-italic">锦鲤金服基金产品商城网站</h1>
	      <p class="lead my-3">专业&nbsp;&nbsp;年轻&nbsp;&nbsp;朝气&nbsp;&nbsp;创新&nbsp;&nbsp;专注&nbsp;&nbsp;优质&nbsp;&nbsp;<i style="font-weight:bold;">您的基金理财专家</i></p>
	      <p class="lead mb-0"><a href="${pageContext.request.contextPath}/homePage.jsp" target="_blank" class="text-white font-weight-bold">返回首页，快速理财吧！</a></p>
	    </div>
	  </div>
	
		<div class="row">
			<div class="col-7">
				<div class="card mb-3" style="max-width: 540px;">
				  <div class="row no-gutters">
				    <div class="col-md-4">
				      <img src="${pageContext.request.contextPath}/images/profiles/sysProfileCus.png" class="card-img">
				    </div>
				    <div class="col-md-8">
				      <div class="card-body">
				     	<strong class="d-inline-block mb-2 text-primary">隐私</strong>
				        <h5 class="card-title">个人信息</h5>
				        <div class="mb-1 text-muted" style="cursor: pointer;" id="person-info-visiblity">${flag }</div>
				        <p class="card-text row">
				        	<span class="col">姓名:&nbsp;${customer.cusName==null? "" :  customer.cusName}</span> 
				        	<span class="col">开户状态:&nbsp;<span style="color:red;">${customer.cusStatus==1?"已开户" : "未开户" }</span></span>	
				        </p>
			        	<p class="card-text">手机号:&nbsp;<span id="person-info-tel">${customer.cusPhone==null? "" :  customer.cusPhone}</span></p>
				        <p class="card-text">身份证:&nbsp;<span id="person-info-idNum">${customer.cusIDNum==null? "" :  customer.cusIDNum}</span></p>
				        <p class="card-text">银行卡:&nbsp;<span id="person-info-credit">${customer.cusCCNum==null? "" :  customer.cusCCNum}</span></p>
				        <p class="card-text"><a href="#" data-toggle="modal" data-target="#photoCCModifyModal">修改</a> </p>
				      </div>
				    </div>
				  </div>
				</div>
			</div>
			<div class="col-5">
				<div class="card mb-3" style="max-width: 540px;">
				  <div class="row no-gutters">
				    <div class="col-md-4">
				      <img src="${pageContext.request.contextPath}/images/web_logo.png" class="card-img">
				    </div>
				    <div class="col-md-8"> 
				      <div class="card-body">
				      	<strong class="d-inline-block mb-2 text-primary">理财</strong>
				        <h5 class="card-title">基金资产</h5>
				        <p class="card-text">已购基金数量:&nbsp;<span style="color:red;">${fundNum }</span>个</p>
				        <p class="card-text">已购基金总额:&nbsp;<span style="color:red;">${fundTotal }</span>元</p>
				        <p class="card-text">
				        	<a href="${pageContext.request.contextPath}/DataTypeChooseServlet?type=pills-selfchosen" target="_blank">购买</a>
				        	&nbsp;&nbsp;
				        	<a href="#">抛售</a> 
				        </p>
				        </div>
				      </div>
				    </div>
				  </div>
					<!-- 好基金提示 -->
					<div class="row" style="margin-top:30px; margin-right:7px;">
						<div class="col-3"><h1><span class="badge badge-secondary">TOP</span></h1> </div>
						<div class="col-3"><h1><span class="badge badge-warning">专业</span></h1> </div>
						<div class="col-3"><h1><span class="badge badge-info">年轻</span></h1> </div>
						<div class="col-3"><h1><span class="badge badge-light">朝气</span></h1> </div>
					</div>
				</div>
			</div>
			
			<!-- 脚部部分 -->
			<%@ include file="/templates/footer.jsp" %>
		</div>
		
	<!-- 修改银行卡和照片 Modal -->
	<div class="modal fade bd-example-modal-sm" id=photoCCModifyModal
		tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-sm modal-dialog-centered"
			role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalCenterTitle">个人信息修改</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form method="post" action="${pageContext.request.contextPath}/customer/ModifyPersonInfoServlet" enctype="multipart/form-data">						
						<div class="form-group" style="margin-top: -15px;">
							<label for="loginTelephone" class="col-form-label">新的卡号</label> <input
								type="text" class="form-control" 
								name="newCCNum" placeholder="请输入新的18位银行卡号"
								pattern="[0-9]{18}" required>
						</div>
						<div class="form-group" style="margin-top: -15px;">
							<label for="loginPassword" class="col-form-label">确认卡号</label> <input
								type="text" class="form-control"
								name="newCCNumConfirm" placeholder="请确认新的银行卡号"  pattern="[0-9]{18}" required>
						</div>
						<hr>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-primary"
							style="margin-left: 145px;">确认</button>
					</form>
				</div>
			</div>
		</div>
	</div>		  
</body>
</html>
