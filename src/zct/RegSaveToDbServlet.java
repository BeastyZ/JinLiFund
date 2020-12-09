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
 * Servlet 用户注册，保存至数据库
 */
@MultipartConfig()

public class RegSaveToDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 将请求的编码设置为utf-8
		request.setCharacterEncoding("utf-8");
		// 将响应的编码设置为utf-8
		response.setCharacterEncoding("utf-8");
				
		//获取数据
		String usernameReg = request.getParameter("usernameReg"); 
		String passwordReg = request.getParameter("passwordReg"); 
		String gender = request.getParameter("gender"); 
		String major = request.getParameter("major");
		String [] hobbies = request.getParameterValues("hobby");
		Part part = request.getPart("photo");//获取用户上传的图片
		
		//保存图片
		String proPath = this.getServletContext().getRealPath("/"); //获取项目实际物理地址
		String photoUploadPath = proPath + File.separator + "photoUploaded" +  File.separator; //图片实际上传地址
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");//文件名中不能含有冒号，所以不能采用yyyy-MM-dd HH:mm:ss:S的格式
		String regDate = sdf.format(new Date());
		String fileName = regDate + ".jpg";
		part.write(photoUploadPath + fileName); //保存到指定路径下
		
		//确定用户的注册时间
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		regDate = sdf.format(new Date());
		
		//获取用户的IP地址
		String ipAddr = request.getLocalAddr();
		
		//将数组转为字符串
		StringBuffer userHobbies = new StringBuffer();
		if(hobbies == null || hobbies.length == 0) {
			userHobbies.append("无");
		}
		else {
			for(String s:hobbies) {
				userHobbies.append(s).append(" ");
			}
		}
		
		//将用户数据写入数据库
		UserService.addUser(usernameReg, passwordReg, major, gender, fileName, userHobbies.toString(), regDate, ipAddr);

		//输出结果
		request.setAttribute("username", usernameReg);
		//转发到登录界面
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
