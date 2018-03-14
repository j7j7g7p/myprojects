package com.dream.dp.decorator.invoice;

import java.util.Date;

public class Client {
	public static void main(String[] args) {
		Order order = new SaleOrder();
		order.setSaleDate(new Date());
		order.setCustomerName("customername");
		OrderLine orderLine1 = new OrderLine();
		orderLine1.setItemName("oil  fee1 ");
		orderLine1.setUnitPrice(345.5);
		orderLine1.setUnits(2);
		order.addItem(orderLine1);
		OrderLine orderLine2 = new OrderLine();
		orderLine2.setItemName("oil  fee2 ");
		orderLine2.setUnitPrice(345.6);
		orderLine2.setUnits(2);
		order.addItem(orderLine2);
		order = new HeaderDecrator(new FooterDecrator(order));
		order.print();
	}
}
