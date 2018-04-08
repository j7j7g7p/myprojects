package com.dream.dp.visitor.ex2;

public class MainBoard extends Equipment {
	public double price() {
		return 500;
	}

	@Override
	public void accept(Visitor vi) {
		System.out.println("MainBoard is been visited");
		vi.visitMainBoard(this);
	}
}
