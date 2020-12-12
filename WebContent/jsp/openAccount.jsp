<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<title>基金开户</title>
<%@ include file="templates/utils.jsp"%>
<link rel="stylesheet" href="stylesheet/openAccount/cb">
<script type="text/javascript" charset="utf-8" data-requirecontext="_"
	data-requiremodule="index.20190102"
	src="stylesheet/openAccount/js/index.20190102.js"></script>

</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand" href="homePage.jsp"> <img
			src="images/web_logo.png" width="30" height="30"
			class="d-inline-block align-top" alt=""> 锦鲤金服基金商城
		</a>
		<ul class="nav justify-content-end">
			<li class="nav-item"><a class="nav-link disabled" href="#"
				tabindex="-1" aria-disabled="true" style="margin-right: -15px;">已有账号？</a></li>
			<li class="nav-item"><a
				class="nav-link; btn btn-outline-success" href="accountLogin.jsp">立即登录</a></li>
		</ul>
	</nav>

	<div class="content">
		<p class="c-total" id="MoneyTotal" style="display: block;">
			<b>锦鲤金服&nbsp;已为用户赚取 <b class="f-redN">1,380,813,462.53</b>
				元，加入我们一起理财！
			</b>
		</p>

		<p class="c-total" id="secretTip" style="display: none;"><b>个人信息由银行验证，锦鲤金服守护您的隐私安全!</b></p>

		<div class="c-form">
			<div class="progress">
				<div class="progress-bar" role="progressbar" style="width: 50%;"
					aria-valuenow="33" aria-valuemin="0" aria-valuemax="100">1/2</div>
			</div>
			<div class="list" id="firstStep" style="">
				<div class="l-box">
					<div class="l-line won">
						<span class="title">手机号码</span> <input type="text"
							class="ll-phonenum" data-type="phonenum" maxlength="13"
							id="setPhoneNum" placeholder="请输入手机号码" required><span class="info"></span>
						<span class="itip"></span>
					</div>
				</div>
				<div class="l-box">
					<div class="l-line">
						<span class="title">您的密码</span> <input type="password"
							class="ll-password" data-type="password" maxlength="20"
							id="setPassword" placeholder="8-20位字符，除特殊字符" required><span class="info"></span>
						<span class="itip"></span>
					</div>
				</div>
				<div class="l-box mb30">
					<div class="l-line">
						<span class="title">确认密码</span> <input type="password"
							class="ll-password" data-type="passwordagain" id="passwordAgain"
							placeholder="请再次输入密码" required><span class="info"></span>
						<span class="itip"></span>
					</div>
				</div>
				<div class="l-button can" id="stepFisrtbt">
					<a href="javascript:void(0);">下一步</a>
				</div>
				<div class="l-treaty" id="treatyCtrl">
					<div class="ex">
						<span><i class="on"></i>我已认真阅读并同意 <a href="investorRights.jsp"
							class="f-link" target="_blank">《投资人权益须知》</a>及 <a href="onlineTradingProtocol.jsp"
							class="f-link" target="_blank">《开户协议》</a></span>
					</div>
				</div>
			</div>
			<div class="list" id="secondStep" style="display: none;">
				<p class="l-title">监管部门规定</p>
				<p class="l-stitle">基金投资账户需通过实名认证，以确保投资安全</p>
				<div class="l-box">
					<div class="l-line">
						<span class="title">姓名</span> <input type="text" id="setName"
							data-type="name" placeholder="请填写真实姓名" required> <span class="info"></span>
						<span class="itip"></span>
					</div>
				</div>
				<div class="l-box mb30">
					<div class="l-line">
						<span class="title">身份证号</span> <input type="text"
							data-type="idnum" maxlength="20" class="ll-idcard" id="setIdnum">
						<span class="placehd">请确保姓名与身份证号一致</span>
					</div>
				</div>
				 <div class="l-box">
                <div class="l-line">
                    <span class="title">银行卡号</span>
                    <input type="text" class="ll-bank w210" maxlength="23" id="setBanknum" placeholder="请输入银行卡号" required>
                </div>
            </div>
				<div class="l-button can" id="stepSecondbt">
					<a href="javascript:void(0);">确认信息</a>
				</div>
			</div>
		</div>
		<p class="c-contact">
			客服热线：<b class="f-redN">999666333</b>&nbsp;&nbsp;&nbsp;&nbsp;工作日：9:00-20:00；
			节假日：14:00-17:00
		</p>
	</div>
	<div class="footer-box">
		<div class="con">
			<div class="footer">
				<ul class="footer-list">
					<li>
						<h4>基金销售资格</h4> <a class="u-footer_img footer-list_1"></a>
					</li>
					<li>
						<h4>监督机构</h4> <a class="u-footer_img footer-list_2"></a>
					</li>
					<li>
						<h4>自律组织</h4> <a class="u-footer_img footer-list_3"></a>
					</li>
					<li>
						<h4>监管银行</h4> <a class="u-footer_img footer-list_4"></a>
					</li>
					<li class="nobd">
						<h4>安全认证</h4> <a class="u-footer_img footer-list_5"></a>
					</li>
				</ul>
				<p class="tc">
					Copyright&nbsp;©&nbsp;2020.10-2020.12&nbsp;锦鲤金服有限公司&nbsp;版权所有</p>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="stylesheet/openAccount/cb(1)"></script>
	<script type="text/javascript">
		var PAGEID = 'f_kaihu_pwdset';
		var ACPAGE = 1;
		var TAINFO = {
			optime : new Date().getTime(),
			cururl : document.referrer
		};
	</script>
	<script type="text/javascript" src="stylesheet/openAccount/cb(2)"
		data-main="stylesheet/openAccount/js/index.20190102.js"></script>
</body>
</html>