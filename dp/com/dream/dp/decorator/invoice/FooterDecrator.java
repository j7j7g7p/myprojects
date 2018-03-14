package com.dream.dp.decorator.invoice;

public class FooterDecrator extends OrderDecrator{
	protected Order order;
	public FooterDecrator(Order order) {
		super(order);
	}
	public void print() {
		super.order.print();
		this.printFooter();
	}
	private void printFooter() {
		System.out.println("----打印底部----");
	}
}
