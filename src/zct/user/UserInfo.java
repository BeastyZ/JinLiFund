package zct.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet 显示数据库中所有的用户
 */

public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		
		if(username != null) {
			int userId = Integer.parseInt(request.getParameter("userId"));
			User user = UserService.findUserById(userId);
			
			request.setAttribute("user", user);
			request.getRequestDispatcher("templates/userInfoTemp.jsp").forward(request, response);
		}
		else {
			request.setAttribute("infoWrong", "请先登录再进行其他操作！");
			request.getRequestDispatcher("homePage.jsp").forward(request, response);
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
