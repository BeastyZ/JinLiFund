package customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.AllServices;
import utils.Fund;
import utils.FundCompany;
import utils.FundManager;

/**
 * Servlet 为数据中心单独设立的 自选基金 servlet
 */
@WebServlet("/customer/AddToSelfChosenForDataCenterServlet")
public class AddToSelfChosenForDataCenterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String tel = (String) session.getAttribute("cusPhone");
		String fundCode = request.getParameter("fundCode");
		String type = request.getParameter("type");
		
		// 基金排列
		if("pills-fund-ranking".equals(type)) {
			type = "pills-fund-ranking-tab";
		}
		
		// 基金净值
		else if("pills-fund-nav".equals(type)) {
			type = "pills-fund-nav-tab";
		}
		
		// 基金自选
		else if("pills-selfchosen".equals(type)) {
			type = "pills-selfchosen-tab";
		}
		
		// 基金公司
		else if("pills-fund-company".equals(type)) {
			type = "pills-fund-company-tab";
		}
		
		// 基金经理
		else if("pills-fund-manager".equals(type)) {
			type = "pills-fund-manager-tab";
		}
		
		// 默认为基金排列
		else{
			type = "pills-fund-ranking-tab";
		}
		
		boolean res = AllServices.addToSelfChosen(tel, fundCode);
		
		// 加载所有基金的信息
		List<Fund> funds = AllServices.loadAllFundInfo();
		for(Fund fund : funds) {
			if(fund.getFundInvestType() == 1) {
				fund.setFundInvestTypeToString("股票型");
			}
			else if(fund.getFundInvestType() == 2) {
				fund.setFundInvestTypeToString("债券型");
			}
			else if(fund.getFundInvestType() == 3) {
				fund.setFundInvestTypeToString("指数型");
			}
			else {
				fund.setFundInvestTypeToString("混合型");
			}
		}
		
		// 加载所有基金公司的信息
		List<FundCompany> fundComs = AllServices.loadAllFundCompanyInfo();
		// 加载所有基金经理的信息
		List<FundManager> fundManagers = AllServices.loadAllFundManagerInfo();
		
		request.setAttribute("type", type);
		request.setAttribute("fundManagers", fundManagers);
		request.setAttribute("fundComs", fundComs);
		request.setAttribute("funds", funds);
		request.setAttribute("info1", "<script>alert('ok')</script>");
		
		request.getRequestDispatcher("/jsp/dataCenter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
