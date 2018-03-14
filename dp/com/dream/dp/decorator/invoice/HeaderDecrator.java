package com.dream.dp.decorator.invoice;

public class HeaderDecrator extends OrderDecrator{
	protected Order order;
	public HeaderDecrator(Order order) {
		super(order);
	}
	public void print() {
		this.printHeader();
		super.order.print();
	}
	private void printHeader() {
		System.out.println("----打印头部----");
	}
}
