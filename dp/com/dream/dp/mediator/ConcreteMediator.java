package com.dream.dp.mediator;

public class ConcreteMediator extends Mediator {
	private Collegue1 collegue1;
	private Collegue2 collegue2;

	@Override
	public void colleagueChanged(Collegue c) {
		collegue1.doAction();
		collegue2.doAction();
	}

	public void createCollegue() {
		collegue1 = new Collegue1(this);
		collegue2 = new Collegue2(this);
	}
	
	public Collegue1 getCollegue1() {
		return collegue1;
	}

	public Collegue2 getCollegue2() {
		return collegue2;
	}
	

}
