package customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.AllServices;

/**
 * Servlet 顾客注册账号
 */
@WebServlet(name = "RegisterAction", urlPatterns = { "/customer/RegisterActionServlet" })
public class RegisterActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		String cusPhone = request.getParameter("telephone");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();
		session.setAttribute("cusPhone", cusPhone);

		try {
			AllServices.addCustomer(cusPhone, password);
		} catch (SQLException e) {
			boolean statusRes = AllServices.verifyCusStatus(cusPhone);
			if(statusRes) {
				session.removeAttribute("cusPhone");
				session.setAttribute("cusPhone", cusPhone + "(已开户)");
			}
			PrintWriter out = response.getWriter();
			out.write("该用户已存在，可直接登录！");
			out.flush();
			out.close();
			
			String ipAddr = request.getLocalAddr();
			AllServices.addLog(cusPhone, ipAddr); // 登录记录
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
