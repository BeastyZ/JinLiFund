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
 * Servlet 用户或管理员登录
 */
@WebServlet(name="LoginAction", urlPatterns={ "/LoginActionServlet"})
public class LoginActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		String Phone = request.getParameter("telephone");
		String password = request.getParameter("password");
		String checkCodeByCus = request.getParameter("checkCode");
		String identityChoice = request.getParameter("choice");
		
		HttpSession session = request.getSession();
		String checkCode = (String)session.getAttribute("checkCode");
		
		// 判断用户是否存在
		boolean cusExist = AllServices.findOne(Phone);
		if(cusExist) {
			// 如果校验码正确
			if(checkCode.equals(checkCodeByCus)) {
				boolean loginRes = AllServices.login(Phone, password, identityChoice);
				
				// 如果账号密码都正确
				if(loginRes) {
					String ipAddr = request.getLocalAddr();
					AllServices.addLog(Phone, ipAddr); // 登录记录
					session.setAttribute("cusPhone", Phone);
					
					// 用户登录
					if("customer".equals(identityChoice)) {
						boolean statusRes = AllServices.verifyCusStatus(Phone);
						if(statusRes) {
							session.removeAttribute("cusPhone");
							session.setAttribute("cusPhone", Phone + "(已开户)");
							
							PrintWriter out = response.getWriter();
							out.write("cusStatusOpen");
							out.flush();
							out.close();
						}
					}
					// 管理员登录
					else {
						request.getRequestDispatcher("jsp/administrator.jsp").forward(request, response);
					}
				}
				// 账号密码错误
				else {				
					PrintWriter out = response.getWriter();
					out.write("accountPasswordWrong");
					out.flush();
					out.close();
				}
				
			}
			// 校验码不正确
			else {		
				PrintWriter out = response.getWriter();
				out.write("checkCodeWrong");
				out.flush();
				out.close();
			}
		}
		// 如果用户不存在
		else {
			PrintWriter out = response.getWriter();
			out.write("cusNotExist");
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
