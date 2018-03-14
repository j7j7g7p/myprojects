package com.dream.dp.builder.mail;

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
import javax.mail.internet.MimeMessage.RecipientType;

import com.base.web.AppConfig;

/**
 * 更好体验建造模式的性质外部化
 * 
 * @author 罗尚林
 * 
 */

public class MessageSender {
	public static void main(String[] args) {
		// STMP 服务器地址
		String smtpHost = "smtp.163.com";
		// 发送者的地址
		String from = "lucifer_lsl@163.com";
		// 收信者的地址
		String to = "1039466810@qq.com";
		// 使用properties 装属性
		Properties properties = new Properties();
		properties.put("mail.smtp.host", smtpHost);
		properties.put("mail.smtp.starttls.enable", "true");// 使用 STARTTLS安全连接
		properties.put("mail.smtp.port", "25"); // google使用465或587端口
		/**
		 * 没有会导致的异常553 authentication is required
		 */
		properties.put("mail.smtp.auth", "true"); // 使用验证
		
		Session session = Session.getInstance(properties, new MyAuthenticator(
				from, AppConfig.getStringPro("pkWeyd")));

		try {
			InternetAddress[] address = { new InternetAddress(to) };
			// 创建message对象
			Message message = new MimeMessage(session);
			// 建造发件人地址零件
			message.setFrom(new InternetAddress(from));
			// 建造收件人地址零件
			message.setRecipients(RecipientType.TO, address);
			// 建造主题零件
			message.setSubject("Hello World!");
			// 建造发送时间零件
			message.setSentDate(new Date());
			// 建造内容零件
			message.setText("hello \n have fun!");
			// 发送邮件，相当于返回产品
			// 发送邮件，相当于返回产品
			Transport transport = session.getTransport("smtp");
			transport.connect(smtpHost, "", AppConfig.getStringPro("pkWeyd"));
			transport.send(message, message.getRecipients(RecipientType.TO));
			System.out.println("message sent already!");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}

class MyAuthenticator extends Authenticator {
	String userName = "";
	String password = "";

	public MyAuthenticator() {

	}

	public MyAuthenticator(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(userName, password);
	}
}
