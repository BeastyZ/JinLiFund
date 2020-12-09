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
 * �û���¼����������Session�Ự��Servlet
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
//		// ��ȡ�û�������û���
//		String username = request.getParameter("username");
//		// ��ȡ�û����������
//		String password = request.getParameter("password");
//		
//		ServletConfig servletConfig = getServletConfig();
//		// ��ȡ�����ļ�����ȷ���û���
//		String correctUn = servletConfig.getInitParameter("username");
//		// ��ȡ�����ļ�����ȷ������
//		String correctPs = servletConfig.getInitParameter("password");
//		
//		if (correctUn.equals(username) && correctPs.equals(password)) {
//			// �Լ�ֵ�Ե���ʽ�����ݱ�����request��
//			request.setAttribute("username", username + "�����ѳɹ���¼��");
//			
//			// ת����success.html
//			request.getRequestDispatcher("homePage.jsp").forward(request, response);
//		}
//		else {
//			// �Լ�ֵ�Ե���ʽ�����ݱ�����request��
//			request.setAttribute("info", "�û������������");
//			request.setAttribute("wrongUsername", "��������û���Ϊ:" + username);
//			request.setAttribute("wrongPassword", "�������������Ϊ��" + password);
//			
//			// ת����login.jsp
//			request.getRequestDispatcher("login.jsp").forward(request, response);
//		}
		
		// ������ı�������Ϊutf-8
		request.setCharacterEncoding("utf-8");
		// ����Ӧ�ı�������Ϊutf-8
		response.setCharacterEncoding("utf-8");
		
		//��ȡ�û�������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkCodeByUser = request.getParameter("checkCode");
		
		// ��ȡ�Ự����
		HttpSession session = request.getSession();
		String checkCode = (String)session.getAttribute("checkCode");
		
		//�����֤����ȷ
		if(checkCodeByUser != null && checkCodeByUser.length() > 0 && checkCodeByUser.equals(checkCode)){
			
			User user = null;
			user = UserService.findExactUserByName(username);
			if(user != null) {
				//���û���д�뵽session��
				session.setAttribute("username", username);
				
				//request.setAttribute("logout", "ע��");
			}
			else {
				request.setAttribute("infoWrong", "�˺��������֤�벻��ȷ��");
			}
			
			//ת������¼����
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
