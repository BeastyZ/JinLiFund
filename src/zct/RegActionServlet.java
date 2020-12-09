package zct;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet 注册处理
 */

public class RegActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 将请求的编码设置为utf-8
		request.setCharacterEncoding("utf-8");
		// 将响应的编码设置为utf-8
		response.setCharacterEncoding("utf-8");
		
		String usernameReg = request.getParameter("usernameReg");
		String passwordReg = request.getParameter("passwordReg");
		String gender = request.getParameter("gender");
		String major = request.getParameter("major");
		String [] hobbies = request.getParameterValues("hobby");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String regDate = sdf.format(new Date());
		
		String ipAddr = request.getLocalAddr();
		
		String allHobbies = "";
		if (hobbies != null)
		{
			for(String hobby:hobbies)
			{
				allHobbies += hobby + " ";
			}
		}
		
		request.setAttribute("username", usernameReg);
		request.setAttribute("password", passwordReg);
		request.setAttribute("major", major);
		request.setAttribute("allHobbies", allHobbies);
		request.setAttribute("regDate", regDate);
		request.setAttribute("ipAddr", ipAddr);
		
		request.getRequestDispatcher("regSuccess.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
