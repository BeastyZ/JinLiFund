package zct;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import zct.user.UserService;

/**
 * Servlet �û�ע�ᣬ���������ݿ�
 */
@MultipartConfig()

public class RegSaveToDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ������ı�������Ϊutf-8
		request.setCharacterEncoding("utf-8");
		// ����Ӧ�ı�������Ϊutf-8
		response.setCharacterEncoding("utf-8");
				
		//��ȡ����
		String usernameReg = request.getParameter("usernameReg"); 
		String passwordReg = request.getParameter("passwordReg"); 
		String gender = request.getParameter("gender"); 
		String major = request.getParameter("major");
		String [] hobbies = request.getParameterValues("hobby");
		Part part = request.getPart("photo");//��ȡ�û��ϴ���ͼƬ
		
		//����ͼƬ
		String proPath = this.getServletContext().getRealPath("/"); //��ȡ��Ŀʵ�������ַ
		String photoUploadPath = proPath + File.separator + "photoUploaded" +  File.separator; //ͼƬʵ���ϴ���ַ
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");//�ļ����в��ܺ���ð�ţ����Բ��ܲ���yyyy-MM-dd HH:mm:ss:S�ĸ�ʽ
		String regDate = sdf.format(new Date());
		String fileName = regDate + ".jpg";
		part.write(photoUploadPath + fileName); //���浽ָ��·����
		
		//ȷ���û���ע��ʱ��
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		regDate = sdf.format(new Date());
		
		//��ȡ�û���IP��ַ
		String ipAddr = request.getLocalAddr();
		
		//������תΪ�ַ���
		StringBuffer userHobbies = new StringBuffer();
		if(hobbies == null || hobbies.length == 0) {
			userHobbies.append("��");
		}
		else {
			for(String s:hobbies) {
				userHobbies.append(s).append(" ");
			}
		}
		
		//���û�����д�����ݿ�
		UserService.addUser(usernameReg, passwordReg, major, gender, fileName, userHobbies.toString(), regDate, ipAddr);

		//������
		request.setAttribute("username", usernameReg);
		//ת������¼����
		request.getRequestDispatcher("homePage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
