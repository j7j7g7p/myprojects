package com.dream.dp.visitor.ex2;

public class Cpu extends Equipment {
	public double price() {
		return 200;
	}

	@Override
	public void accept(Visitor vi) {
		System.out.println("Cpu is been visited");
		vi.visitCpu(this);
	}
}
