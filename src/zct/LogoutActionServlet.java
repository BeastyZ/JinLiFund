package zct;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Sessionע��
 */

public class LogoutActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ�Ự����
		HttpSession session = request.getSession();
		
		// ʹsessionʧЧ
		session.removeAttribute("username");
		session.invalidate();
		
		response.sendRedirect("homePage.jsp");
		//String username = (String)session.getAttribute("username");
		
//		if(username == null) {
//			// ת������¼ҳ��
//			response.sendRedirect("login.jsp");
//		}
		//��ù˿ͱ��ε�¼��ID
		//session.getId()
		//response.getWriter().append(session.getId());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
