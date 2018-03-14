package com.dream.dp.builder.mail.ex;

public class Director {
	Builder builder;

	/**
	 * contructor
	 */
	public Director(Builder builder) {
		this.builder = builder;
	}
	/**
	 * 建造方法，负责调用各种零件
	 */
	public void contructor(String toAddress,String fromAddress,String fromUserPassword){
		this.builder.buildSubject();
		this.builder.buildBody();
		this.builder.buildSendDate();
		this.builder.buildFrom(fromAddress);
		this.builder.buildTo(toAddress);
		this.builder.buildFromUserPwd(fromUserPassword);
	}
}
