package com.dream.dp.builder.mail.ex;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import com.base.web.AppConfig;

/**
 * @author 罗尚林
 * 
 */
abstract public class AutoMessage {
	protected String subject = "";
	protected String body = "";
	protected String from = "";
	protected String fromUserPassword = "";
	protected String to = "";
	protected Date sendDate = null;

	public AutoMessage() {
	}

	public void send() {

		// STMP 服务器地址
		String smtpHost = "smtp.163.com";
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
				from, fromUserPassword));

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
			Transport transport = session.getTransport("smtp");
			transport.connect(smtpHost, "", AppConfig.getStringPro("pkWeyd"));
			transport.send(message, message.getRecipients(RecipientType.TO));
			System.out.println("message sent already!");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getForm() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getFromUserPassword() {
		return fromUserPassword;
	}

	public void setFromUserPassword(String fromUserPassword) {
		this.fromUserPassword = fromUserPassword;
	}
}
