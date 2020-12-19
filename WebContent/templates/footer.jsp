<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<link
	href="${pageContext.request.contextPath}/bootstrap4/css/bootstrap.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/bootstrap4/css/pricing.css"
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

<div class="container">
	<footer class="pt-4 my-md-5 pt-md-5 border-top">
		<div class="row">
			<div class="col-12 col-md">
				<img class="mb-2" src="${pageContext.request.contextPath}/images/web_logo.png"
					width="40" height="40"> <small
					class="d-block mb-3 text-muted">&copy;2020.10-2020.12&nbsp; <br>锦鲤金服有限公司 &nbsp;版权所有</small>
			</div>
			<div class="col-6 col-md">
				<h5>优秀基金</h5>
				<ul class="list-unstyled text-small">
					<li><a class="text-muted" href="#" target="_blank">先锋量化</a></li>
					<li><a class="text-muted" href="#" target="_blank">交银新回</a></li>
					<li><a class="text-muted" href="#" target="_blank">光大保德</a></li>
					<li><a class="text-muted" href="#" target="_blank">光大保德</a></li>
				</ul>
			</div>
			<div class="col-6 col-md">
				<h5>权威</h5>
				<ul class="list-unstyled text-small">
					<li><a class="text-muted" href="${pageContext.request.contextPath}/images/qualification.jpg" target="_blank">基金销售资格</a></li>
					<li><a class="text-muted" href="http://www.csrc.gov.cn/pub/newsite/" target="_blank">监督机构</a></li>
					<li><a class="text-muted" href="https://www.amac.org.cn/" target="_blank">自律组织</a></li>
					<li><a class="text-muted" href="http://www.pbc.gov.cn/" target="_blank">监管银行</a></li>
				</ul>
			</div>
			<div class="col-6 col-md">
				<h5>关于</h5>
				<ul class="list-unstyled text-small">
					<li><a class="text-muted" href="${pageContext.request.contextPath}/jsp/team.jsp" target="_blank">团队</a></li>
					<li><a class="text-muted" href="https://www.zufe.edu.cn/" target="_blank">浙江财经大学</a></li>
					<li><a class="text-muted" href="#" data-toggle="modal" data-target="#privacyModal" target="_blank">隐私</a></li>
					<li><a class="text-muted" href="#" data-toggle="modal" data-target="#onlineTradingProtocolModalLong" target="_blank">条款</a></li>
				</ul>
			</div>
		</div>
	</footer>
</div>

<!-- 隐私Modal -->
<div class="modal fade" id="privacyModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">隐私条款提示</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        隐私条款尚在制作当中，敬请期待！
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">确认</button>
      </div>
    </div>
  </div>
</div>

<!-- 《网络交易条款》modal -->
<div class="modal fade" id="onlineTradingProtocolModalLong"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle"
	aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">锦鲤金服网上交易协议</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p style="text-indent:2em;">甲方应在充分了解远程交易委托的风险及本协议中乙方免责条款含义后谨慎考虑，以决定是否采用远程交易委托并与乙方签订本协议。</p>
				<strong>甲方：基金投资人</strong> <br> <strong> 乙方：锦鲤金服基金销售有限公司 </strong> <br><br>
				<p style="text-indent:2em;">为了方便甲方在乙方办理基金交易业务，甲乙双方依据有关法律、法规的规定，本着公开、公平、自愿和诚实信用的原则，就乙方为甲方提供网上交易服务及其他相关业务达成如下协议：</p>
				
				<strong> 一、风险提示</strong>
				<p style="text-indent:2em;">如果甲方申请使用乙方网上交易业务，甲方即被认为已经充分、完全、准确地了解网上交易的风险，并愿意承担由此可能带来的法律后果和投资损失。
				乙方已采取了先进的网络产品和合理有效的技术措施保护投资人资料和交易活动的安全。尽管如此，本着对投资人负责的态度，乙方在此郑重提醒甲方，网上交易客观上仍然存在如下风险包括但不限于：</p>
				<p style="text-indent:2em;">
				1．互联网是全球公共网络，并不受任何一个机构所控制。数据在互联网上传输的途径不是完全确定的，可能会受到非法干扰或侵入。
				2．在互联网上传输的数据有可能被某些未经许可的个人、团体或机构通过某种渠道获得或篡改。
				3．互联网上的数据传输可能因通信繁忙出现延迟，或因其他原因出现中断、停顿或数据不完全、数据错误等情况，从而使交易出现延迟、中断或停顿。
				4．互联网上发布的各种信息（包括但不限于分析、预测性的参考资料）可能出现错误并误导包括甲方在内的投资人。
				5．甲方的网上交易身份可能会被泄露或仿冒。
				6．甲方使用的计算机可能因存在性能缺陷、质量问题、计算机病毒、硬件故障及其他原因，而对甲方造成的交易时间或交易数据造成影响，给甲方造成损失。
				7．由于甲方的计算机应用操作能力或互联网知识的缺乏，可能对甲方的交易时间或交易数据造成影响，因此给甲方造成损失。
				8．因甲方自身的疏忽造成账号或密码泄露，可能会给甲方造成损失。
				9．其他可能会导致投资人损失的风险或事项。
				</p>
				
				<strong>二、释义 </strong>
				<p style="text-indent:2em;">除非本协议另有规定，下列词语具有如下含义：</p>
				<p style="text-indent:2em;">
				1．网上交易服务：是指乙方按照本协议的规定，为投资人（甲方）提供的，通过锦鲤金服基金网上交易系统或锦鲤金服基金网上交易第三方支付系统下达交易指令、进行信息查询等方面的服务。
				2．投资人（甲方）：指依照乙方所管理开放式基金的基金合同和基金招募说明书的规定，通过乙方提供的网上交易系统进行网上交易的投资人。目前仅指个人投资人。
				3．基金账户：指基金注册登记人为投资人开立的记录其持有乙方所管理的开放式基金的基金份额、份额变动情况及基本资料的账户。
				4．交易账户：是指甲方开立的记录其通过乙方投资理财中心或网上交易系统买卖乙方所管理开放式基金的基金份额及份额变动情况的账户。
				5．基金认购：是指开放式基金设立募集期内，甲方申请购买基金份额的行为。
				6．基金申购：是指开放式基金合同生效后，甲方申请购买基金份额的行为。
				7．基金赎回：是指开放式基金成立之后的存续期内，持有基金份额的投资人要求乙方购回基金份额的行为。
				8．基金转托管：是指甲方将其持有的基金份额从一个销售机构的交易账户转入另一个销售机构的交易账户的行为。
				9．基金转换：是指基金存续期间，甲方向乙方提出申请将其原持有基金（下称“转出基金”）的基金份额转换为乙方管理的其他基金（下称“转入基金”）的基金份额的行为。
				10．基金份额净值：是指计算日基金资产净值除以计算日基金份额总数后的价值。 
				11．T日：是指乙方确认的甲方提交有效申请的工作日。
				12．T＋n日：是指T日后第n个工作日（不包含T日）。 
				13．工作日：是指上海证券交易所或深圳证券交易所的正常交易日。
				14．开放日：是指为甲方办理基金业务的工作日。
				15．锦鲤金服基金网上交易系统：是指网址为https://trade.5ifund.com/的基金交易系统。
				16．锦鲤金服基金网上交易第三方支付机构：是指通过证监会的审批，具有基金第三方支付资格的公司及机构。
				17．业务规则：是指《锦鲤金服基金销售有限公司开放式基金网上交易业务规则》。
				</p>
				
				 <strong> 三、服务内容</strong>
				<p style="text-indent:2em;">协议所述网上交易服务的内容包括账户开立、账户资料变更、认购、申购、赎回、转换、交易撤销、分红方式变更、交易密码修改、相关信息查询及其他业务。</p>
				
				<strong> 四、甲方承诺</strong>
				<p style="text-indent:2em;">
				1．甲方已经了解并完全理解使用网上交易可能遭受的风险，并自愿承担该种风险及其可能导致的损失。
				2．甲方在签订本协议之前，已经详细阅读了本协议中包括乙方免责条款在内的所有条款，并已准确理解其含义。
				3．甲方确认已详细阅读并理解、接受乙方所管理的开放式基金的基金合同、基金招募说明书、业务规则的所有内容及规定。甲方自愿通过乙方的网上交易系统办理基金业务，并承诺上述业务视同甲方亲临乙方柜台办理。
				4．甲方保证用于投资乙方所管理基金的资金来源合法，否则由此引起的一切责任由甲方承担。
				5．甲方保证所输入的信息真实、准确和有效并对此承担责任，如有变化，甲方应及时变更相关资料。因甲方未能及时变更有关资料所可能导致的损失由甲方承担。
				6．甲方承诺独立使用本合同规定的网上交易服务，不与他人共享；甲方不利用该系统从事基金代理买卖业务并从中收取任何费用。
				7．甲方确保其用于网上交易的设备的安全性和可靠性。对于因甲方的设备故障、通讯故障等原因造成的经济损失，乙方不承担任何责任。
				8．甲方应自行承担其交易密码及银行卡支付密码、短信验证码等的保密义务。凡是使用甲方密码所进行的一切委托，均被视为甲方亲自办理的有效委托。甲方由于自己疏忽或其他原因而致使密码失密造成的损失由甲方自己承担，乙方对此不承担任何责任。
				9．甲方在发现或有理由认为存在未被授权的人正在或可能使用其账号、密码时，应立即与乙方联系，甲方承诺采取相应的保护、防范措施。
				10．甲方承诺不以任何方式攻击乙方网络或破坏乙方系统，否则承担由此给乙方或任何第三方造成的损失。
				11．甲方对其各项委托活动的结果承担全部责任，承诺偿付任何因其违约而使乙方遭受的损失。
				12．甲方不得将本协议项下的权利或义务的部分或全部转让给任何第三方。
				13．甲方不使用信用卡及任何种类的银行卡进行透支买卖乙方所设立、管理的基金，否则引起的纠纷与乙方无关。
				14．甲方承诺乙方保留或所得到的电子交易数据为甲方交易行为唯一有效证据，并承认其等同于书面签署之法律文件之效力。
				15．为保护甲方交易数据的安全，在进行网络交易时，甲方应使用乙方认可的浏览器。如果使用不符合要求的其他软件或设备进入乙方网站，所引起的任何损失或造成的任何后果，均由甲方自行承担。
				16．甲方知悉并承诺，若甲方进行开户、变更银行卡、注销账户等操作，应按照乙方的要求填写相关信息或提交相关材料至乙方，由乙方对该信息进行核对，以确保甲方个人账户的安全。
				</p>
				
				<strong> 五、乙方承诺 </strong> 
				<p style="text-indent:2em;">
				1．乙方遵守有关法律法规、规章制度，并愿意受本协议的所有条款的约束。
				2．乙方提供的远程委托系统的系统安全、数据备份和故障恢复手段符合监管机关的规定。
				3．乙方对甲方的委托资料、委托事项和密码负有保密义务，乙方未经甲方明确同意而泄露甲方的委托事项及开户资料，致使甲方蒙受经济损失时，甲方的索偿权仅限于真实损失之范围内。但乙方按照有关法律、法规和规章规定或有关司法机关、行政管理机关的要求提供甲方的有关资料不在此限。
				4．乙方在本协议生效当日，为甲方开通协议约定的委托方式。
				5．通讯故障、网络中断、线路堵塞等情况的发生导致通过约定的委托方式无法下达申请委托时，乙方将为甲方提供其他远程委托方式（但以与甲方签署的服务协议包含的委托方式为限）。
				</p>
				
				<strong> 六、特别提示</strong>
				<p style="text-indent:2em;">
				1．网上交易受理条件提示：甲方须与乙方通过网上方式签订《锦鲤金服基金销售有限公司开放式证券投资基金网上交易服务协议》。投资者可以通过网上交易系统页面指引，进入相关通道开通网上交易。
				2．网上交易的开通、使用、变更与终止提示：甲方欲开通、使用、变更、终止网上交易，须依据《锦鲤金服基金销售有限公司开放式基金网上交易业务规则》规定的流程办理。
				3．支付业务提示：甲方须依据《锦鲤金服基金销售有限公司开放式基金网上交易业务规则》办理资金支付事宜。网上转账系统支付渠道费率的变化或乙方相关销售政策的变化，可能会对投资者进行网上交易及资金支付的费率产生影响。
				4．密码提示：甲方开通网上交易应设置并妥善保管交易密码。
				5．委托提示：(1)甲方通过网上交易方式下达的委托，以乙方的系统记录为准；(2)甲方使用网上交易，需自行支付因此产生的相关费用,如：上网费、电话费、划款手续费、因业务寄送资料产生的相关费用等。
				</p>
				
				<strong> 七、免责条款</strong> 
				<p style="text-indent:2em;">因下列情形导致甲方损失的，乙方不承担责任：</p>
				<p style="text-indent:2em;">
				1．因地震、火灾、台风及其他各种不可抗力引起停电、网络系统故障、电脑故障。
				2．因电信部门的通讯线路故障、通讯技术缺陷、电脑黑客或计算机病毒等问题造成委托系统不能正常运转。
				3．法律、政策重大变化，或乙方不可预测、不可控制的因素导致的突发事件导致甲方损失的。
				4．因通讯、网络中断、堵塞等情况致使无法及时通过约定的委托手段下达申请委托时导致甲方损失的。
				5．因甲方设备或通讯故障或设备未能处于正常工作状态致使乙方未能按时或及时收到甲方申请信息，或者乙方收到的甲方申请信息不完整而导致甲方损失的。
				6．因甲方对设备的错误操作和对有关信息的错误理解导致甲方损失的。
				7．因甲方的故意或疏忽导致交易密码或银行卡支付密码泄露或遗失，由此导致甲方损失的。
				8．因黑客攻击、电子病毒等非乙方原因造成甲方交易密码等重要信息泄露或遗失，由此导致甲方损失的。
				9．法律规定和本协议约定的其他乙方免责事项。
				</p>
				
				<strong> 八、协议生效及变更</strong>
				<p style="text-indent:2em;">
				1．本协议自甲方对本协议予以接受之日起生效。 2．乙方保留对本协议内容进行修改、删除或增加的权利。
				3．乙方修改、删除或增加本协议内容，将以书面形式将该事项登载于乙方的网站及营业场所或以其他乙方认可的方式通知甲方。
				4．本协议签署后，若有关法律、法规、监管部门规章、《基金合同》、《招募说明书》及其他乙方和甲方应共同遵守的文件发生修订，本协议与之不相适应的内容及条款自行失效，但本协议其他内容和条款继续有效。
				5．本协议在下述情况之一发生时终止：
				(1)双方签订书面协议同意终止；(2)甲方死亡或不再具备相应的民事行为能力；(3)甲方撤销本协议项下设立的交易账户；(4)乙方不作为甲方认购、申购基金或甲方所持有基金的管理人；(5)因不可抗力使本协议无法继续履行；(6)一方违约，另一方书面通知对方提出解除本协议；(7)甲方通过柜台或网上方式取消网上交易方式；(8)法律法规、基金合同约定的其它情形。
				</p>
				
				<strong> 九、争议的解决</strong>
				<p style="text-indent:2em;">甲、乙双方如有争议，应尽可能通过协商解决；协商不成的，任何一方均有权向中国国际经济贸易仲裁委员会申请仲裁。仲裁裁决是终局的，对双方均有法律约束力。</p>
				<strong> 十、本协议未尽事宜，双方协商解决</strong>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">已读</button>
			</div>
		</div>
	</div>
</div>