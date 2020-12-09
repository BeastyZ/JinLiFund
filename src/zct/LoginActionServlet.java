package zct;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import zct.user.User;
import zct.user.UserService;

/**
 * 用户登录处理；采用了Session会话；Servlet
 */

public class LoginActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginActionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// 获取用户输入的用户名
//		String username = request.getParameter("username");
//		// 获取用户输入的密码
//		String password = request.getParameter("password");
//		
//		ServletConfig servletConfig = getServletConfig();
//		// 获取配置文件中正确的用户名
//		String correctUn = servletConfig.getInitParameter("username");
//		// 获取配置文件中正确的密码
//		String correctPs = servletConfig.getInitParameter("password");
//		
//		if (correctUn.equals(username) && correctPs.equals(password)) {
//			// 以键值对的形式将内容保存在request中
//			request.setAttribute("username", username + "！您已成功登录！");
//			
//			// 转发到success.html
//			request.getRequestDispatcher("homePage.jsp").forward(request, response);
//		}
//		else {
//			// 以键值对的形式将内容保存在request中
//			request.setAttribute("info", "用户名或密码错误！");
//			request.setAttribute("wrongUsername", "您输入的用户名为:" + username);
//			request.setAttribute("wrongPassword", "；您输入的密码为：" + password);
//			
//			// 转发到login.jsp
//			request.getRequestDispatcher("login.jsp").forward(request, response);
//		}
		
		// 将请求的编码设置为utf-8
		request.setCharacterEncoding("utf-8");
		// 将响应的编码设置为utf-8
		response.setCharacterEncoding("utf-8");
		
		//获取用户的输入
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkCodeByUser = request.getParameter("checkCode");
		
		// 获取会话对象
		HttpSession session = request.getSession();
		String checkCode = (String)session.getAttribute("checkCode");
		
		//如果验证码正确
		if(checkCodeByUser != null && checkCodeByUser.length() > 0 && checkCodeByUser.equals(checkCode)){
			
			User user = null;
			user = UserService.findExactUserByName(username);
			if(user != null) {
				//把用户名写入到session中
				session.setAttribute("username", username);
				
				//request.setAttribute("logout", "注销");
			}
			else {
				request.setAttribute("infoWrong", "账号密码或验证码不正确！");
			}
			
			//转发到登录界面
			request.getRequestDispatcher("homePage.jsp").forward(request, response);
		}
	}
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
