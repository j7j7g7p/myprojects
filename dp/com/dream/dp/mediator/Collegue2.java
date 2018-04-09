package com.dream.dp.mediator;

public class Collegue2 extends Collegue {

	public Collegue2(Mediator mediator) {
		super(mediator);
	}
	
	@Override
	public void doAction() {
		System.out.println("This is action from Collegue2");
	}

}
