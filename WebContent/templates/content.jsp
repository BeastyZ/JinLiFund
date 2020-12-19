<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

<script type="text/javascript">

// 页面刷新就执行，显示初始的基金公司列表
$(document).ready(function(){
	$.post("${pageContext.request.contextPath}/FundComInfoInitServlet");
});

// 自选基金 模态控制
$(function() {
	$("#nav-customizeFund-tab").click(function() {
			var cusPhone = '${cusPhone}';
			if(cusPhone == "")
				alert("登陆后才能查看自选基金！");
		});
});

</script>

<!-- 服务选择部分 -->
<div class="container" style="margin-top: 20px;">
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
					<a href="${pageContext.request.contextPath}/jsp/openAccount.jsp" class="serviceList" target="_blank">基金开户</a>
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
	
	<div class="row">
		<div class="col-4">
			<!-- 搜索 -->
			<div class="control-inline" style="width:300px">
				<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
				  <li class="nav-item">
				    <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#pills-search" role="tab" aria-controls="pills-home" aria-selected="true" style="color: black;">基金</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-search" role="tab" aria-controls="pills-profile" aria-selected="false" style="color: black;">基金公司</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="#pills-search" role="tab" aria-controls="pills-contact" aria-selected="false" style="color: black;">基金经理</a>
				  </li>
				</ul>
				<div class="tab-content" id="pills-tabContent">
				  <div class="tab-pane fade show active" id="pills-search" role="tabpanel" aria-labelledby="pills-home-tab">
				  	<div class="input-group mb-3">
					  <input type="text" class="form-control" placeholder="输入要搜索的内容..." aria-label="Recipient's username" aria-describedby="basic-addon2">
					  <div class="input-group-append">
					    <button class="btn btn-success" type="button">搜索</button>
					  </div>
					</div>
				  </div>
				</div>
			</div>
		</div>
		
		<div class="col"></div>
		
		<div class=col-6>
			<!-- 好基金提示 -->
			<div class="row" style="margin-top:20px;">
				<div class="col-2">
					<h1><span class="badge badge-secondary">TOP</span></h1>
				</div>
				<div class="col" style="margin-top:3px;">
					<a href="" style="text-decoration:none;"><button type="button" class="btn btn-light btn-lg btn-block"><b>优秀基金：</b><span style="color:red;">东方新能源汽车主题混合</span></button></a>
				</div>	
			</div>
		</div>
	</div>
	
	<hr style="border: none; background: red; height: 3px;">
	
	<div class="row">
		<div class="col-6" style="font-size:12px;">
			<!-- 估值排行 自选基金 -->
			<nav>
			  <div class="nav nav-tabs" id="nav-tab" role="tablist">
			    <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">估值排行</a>
			    <a class="nav-item nav-link" id="nav-customizeFund-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">自选基金</a>
			  </div>
			</nav>
			<div class="tab-content" id="nav-tabContent">
			  <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
			  	<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">基金公司名称</th>
						<th scope="col">估算值</th>
						<th scope="col">估算增长率</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${allComs }" var="item">
					<tr>
						<td>${item.comName }</td>
						<th scope="row">${item.assetManagementScale }</th>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			  </div>
			  <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">...</div>
			</div>
		</div>
		<div class="col-6">
			<!-- 幻灯片播放图片 -->
			<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
			  <ol class="carousel-indicators">
			    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
			    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			  </ol>
			  <div class="carousel-inner">
			    <div class="carousel-item active">
			      <img src="${pageContext.request.contextPath}/images/slideOne.jpg" class="d-block w-100">
			    </div>
			    <div class="carousel-item">
			      <img src="${pageContext.request.contextPath}/images/slideTwo.jpg" class="d-block w-100">
			    </div>
			    <div class="carousel-item">
			      <img src="${pageContext.request.contextPath}/images/slideThree.jpg" class="d-block w-100">
			    </div>
			  </div>
			  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="sr-only">上一张</span>
			  </a>
			  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="sr-only">下一张</span>
			  </a>
			</div>
			
			<!-- 卡片选择部分，有基金交易和免费开户 -->
			<div class="card text-center" style="margin-top:30px;">
			  <div class="card-header" style="text-align:justify; font-size:12px;">
			    锦鲤金服是证监会批准的首批独立基金销售机构上市公司，交易安全有保障。
			  </div>
			  <div class="card-body">
			  	<div class="row">
			  		<div class="col-6">
			  			<a href="#" class="btn btn-danger btn-lg btn-block" style="height:70px;"><b>免费开户</b><br><span style="font-size:12px;">8秒开户</span></a>
			  		</div>
			  		<div class="col-6">
			  			<a href="#" class="btn btn-primary btn-lg btn-block" style="height:70px;"><b>基金交易</b><br><span style="font-size:12px;">全场一折</span></a>
			  		</div>
			  	</div>
		  		
			    <p class="card-text" style="margin-top:15px;">
			    	<img src="${pageContext.request.contextPath}/images/phone.png" height="20" width="20">
			    	<strong>锦鲤金服客服热线:&nbsp;</strong>
			    	<i style="color:red; font-weight:bold;">952555</i>
				</p>
				
				<p>
					<img src="${pageContext.request.contextPath}/images/investProfession.png" height="100" width="200">
				</p>
			    
			  </div>
			  <div class="card-footer text-muted" style="margin-top:-20px;">
			    <a href="" data-toggle="modal" data-target="#tipModal">帮助中心</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			    <a href="" data-toggle="modal" data-target="#onlineTradingProtocolModalLong">开户条款</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			    <a href="https://help.aliyun.com/product/28498.html" target="_blank">安全保障</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			    <a href="" data-toggle="modal" data-target="#loginModalCenter">个人登录</a>
			  </div>
			</div>
		</div>
	</div>
	
	<hr style="border: none; background: red; height: 3px;">
	
	<!-- 新闻预览 -->
	<nav style="margin-top:10px;">
	  <div class="nav nav-tabs" id="nav-tab" role="tablist">
	    <a style="color:black;" class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-fund-class" role="tab" aria-controls="nav-home" aria-selected="true">基金课堂</a>
	    <a style="color:black;" class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-fund-comment" role="tab" aria-controls="nav-profile" aria-selected="false">基金评论</a>
	    <a style="color:black;" class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-fund-depository" role="tab" aria-controls="nav-contact" aria-selected="false">基金重仓</a>
	  </div>
	</nav>
	<div class="tab-content" id="nav-tabContent">
	  <div class="tab-pane fade show active" id="nav-fund-class" role="tabpanel" aria-labelledby="nav-home-tab">
	  	<ul>
	  		<li><a href="http://fund.10jqka.com.cn/20200925/c623819065.shtml" style="color:black;" target="_blank">新基民必看：了解基金知识 匹配风险等级</a></li>
	  		<li><a href="http://fund.10jqka.com.cn/20191016/c614432559.shtml" style="color:black;" target="_blank">股票型基金混合型基金指数型基金的联系与区别</a></li>
	  		<li><a href="http://fund.10jqka.com.cn/20190531/c611732484.shtml" style="color:black;" target="_blank">基金定投是怎么回事？有什么优势？</a></li>
	  		<li><a href="http://fund.10jqka.com.cn/20190531/c611732179.shtml" style="color:black;" target="_blank">一文看懂原油ETF</a></li>
	  		<li><a href="http://fund.10jqka.com.cn/20190530/c611702401.shtml" style="color:black;" target="_blank">基金下折是什么意思？是好还是坏？</a></li>
	  		<li><a href="http://fund.10jqka.com.cn/20190524/c611613523.shtml" style="color:black;" target="_blank">投资私募基金前要先排雷 失联公告了解一下</a></li>
	  		<li><a href="http://fund.10jqka.com.cn/20190522/c611549579.shtml" style="color:black;" target="_blank">科普：基金名称后面的ABC都是啥意思？收费方式不同</a></li>
	  		<li><a href="http://fund.10jqka.com.cn/20190522/c611544239.shtml" style="color:black;" target="_blank">景顺长城基金：手把手带你认识ETF申购赎回清单</a></li>
	  		<li><a href="http://fund.10jqka.com.cn/20190505/c611194936.shtml" style="color:black;" target="_blank">基金C类份额的罪与罚：需注意短期投资者持有较多</a></li>
	  		<li><a href="http://fund.10jqka.com.cn/20190422/c610981850.shtml" style="color:black;" target="_blank">基金定投:控制投资比例、不追热点、不满仓</a></li>
	  		<li><a href="http://fund.10jqka.com.cn/20190312/c610186191.shtml" style="color:black;" target="_blank">指数股（ETF）讲堂 ESG投资在路上</a></li>
	  		<li><a href="http://fund.10jqka.com.cn/20190107/c609063787.shtml" style="color:black;" target="_blank">指数基金 已进入定投区间</a></li>
	  	</ul>
	  </div>
	  <div class="tab-pane fade" id="nav-fund-comment" role="tabpanel" aria-labelledby="nav-profile-tab">
	  	<ul>
	  		<li><a href="http://bond.10jqka.com.cn/20201218/c625485694.shtml" style="color:black;" target="_blank">景顺长城：可转债具有结构性机会 关注盈利改善和低估值品种</a></li>
	  		<li><a href="http://fund.10jqka.com.cn/20201218/c625478911.shtml" style="color:black;" target="_blank">清和泉资本：明年A股会存在些许压力 但牛市周期会越来越长</a></li>
	  		<li><a href="http://fund.10jqka.com.cn/20201218/c625475745.shtml" style="color:black;" target="_blank">市场运行周期来看 最终向上是大概率的事情</a></li>
	  		<li><a href="http://fund.10jqka.com.cn/20201218/c625473518.shtml" style="color:black;" target="_blank">明年买啥性价比更高？股债投资大咖这样说</a></li>
	  		<li><a href="http://fund.10jqka.com.cn/20201217/c625446306.shtml" style="color:black;" target="_blank">易方达张胜记：宽市场基准类增强产品配置正当时 金融和周期仍有投资机会</a></li>
	  	</ul>
	  </div>
	  <div class="tab-pane fade" id="nav-fund-depository" role="tabpanel" aria-labelledby="nav-contact-tab">
	  	<ul>
	  		<li><a href="http://fund.10jqka.com.cn/20201219/c625498568.shtml" style="color:black;" target="_blank">基金排名战白热化！这些基金重仓股异动</a></li>
	  		<li><a href="http://fund.10jqka.com.cn/20201218/c625488970.shtml" style="color:black;" target="_blank">“淡水泉时刻”能否再现传奇？退市新规下“逆向投资”难觅优质小盘股 如何打破规模是业绩杀手魔咒</a></li>
	  		<li><a href="http://fund.10jqka.com.cn/20201218/c625476691.shtml" style="color:black;" target="_blank">争夺排名！年度最后10个交易日 这些基金重仓股频频异动</a></li>
	  		<li><a href="http://fund.10jqka.com.cn/20201218/c625476643.shtml" style="color:black;" target="_blank">公募基金年末排名大战悬念迭起 年度冠军花落谁家？基金经理透露明年配置方向</a></li>
	  		<li><a href="http://fund.10jqka.com.cn/20201216/c625432703.shtml" style="color:black;" target="_blank">光伏板块继续爆火！基金年尾仍在估值顶参与光伏定增 HIT电池成产业发力方向</a></li>
	  	</ul>
	  </div>
	</div>

	<hr style="border: none; background: red; height: 3px;">
	
	<!-- 基金公司列表部分 -->
	<h5 style="text-align:center;">基金公司列表</h5>
	<table class="table table-striped">
		<caption>第${fundComInfoPageControler.currentPageNo }页&nbsp;共${fundComInfoPageControler.totalPage }页</caption>
		<thead>
			<tr>
				<th scope="col">基金公司名称</th>
				<th scope="col">资产管理规模(亿元)</th>
				<th scope="col">旗下基金数量</th>
				<th scope="col">成立时间</th>
				<th scope="col">总经理</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allComs }" var="item">
			<tr>
				<td>${item.comName }</td>
				<th scope="row">${item.assetManagementScale }</th>
				<td>${item.fundNum }</td>
				<td>${item.setupTime }</td>
				<td>${item.generalManager }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<!-- 翻页控制 -->
	<nav aria-label="Page navigation example">
	  <ul class="pagination justify-content-end">
	    <li class="page-item"><a class="page-link" style="color: black;" href="${pageContext.request.contextPath}/FundComInfoPageTurningServlet?pageNo=${fundComInfoPageControler.firstPageNo }">第一页</a></li>
	    <li class="page-item"><a class="page-link" style="color: black;" href="${pageContext.request.contextPath}/FundComInfoPageTurningServlet?pageNo=${fundComInfoPageControler.prePageNo }">上一页</a></li>
	    <li class="page-item"><a class="page-link" style="color: black;" href="${pageContext.request.contextPath}/FundComInfoPageTurningServlet?pageNo=${fundComInfoPageControler.nextPageNo }">下一页</a></li>
	    <li class="page-item"><a class="page-link" style="color: black;" href="${pageContext.request.contextPath}/FundComInfoPageTurningServlet?pageNo=${fundComInfoPageControler.lastPageNo }">最后一页</a></li>
	  </ul>
	</nav>
	
</div>


<!-- 提示Modal -->
<div class="modal fade" id="tipModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">信息提示</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        功能尚在开发当中，敬请期待！
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">确认</button>
      </div>
    </div>
  </div>
</div>
