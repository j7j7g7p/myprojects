package com.dream.dp.builder.mail.ex;

public class GoodByeBuilder extends Builder {
	private static final String subject=
			"goodbye,wait for your next time!";
	/**
	 * 构造子
	 */
	public GoodByeBuilder() {
		msg = new GoodByeMessage();
	}
	@Override
	public void buildSubject() {
		msg.setSubject(subject);
	}

	@Override
	public void buildBody() {
		msg.setBody("thank for your visiting!");
	}
	@Override
	public void sendMessage() {
		msg.send();
	}

}
