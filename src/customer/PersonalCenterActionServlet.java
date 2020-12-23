package customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.AllServices;
import utils.Customer;

/**
 * Servlet 展示用户个人中心
 */
@WebServlet("/customer/PersonalCenterActionServlet")
public class PersonalCenterActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String cusPhone = (String)session.getAttribute("cusPhone");
		
		// 从数据库中获取该用户的所有信息
		Customer exactCus = AllServices.findExactCus(cusPhone.substring(0, 11));
		
		String tel = exactCus.getCusPhone();
		tel = tel.substring(0, 3) + "****" + tel.substring(7, 11);
		exactCus.setCusPhone(tel);
		
		// 判断用户是否已经开户
		if(exactCus.getCusStatus() == 1) {
			
			// 对用户的数据进行隐私化处理		
			String idNum = exactCus.getCusIDNum();
			String creditNum = exactCus.getCusCCNum();
			
			idNum = idNum.substring(0, 6) + "********" + idNum.substring(14, 18);
			creditNum = creditNum.substring(0, 6) + "********" + creditNum.substring(14, 18);
			
			exactCus.setCusIDNum(idNum);
			exactCus.setCusCCNum(creditNum);
		}
		
		request.setAttribute("cusPhoto", exactCus.getCusPhoto());
		request.setAttribute("customer", exactCus);
		
		// 返回用户已购基金的数量
		int fundNum = AllServices.calFundNumForCus(cusPhone.substring(0, 11));
		// 计算用户的基金资产总额
		String fundAssetsTotal = String.format("%.2f", AllServices.calFundAssetsTotalForCus(cusPhone.substring(0, 11)));
		
		
		request.setAttribute("fundNum", fundNum);
		request.setAttribute("fundTotal", fundAssetsTotal);
		request.setAttribute("flag", "显示");
		
		// 转发
		request.getRequestDispatcher("/jsp/personalCenter.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
