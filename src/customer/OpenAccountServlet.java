package customer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import utils.AllServices;

/**
 * Servlet ����
 */
@WebServlet(name = "OpenAccount", urlPatterns = { "/customer/OpenAccountServlet" })
@MultipartConfig()

public class OpenAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String openAccTel = request.getParameter("openAccTel");
		String openAccPassword = request.getParameter("openAccPassword");
		String openAccName = request.getParameter("openAccName");
		String openAccIDNum = request.getParameter("openAccIDNum");
		String openAccCCNum = request.getParameter("openAccCCNum");
		Part openAccPhoto = request.getPart("openAccPhoto"); // ��ȡ�û��ϴ���ͼƬ
		
		// �ж��˻��������Ƿ���Ч
		boolean res = AllServices.verifyCusPhonePassword(openAccTel, openAccPassword);
		if(res) {
			// �����ݿ�д������ ���֤ ���п��� ��Ƭ
			// ����û��ϴ���ͼƬ
			if(openAccPhoto.getSubmittedFileName() != "") {
				
				String proPath = this.getServletContext().getRealPath("/"); // ��ȡ��Ŀʵ�������ַ
				String photoUploadPath = proPath + "images" +  File.separator + "profiles" + File.separator; // ͼƬʵ���ϴ���ַ
				openAccPhoto.write(photoUploadPath + openAccTel); // ���浽ָ��·����
				String photoName =  openAccTel + openAccPhoto.getSubmittedFileName().substring(openAccPhoto.getSubmittedFileName().length() - 4, openAccPhoto.getSubmittedFileName().length());
				
				//д�����ݿ� �����ֻ�������ͼƬ
				AllServices.saveOpenAccInfo(openAccTel, openAccName, openAccIDNum, openAccCCNum, photoName);
			}
			else {
				//д�����ݿ�
				AllServices.saveOpenAccInfo(openAccTel, openAccName, openAccIDNum, openAccCCNum, "");
			}
			HttpSession session = request.getSession();
			session.setAttribute("cusPhone", openAccTel + "(�ѿ���)");
			
			request.getRequestDispatcher("/homePage.jsp").forward(request, response);
		}
		else {
			request.setAttribute("openAccFailed", "����ʧ�ܣ��˺Ż�������������³��ԣ�");
			request.getRequestDispatcher("/jsp/openAccount.jsp").forward(request, response);
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
