package com.dream.dp.mediator;

public class Collegue1 extends Collegue {

	public Collegue1(Mediator mediator) {
		super(mediator);
	}
	
	@Override
	public void doAction() {
		System.out.println("This is action from Collegue1");
	}

}
