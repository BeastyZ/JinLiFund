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
@WebServlet("/DataInitServlet")
public class DataInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 获得数据库中记录的数量
		int recNum = AllServices.countRec("t_fundcompany");
		List<FundCompany> allComs = AllServices.loadAllFundComInfo(1);
		// 按年收益率为第一关键字 季收益率为第二关键字进行排序
		List<Fund> fundsCut = AllServices.loadAllFundInfo().subList(0, 14);
		
		PageControler fundComInfoPageControler = new PageControler(recNum, 1);
		
		HttpSession session = request.getSession();
		session.setAttribute("fundComInfoPageControler", fundComInfoPageControler);
		session.setAttribute("allComs", allComs);
		session.setAttribute("fundsCut", fundsCut);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
