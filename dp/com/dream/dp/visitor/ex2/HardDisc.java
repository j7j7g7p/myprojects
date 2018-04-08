package com.dream.dp.visitor.ex2;

public class HardDisc extends Equipment {
	public double price() {
		return 300;
	}

	@Override
	public void accept(Visitor vi) {
		System.out.println("HardDisc is been visited");
		vi.visitHardDisc(this);
	}
}
