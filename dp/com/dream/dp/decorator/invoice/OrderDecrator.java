package com.dream.dp.decorator.invoice;

public abstract class OrderDecrator extends Order{
	protected Order order;
	public OrderDecrator(Order order) {
		this.order = order;
		this.setSaleDate(order.getSaleDate());
		this.setCustomerName(order.getCustomerName());
	}
	public void print() {
		super.print();
	}
}
