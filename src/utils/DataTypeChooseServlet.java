package utils;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet 选择数据中心要显示的类型；默认类型为“基金排列”
 */
@WebServlet("/DataTypeChooseServlet")
public class DataTypeChooseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
