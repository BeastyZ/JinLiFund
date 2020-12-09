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
 * Servlet 上传文件
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
		// 获取当前项目实际的物理地址
		String path = this.getServletContext().getRealPath("/") + File.separator + "photoUploaded" + File.separator;
		// 从request获取文件
		Part part = request.getPart("photo");
		
		//String filename = part.getSubmittedFileName();
		
		// 当前时间的毫秒数作为文件名
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
