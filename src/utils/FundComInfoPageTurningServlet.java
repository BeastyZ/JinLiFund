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
 * Servlet 加载所有基金公司的信息
 */
@WebServlet("/FundComInfoPageTurningServlet")

public class FundComInfoPageTurningServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pageNo = request.getParameter("pageNo");
		
		List<FundCompany> allComs = AllServices.loadAllFundComInfo(Integer.parseInt(pageNo));
		
		// 获得数据库中记录的数量
		int recNum = AllServices.countRec("t_fundcompany");
		PageControler fundComInfoPageControler = new PageControler(recNum, Integer.parseInt(pageNo));
		
		HttpSession session = request.getSession();
		session.removeAttribute("allComs");
		session.removeAttribute("fundComInfoPageControler");
		session.setAttribute("allComs", allComs);
		session.setAttribute("fundComInfoPageControler", fundComInfoPageControler);
		
		request.getRequestDispatcher("/homePage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
