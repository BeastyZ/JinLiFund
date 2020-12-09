package zct;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * Servlet 二维码生成
 */

public class QrCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QrCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//判断用户是否已经登录
		String username = (String)session.getAttribute("username");
		//判断用户名是否空
		if(username == null) {
			request.setAttribute("infoWrong", "登录后才能进行操作！");
			//转发到登录界面
			request.getRequestDispatcher("homePage.jsp").forward(request, response);
		}
		else {
			try {
				int height = Integer.parseInt(request.getParameter("codeHeight"));
				int width = Integer.parseInt(request.getParameter("codeWidth"));
				String content = request.getParameter("showContent");
				
				// 设置文件类型
				response.setContentType("image/jpeg");

				HashMap hints = new HashMap();
				// 字符编码
				hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
				// 容错级别
				hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
				// 定义二维码对象
				BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, height, width, hints);
				
				//获取项目的实际物理地址
				//String projPath = this.getServletContext().getRealPath("/");
				
				//设置上传路径
				//String uploadPath = projPath + File.separator + "qrCodeImg" + File.separator;
				
				//获取当前时间
				//Date date = new Date();
				
				//当前时间的字符串格式
				//SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
				
				//String filename = sdf.format(date) + ".jpg";
				
				//完整的文件路径和文件名，生成输出流
				//OutputStream os = new FileOutputStream(uploadPath + filename);
				
				OutputStream os = response.getOutputStream();
				
				//输出到指定文件夹
				MatrixToImageWriter.writeToStream(bitMatrix, "jpg", os);
				os.close();
				
				//转发
				//request.setAttribute("qrCode", filename);
				//request.getRequestDispatcher("homePage.jsp").forward(request, response);
				
			} catch (WriterException e) {
				e.printStackTrace();
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
