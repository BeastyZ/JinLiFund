package customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Security;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.AllServices;

/**
 * Servlet 使用465端口通过邮箱发送验证码
 */

@WebServlet(name="SendCheckCode", urlPatterns={ "/customer/SendCheckCodeServlet"})

public class SendCheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String telephone = request.getParameter("telephone");
			String emailAddress = request.getParameter("emailAddress");
			
			// 在数据库中查找有无此人
			boolean res = AllServices.findOne(telephone);
			
			if(res) {
				
				Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	            //设置邮件会话参数
	            Properties props = new Properties();
	            //邮箱的发送服务器地址
	            props.setProperty("mail.smtp.host", "smtp.qq.com");
	            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
	            props.setProperty("mail.smtp.socketFactory.fallback", "false");
	            //邮箱发送服务器端口,这里设置为465端口
	            props.setProperty("mail.smtp.port", "465");
	            props.setProperty("mail.smtp.socketFactory.port", "465");
	            props.put("mail.smtp.auth", "true");
	            
	            final String username = "beery-hunter@qq.com";
	            final String password = "cieknhaykwnxbefh";
	            //获取到邮箱会话,利用匿名内部类的方式,将发送者邮箱用户名和密码授权给jvm
	            Session session = Session.getDefaultInstance(props, new Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, password);
	                }
	            });
	            //通过会话,得到一个邮件,用于发送
	            Message msg = new MimeMessage(session);
	            //设置发件人
	            msg.setFrom(new InternetAddress("beery-hunter@qq.com"));
	            //设置收件人,to为收件人,cc为抄送,bcc为密送
	            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAddress, false));
	            //msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(to, false));
	            //msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(to, false));
	            msg.setSubject("锦鲤金服基金商城  验证码");
	            
	            String letterPool = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	            Random random = new Random();
	            StringBuffer letterChosen = new StringBuffer();
	            for (int i = 0; i < 6; i++) {
	                int number = random.nextInt(52);// [0,51)
	                letterChosen.append(letterPool.charAt(number));
	            }
	            
	            //设置邮件消息
	            msg.setText("尊敬的用户您好, 您的验证码是:" + letterChosen.toString());
	            //设置发送的日期
	            msg.setSentDate(new Date());
	            
	            //调用Transport的send方法去发送邮件
	            Transport.send(msg);
	            
	            // 将验证码保存至session
	            HttpSession httpSession = request.getSession();
	            httpSession.setAttribute("resetPasswordCheckCode", letterChosen.toString());
	            // 将手机号存至session中，用于后续的密码更新
	            httpSession.setAttribute("resetPasswordTel", telephone);
				
	            PrintWriter out = response.getWriter();
				out.write("allValid");
				out.flush();
				out.close();
			}
			else {
				PrintWriter out = response.getWriter();
				out.write("invalid");
				out.flush();
				out.close();
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
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
