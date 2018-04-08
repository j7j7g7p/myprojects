package com.dream.dp.visitor.ex2;

import java.util.Vector;

public class InventoryVisitor implements Visitor{
	private Vector inv;
	
	public InventoryVisitor() {
		this.inv = new Vector<>(10, 5);
	}
	
	public int size() {
		return inv.size();
	}
	
	@Override
	public void visitHardDisc(HardDisc e) {
		inv.addElement(e); 
	}

	@Override
	public void visitMainBoard(MainBoard e) {
		inv.addElement(e);
	}

	@Override
	public void visitCpu(Cpu e) {
		inv.addElement(e);
	}

	@Override
	public void visitPc(Pc e) {
		inv.addElement(e);
	}

	@Override
	public void visitCase(Case e) {
		inv.addElement(e);
	}

	@Override
	public void visitIntegreteBoard(IntegreteBoard e) {
		inv.addElement(e);
	}
}
