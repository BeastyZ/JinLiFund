package utils;

import java.io.IOException;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
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

import org.apache.commons.mail.HtmlEmail;

/**
 * Servlet ʹ��465�˿�ͨ�����䷢����֤��
 */

@WebServlet(name="SendCheckCode", urlPatterns={ "/SendCheckCodeServlet"})

public class SendCheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// ��ȡ�û�����������ַ
			String emailAddress = request.getParameter("emailAddress");

			Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
            //�����ʼ��Ự����
            Properties props = new Properties();
            //����ķ��ͷ�������ַ
            props.setProperty("mail.smtp.host", "smtp.qq.com");
            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            //���䷢�ͷ������˿�,��������Ϊ465�˿�
            props.setProperty("mail.smtp.port", "465");
            props.setProperty("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.auth", "true");
            
            final String username = "beery-hunter@qq.com";
            final String password = "cieknhaykwnxbefh";
            //��ȡ������Ự,���������ڲ���ķ�ʽ,�������������û�����������Ȩ��jvm
            Session session = Session.getDefaultInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            //ͨ���Ự,�õ�һ���ʼ�,���ڷ���
            Message msg = new MimeMessage(session);
            //���÷�����
            msg.setFrom(new InternetAddress("beery-hunter@qq.com"));
            //�����ռ���,toΪ�ռ���,ccΪ����,bccΪ����
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAddress, false));
            //msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(to, false));
            //msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(to, false));
            msg.setSubject("�����������̳�  �һ�����");
            //�����ʼ���Ϣ
            msg.setText("�𾴵��û�����, ����������:" + "12345");
            //���÷��͵�����
            msg.setSentDate(new Date());
            
            //����Transport��send����ȥ�����ʼ�
            Transport.send(msg);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			// ������ת�ء��һ����롱����
			response.sendRedirect("findPassword.jsp");
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
