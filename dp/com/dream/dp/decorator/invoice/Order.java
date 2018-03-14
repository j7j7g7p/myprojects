package com.dream.dp.decorator.invoice;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Vector;

public abstract class Order {
	private OrderLine lnkOrderLine;
	protected String customerName;
	protected Date saleDate;
	protected Vector<OrderLine> items = new Vector<>(10);
	public void print() {
		for (int i = 0; i < items.size(); i++) {
			OrderLine item = (OrderLine) items.get(i);
			item.printLine();
		}
	}
	public void addItem(OrderLine item) {
		items.add(item);
	}
	public double getGrandTotal() {
		double amnt = 0.0D;
		for(OrderLine item:items) {
			amnt += item.getSubTotal();
		}
		return amnt;
	}
	/**
	 * 金额格式化
	 */
	public String formatCurrency(double amnt) {
		return NumberFormat.getInstance().format(amnt);
	}
	public void deleteItem(OrderLine item) {
		items.remove(item);
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	
}
