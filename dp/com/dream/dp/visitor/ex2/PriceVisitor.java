package com.dream.dp.visitor.ex2;

public class PriceVisitor implements Visitor{
	private float total;
	
	public PriceVisitor() {
		this.total = 0;
	}
	
	public float value() {
		return total;
	}
	
	@Override
	public void visitHardDisc(HardDisc e) {
		total += e.price();		 
	}

	@Override
	public void visitMainBoard(MainBoard e) {
		total += e.price();
	}

	@Override
	public void visitCpu(Cpu e) {
		total += e.price();
	}

	@Override
	public void visitPc(Pc e) {
		total += e.price();
	}

	@Override
	public void visitCase(Case e) {
		total += e.price();
	}

	@Override
	public void visitIntegreteBoard(IntegreteBoard e) {
		total += e.price();
	}
}
