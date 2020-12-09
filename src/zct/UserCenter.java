package zct;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import zct.user.User;
import zct.user.UserService;

/**
 * Servlet UserCenter 显示一个用户的个人信息，即用户中心
 */

public class UserCenter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		// 从session中获取用户名
		String username = (String)session.getAttribute("username");
		
		if(username != null) {
			// 查询用户数据
			User user = UserService.findExactUserByName(username);
			// 把数据放到请求中
			request.setAttribute("user", user);
			// 转发
			request.getRequestDispatcher("templates/userInfoTemp.jsp").forward(request, response);
		}
		else {
			// 把数据放到请求中
			request.setAttribute("infoWrong", "请先登录！");
			// 转发
			request.getRequestDispatcher("templates/userInfoTemp.jsp").forward(request, response);;
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
