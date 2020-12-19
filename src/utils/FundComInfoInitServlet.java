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
 * Servlet 初始化基金公司列表信息
 */
@WebServlet("/FundComInfoInitServlet")
public class FundComInfoInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 获得数据库中记录的数量
		int recNum = AllServices.countRec("t_fundcompany");
		PageControler fundComInfoPageControler = new PageControler(recNum, 1);

		List<FundCompany> allComs = AllServices.loadAllFundComInfo(1);
		
		HttpSession session = request.getSession();
		session.setAttribute("fundComInfoPageControler", fundComInfoPageControler);
		session.setAttribute("allComs", allComs);
		
		//request.getRequestDispatcher("/homePage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
