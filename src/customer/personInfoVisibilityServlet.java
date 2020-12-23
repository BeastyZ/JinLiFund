package customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.AllServices;
import utils.Customer;

/**
 * Servlet implementation class personInfoVisibilityServlet
 */
@WebServlet("/customer/personInfoVisibilityServlet")
public class personInfoVisibilityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		
		HttpSession session = request.getSession();
		String cusPhone = ((String)session.getAttribute("cusPhone")).substring(0, 11);
		
		// �����ݿ��л�ȡ���û���������Ϣ
		Customer exactCus = AllServices.findExactCus(cusPhone);

		if("����".equals(flag)) {
			// �ж��û��Ƿ񿪻�
			if(exactCus.getCusStatus() == 1) {
				
				// ���û������ݽ�����˽������	
				String tel = exactCus.getCusPhone();
				String idNum = exactCus.getCusIDNum();
				String creditNum = exactCus.getCusCCNum();
				
				tel = tel.substring(0, 3) + "****" + tel.substring(7, 11);
				idNum = idNum.substring(0, 6) + "********" + idNum.substring(14, 18);
				creditNum = creditNum.substring(0, 6) + "********" + creditNum.substring(14, 18);
				
				exactCus.setCusPhone(tel);
				exactCus.setCusIDNum(idNum);
				exactCus.setCusCCNum(creditNum);
				
				flag = "��ʾ";
			}
		}
		else {
			flag = "����";
		}
		
		request.setAttribute("customer", exactCus);
		
		// �����û��ѹ����������
		int fundNum = AllServices.calFundNumForCus(cusPhone.substring(0, 11));
		// �����û��Ļ����ʲ��ܶ�
		String fundAssetsTotal = String.format("%.2f", AllServices.calFundAssetsTotalForCus(cusPhone.substring(0, 11)));
		
		request.setAttribute("fundNum", fundNum);
		request.setAttribute("fundTotal", fundAssetsTotal);
		request.setAttribute("flag", flag);
				
		// ת��
		request.getRequestDispatcher("/jsp/personalCenter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
