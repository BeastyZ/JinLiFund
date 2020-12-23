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
 * Servlet �˿�ע���˺�
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
			PrintWriter out = response.getWriter();
			out.write("success");
			out.flush();
			out.close();
		} catch (SQLException e) {
			PrintWriter out = response.getWriter();
			out.write("���û��Ѵ��ڣ���ֱ�ӵ�¼��");
			out.flush();
			out.close();
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
