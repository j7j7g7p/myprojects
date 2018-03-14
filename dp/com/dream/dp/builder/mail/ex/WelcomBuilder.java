package com.dream.dp.builder.mail.ex;

public class WelcomBuilder extends Builder {
	private static final String subject=
			"welcome!";
	public WelcomBuilder(){
		msg = new WelcomeMessage();
	}
	
	@Override
	public void buildSubject() {
		msg.setSubject(subject);
	}

	@Override
	public void buildBody() {
		msg.setBody("this is welcome body!");
	}

	@Override
	public void sendMessage() {
		msg.send();
	}

}
