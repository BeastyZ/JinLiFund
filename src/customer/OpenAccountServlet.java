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
 * Servlet 开户
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
		Part openAccPhoto = request.getPart("openAccPhoto"); // 获取用户上传的图片
		
		// 判断账户和密码是否有效
		boolean res = AllServices.verifyCusPhonePassword(openAccTel, openAccPassword);
		if(res) {
			// 向数据库写入姓名 身份证 银行卡号 照片
			// 如果用户上传了图片
			if(openAccPhoto.getSubmittedFileName() != "") {
				
				String proPath = this.getServletContext().getRealPath("/"); // 获取项目实际物理地址
				String photoUploadPath = proPath + "images" +  File.separator + "profiles" + File.separator; // 图片实际上传地址
				openAccPhoto.write(photoUploadPath + openAccTel); // 保存到指定路径下
				String photoName =  openAccTel + openAccPhoto.getSubmittedFileName().substring(openAccPhoto.getSubmittedFileName().length() - 4, openAccPhoto.getSubmittedFileName().length());
				
				//写入数据库 并以手机号命名图片
				AllServices.saveOpenAccInfo(openAccTel, openAccName, openAccIDNum, openAccCCNum, photoName);
			}
			else {
				//写入数据库
				AllServices.saveOpenAccInfo(openAccTel, openAccName, openAccIDNum, openAccCCNum, "");
			}
			HttpSession session = request.getSession();
			session.setAttribute("cusPhone", openAccTel + "(已开户)");
			
			request.getRequestDispatcher("/homePage.jsp").forward(request, response);
		}
		else {
			request.setAttribute("openAccFailed", "开户失败，账号或密码错误，请重新尝试！");
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
