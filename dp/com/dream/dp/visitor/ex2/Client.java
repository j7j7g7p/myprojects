package com.dream.dp.visitor.ex2;

public class Client {
	
	public static void main(String[] args) {
		Equipment eq = new Pc();
		PriceVisitor pv= new PriceVisitor();
		eq.accept(pv);
		System.out.println("Price:"+pv.value());
		System.out.println();
		InventoryVisitor invV = new InventoryVisitor();
		eq.accept(invV);
		System.out.println("Numbers of parts:"+invV.size());
	}
}
