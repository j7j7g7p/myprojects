package com.dream.dp.mediator;

public abstract class Collegue {
	private Mediator mediator;
	
	public Collegue(Mediator mediator) {
		this.mediator = mediator;
	}
	
	public abstract void doAction();

	public Mediator getMediator() {
		return mediator;
	}
}
