package com.dream.dp.visitor.ex2;

public class Pc extends Composite {
	public Pc() {
		super.add(new IntegreteBoard());
		super.add(new HardDisc());
		super.add(new Case());
	}
	
	@Override
	public void accept(Visitor vi) {
		System.out.println("Pc is been visited");
		super.accept(vi);
	}
}
