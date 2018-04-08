package com.dream.dp.visitor.ex2;

public class IntegreteBoard extends Composite {
	
	public IntegreteBoard() {
		super.add(new MainBoard());
		super.add(new Cpu());
	}
	
	@Override
	public void accept(Visitor vi) {
		System.out.println("IntegreteBoard is been visited");
		super.accept(vi);
	}
}
