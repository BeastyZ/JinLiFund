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
		
		// �ж�����һ�������
		String role = request.getParameter("role");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if("customer".equals(role)) {
			Seller seller = MyService.findSeller(username, password);
			
			//��¼�ɹ�
			if(seller != null) {
				HttpSession session = request.getSession();
				session.setAttribute("seller", seller);
				
				// ת�������ҹ���ҳ��
				request.getRequestDispatcher("").forward(request, response);
			}
			else {
				request.setAttribute("infoWrong", "�û�����������������µ�¼...");
				
				// ת������¼ҳ��
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
