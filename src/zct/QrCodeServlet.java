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
 * Servlet ��ά������
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
		//�ж��û��Ƿ��Ѿ���¼
		String username = (String)session.getAttribute("username");
		//�ж��û����Ƿ��
		if(username == null) {
			request.setAttribute("infoWrong", "��¼����ܽ��в�����");
			//ת������¼����
			request.getRequestDispatcher("homePage.jsp").forward(request, response);
		}
		else {
			try {
				int height = Integer.parseInt(request.getParameter("codeHeight"));
				int width = Integer.parseInt(request.getParameter("codeWidth"));
				String content = request.getParameter("showContent");
				
				// �����ļ�����
				response.setContentType("image/jpeg");

				HashMap hints = new HashMap();
				// �ַ�����
				hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
				// �ݴ���
				hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
				// �����ά�����
				BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, height, width, hints);
				
				//��ȡ��Ŀ��ʵ�������ַ
				//String projPath = this.getServletContext().getRealPath("/");
				
				//�����ϴ�·��
				//String uploadPath = projPath + File.separator + "qrCodeImg" + File.separator;
				
				//��ȡ��ǰʱ��
				//Date date = new Date();
				
				//��ǰʱ����ַ�����ʽ
				//SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
				
				//String filename = sdf.format(date) + ".jpg";
				
				//�������ļ�·�����ļ��������������
				//OutputStream os = new FileOutputStream(uploadPath + filename);
				
				OutputStream os = response.getOutputStream();
				
				//�����ָ���ļ���
				MatrixToImageWriter.writeToStream(bitMatrix, "jpg", os);
				os.close();
				
				//ת��
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
