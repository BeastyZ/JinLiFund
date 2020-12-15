package utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet 登录验证码生成
 */

@WebServlet(name = "CheckCode", urlPatterns = { "/CheckCodeServlet" })

public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckCodeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpeg");
		// 在内存中创建一张图片
		BufferedImage img = new BufferedImage(70, 30, BufferedImage.TYPE_INT_BGR);
		Graphics g = img.getGraphics();
		// 设置背景
		g.setColor(Color.red);
		g.fillRect(0, 0, 70, 30);

		g.setColor(Color.white);
		g.setFont(new Font("华文行楷", Font.ITALIC, 24));

		Random random = new Random();
		String checkCode = String.valueOf(random.nextInt(8999) + 1000);
		g.drawString(checkCode, 10, 25);

		// 获取session对象
		HttpSession session = request.getSession();
		session.setAttribute("checkCode", checkCode);

		// 获取response的输出流
		OutputStream os = response.getOutputStream();
		ImageIO.write(img, "jpg", os);
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
