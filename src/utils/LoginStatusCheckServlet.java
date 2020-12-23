package utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet 如果用户已经登录 可以查看与个人有关的信息
 */
@WebServlet("/LoginStatusCheckServlet")
public class LoginStatusCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String postName = request.getParameter("postName");
		
		HttpSession session = request.getSession();
		String cusPhone = (String)session.getAttribute("cusPhone");
	
		if("fundSelfChosenSimplied".equals(postName) && cusPhone == null || "personalCenter".equals(postName) && cusPhone == null) {
			
			PrintWriter out = response.getWriter();
			out.write("logoutStatus");
			out.flush();
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
