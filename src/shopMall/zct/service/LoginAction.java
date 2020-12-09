package shopMall.zct.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopMall.zct.servlet.sellers.Seller;

/**
 * Servlet 
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 判断是买家还是卖家
		String role = request.getParameter("role");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if("customer".equals(role)) {
			Seller seller = MyService.findSeller(username, password);
			
			//登录成功
			if(seller != null) {
				HttpSession session = request.getSession();
				session.setAttribute("seller", seller);
				
				// 转发到卖家管理页面
				request.getRequestDispatcher("").forward(request, response);
			}
			else {
				request.setAttribute("infoWrong", "用户名或密码错误，请重新登录...");
				
				// 转发到登录页面
				request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			}
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
