package utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

/**
 * Servlet ��ѯ
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String postName = request.getParameter("postName");
		String contentName = request.getParameter("contentName");	
		HttpSession session = request.getSession();
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		session.removeAttribute("fundInfo");
		session.removeAttribute("companyInfo");
		session.removeAttribute("managerInfo");
		
		// ��������
		if("searchFund".equals(postName)) {
			Fund obj = AllServices.getFundByName(contentName);
			if(obj != null) {
				if(obj.getFundType() == 1) {
					obj.setFundTypeToString("����ʽ");
				}
				else {
					obj.setFundTypeToString("���ʽ");
				}
				if(obj.getFundBuyStatus() == 1) {
					obj.setFundBuyStatusToString("����");
				}
				else {
					obj.setFundBuyStatusToString("��ͣ");
				}
				if(obj.getFundSoldStatus() == 1) {
					obj.setFundSoldStatusToString("����");
				}
				else {
					obj.setFundSoldStatusToString("��ͣ");
				}
				
				String text = JSON.toJSONString(obj);
				out.write(text);
				out.flush();
				out.close();
			}
			else {
				out.write("failed");
				out.flush();
				out.close();
			}
		}
		// ��������˾
		else if("searchCompany".equals(postName)) {
			FundCompany obj = AllServices.getComByName(contentName);
			if(obj != null) {
				String text = JSON.toJSONString(obj);
				out.write(text);
				out.flush();
				out.close();
			}
			else {
				out.write("failed");
				out.flush();
				out.close();
			}
		}
		// ����������
		else {
			FundManager obj = AllServices.getmanByName(contentName);
			if(obj != null) {
				String text = JSON.toJSONString(obj);
				out.write(text);
				out.flush();
				out.close();
			}
			else {
				out.write("failed");
				out.flush();
				out.close();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
