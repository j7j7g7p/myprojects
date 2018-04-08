package com.dream.dp.visitor.ex2;

public class Case extends Equipment{
	@Override
	public double price() {
		return 100;
	}

	@Override
	public void accept(Visitor vi) {
		System.out.println("Case is been visited");
		vi.visitCase(this);
	}
}
