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
 * Servlet �����û�������Ϣ�޸�
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
		
		// ��ȡ���û�������ԭʼ��Ϣ
		Customer cus = AllServices.findExactCus(cusPhone);
		
		// �ж��û��������Ϣ�Ƿ���ԭ��Ϣһ��
		if(cus.getCusCCNum().equals(newCCNum)) {
			request.setAttribute("tipInfo", "������Ϣ��ԭʼ��Ϣһ�£��޸�ʧ�ܣ�");
		}
		// �ж��û����������Ƿ�һ��
		else if(!newCCNum.equals(newCCNumConfirm)){
			request.setAttribute("tipInfo", "����������Ϣ��һ�£��޸�ʧ�ܣ�");
		}
		else {
			// ����ԭ���ֻ��Ŷ��û���Ϣ�����޸�
			boolean modifyFlag = AllServices.updateCusTelCCNum(cusPhone, newCCNum);
			if(modifyFlag) {
				request.setAttribute("tipInfo", "�޸ĳɹ���");
			}
			else {
				request.setAttribute("tipInfo", "�޸�ʧ�ܣ�");
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
