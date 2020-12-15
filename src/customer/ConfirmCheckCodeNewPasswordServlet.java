package customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.AllServices;

/**
 * Servlet 比较用户输入的校验码与系统生成的是否一致
 */
@WebServlet(name = "ConfirmCheckCodeNewPassword", urlPatterns = { "/customer/ConfirmCheckCodeNewPasswordServlet" })
public class ConfirmCheckCodeNewPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String newPassword = request.getParameter("newPassword");
		String checkCodeByCus = request.getParameter("CheckCodeByCus");
		
		HttpSession session = request.getSession();
		String checkCodeBySys = (String)session.getAttribute("resetPasswordCheckCode");
		
		if(checkCodeBySys.equals(checkCodeByCus)) {
			
			String resetPasswordTel = (String)session.getAttribute("resetPasswordTel");
			boolean res = AllServices.updateCusPassword(resetPasswordTel, newPassword);
			
			if(res) {
				PrintWriter out = response.getWriter();
				out.write("allValid");
				out.flush();
				out.close();
			}
			else {
				PrintWriter out = response.getWriter();
				out.write("invalid");
				out.flush();
				out.close();
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
