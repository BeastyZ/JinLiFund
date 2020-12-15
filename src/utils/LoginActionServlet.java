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
 * Servlet �û������Ա��¼
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
		
		// �ж��û��Ƿ����
		boolean cusExist = AllServices.findOne(Phone);
		if(cusExist) {
			// ���У������ȷ
			if(checkCode.equals(checkCodeByCus)) {
				boolean loginRes = AllServices.login(Phone, password, identityChoice);
				
				// ����˺����붼��ȷ
				if(loginRes) {
					String ipAddr = request.getLocalAddr();
					AllServices.addLog(Phone, ipAddr); // ��¼��¼
					session.setAttribute("cusPhone", Phone);
					
					// �û���¼
					if("customer".equals(identityChoice)) {
						boolean statusRes = AllServices.verifyCusStatus(Phone);
						if(statusRes) {
							session.removeAttribute("cusPhone");
							session.setAttribute("cusPhone", Phone + "(�ѿ���)");
							
							PrintWriter out = response.getWriter();
							out.write("cusStatusOpen");
							out.flush();
							out.close();
						}
					}
					// ����Ա��¼
					else {
						request.getRequestDispatcher("jsp/administrator.jsp").forward(request, response);
					}
				}
				// �˺��������
				else {				
					PrintWriter out = response.getWriter();
					out.write("accountPasswordWrong");
					out.flush();
					out.close();
				}
				
			}
			// У���벻��ȷ
			else {		
				PrintWriter out = response.getWriter();
				out.write("checkCodeWrong");
				out.flush();
				out.close();
			}
		}
		// ����û�������
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
