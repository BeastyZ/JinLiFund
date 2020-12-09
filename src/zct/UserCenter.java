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
 * Servlet UserCenter ��ʾһ���û��ĸ�����Ϣ�����û�����
 */

public class UserCenter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		// ��session�л�ȡ�û���
		String username = (String)session.getAttribute("username");
		
		if(username != null) {
			// ��ѯ�û�����
			User user = UserService.findExactUserByName(username);
			// �����ݷŵ�������
			request.setAttribute("user", user);
			// ת��
			request.getRequestDispatcher("templates/userInfoTemp.jsp").forward(request, response);
		}
		else {
			// �����ݷŵ�������
			request.setAttribute("infoWrong", "���ȵ�¼��");
			// ת��
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
