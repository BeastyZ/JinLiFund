package customer;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import utils.AllServices;
import utils.Customer;

/**
 * Servlet 处理用户个人信息修改
 */
@WebServlet("/customer/ModifyPersonInfoServlet")
@MultipartConfig()
public class ModifyPersonInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String newCCNumConfirm = request.getParameter("newCCNumConfirm");
		String newCCNum = request.getParameter("newCCNum");
		
		HttpSession session = request.getSession();
		String cusPhone = ((String)session.getAttribute("cusPhone")).substring(0, 11);
		
		// 获取该用户的所有原始信息
		Customer cus = AllServices.findExactCus(cusPhone);
		
		// 判断用户输入的信息是否与原信息一致
		if(cus.getCusCCNum().equals(newCCNum)) {
			request.setAttribute("tipInfo", "所填信息与原始信息一致，修改失败！");
		}
		// 判断用户两次输入是否一致
		else if(!newCCNum.equals(newCCNumConfirm)){
			request.setAttribute("tipInfo", "两次所填信息不一致，修改失败！");
		}
		else {
			// 根据原先手机号对用户信息进行修改
			boolean modifyFlag = AllServices.updateCusTelCCNum(cusPhone, newCCNum);
			if(modifyFlag) {
				request.setAttribute("tipInfo", "修改成功！");
			}
			else {
				request.setAttribute("tipInfo", "修改失败！");
			}
		}

		request.getRequestDispatcher("/customer/PersonalCenterActionServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
