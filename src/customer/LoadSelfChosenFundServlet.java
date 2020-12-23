package customer;

/*
 *  �����û�����ѡ����
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.AllServices;
import utils.Fund;
import utils.SelfChosenDto;

/**
 * Servlet implementation class LoadSelfChosenFundServlet
 */
@WebServlet("/customer/LoadSelfChosenFundServlet")
public class LoadSelfChosenFundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String cusPhone = ((String) session.getAttribute("cusPhone")).substring(0, 11);

		List<SelfChosenDto> selfChosens = AllServices.loadAllSelfChosenInfo(cusPhone);
		
		for (SelfChosenDto selfChosenDto : selfChosens) {
			if (selfChosenDto.getFundInvestType() == 1) {
				selfChosenDto.setFundInvestTypeToString("��Ʊ��");
			} else if (selfChosenDto.getFundInvestType() == 2) {
				selfChosenDto.setFundInvestTypeToString("ծȯ��");
			} else if (selfChosenDto.getFundInvestType() == 3) {
				selfChosenDto.setFundInvestTypeToString("ָ����");
			} else {
				selfChosenDto.setFundInvestTypeToString("�����");
			}
		}

		session.setAttribute("selfChosens", selfChosens);
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
