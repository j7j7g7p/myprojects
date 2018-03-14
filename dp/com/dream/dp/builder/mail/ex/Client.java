package com.dream.dp.builder.mail.ex;

import com.base.web.AppConfig;

public class Client {
	public static void main(String[] args) {
		Builder builder = new WelcomBuilder();
		Builder builder1 = new GoodByeBuilder();
		Director director = new Director(builder1);
		director.contructor("1039466810@qq.com", "lucifer_lsl@163.com",
				AppConfig.getStringPro("pkWeyd"));
		builder1.sendMessage();
	}
}
