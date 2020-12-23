package customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.AllServices;

/**
 * Servlet 用户购买基金
 */
@WebServlet("/customer/BuyFundServlet")
public class BuyFundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String tel = (String)session.getAttribute("cusPhone");
		String fundCode = request.getParameter("fundCode");
		int fundShare = Integer.parseInt(request.getParameter("fundShare"));
		String fundName = request.getParameter("fundName");
		
		boolean res = AllServices.buyFund(tel, fundCode, fundName, fundShare);
		PrintWriter out = response.getWriter();
		if(res) {
			out.write("success");
		}
		else {
			out.write("failed");
		}
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
