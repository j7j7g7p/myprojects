package com.dream.dp.builder.mail.ex;

import java.util.Date;

abstract public class Builder {
	protected AutoMessage msg;
	
	public Builder(){
		
	}
	/**
	 * 主题零件的建造方法
	 */
	public abstract void buildSubject();
	/**
	 * 邮件内容的建造方法
	 */
	public abstract void buildBody();
	/**
	 * 发件人的建造方法
	 */
	public void buildFrom(String from){
		msg.setFrom(from);
	};
	/**
	 * 收件人的建造方法
	 */
	public void buildTo(String to){
		msg.setTo(to);
	};
	/**
	 * 收件人的建造方法
	 */
	public void buildFromUserPwd(String fromUserPassword){
		msg.setFromUserPassword(fromUserPassword);
	};
	/**
	 * 发件时间的建造方法
	 */
	public void buildSendDate(){
		msg.setSendDate(new Date());
	};
	/**
	 * 邮件完成之后用此方法完成邮件的发送
	 * 相当于产品返还方法
	 */
	public abstract void sendMessage();
}
