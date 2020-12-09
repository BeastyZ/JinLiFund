package zct.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet �ϴ��ļ�
 */
@WebServlet("/UploadServlet")
@MultipartConfig()
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ��ǰ��Ŀʵ�ʵ������ַ
		String path = this.getServletContext().getRealPath("/") + File.separator + "photoUploaded" + File.separator;
		// ��request��ȡ�ļ�
		Part part = request.getPart("photo");
		
		//String filename = part.getSubmittedFileName();
		
		// ��ǰʱ��ĺ�������Ϊ�ļ���
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
		String uploadDate = sdf.format(new Date());
		part.write(path + uploadDate + ".jpg");
		
		request.setAttribute("photo", uploadDate + ".jpg");
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
