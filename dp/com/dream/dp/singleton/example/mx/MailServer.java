package com.dream.dp.singleton.example.mx;
/**
 * 存储SMTP服务器的信息
 * @author 罗尚林
 *
 */
public class MailServer {
	private int priority;// 优先级

	private String server;// 服务器名

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}
}
