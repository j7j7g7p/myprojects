package com.dream.dp.decorator.invoice;

import java.text.NumberFormat;

public class OrderLine {
	
	private String itemName;
	private int units;
	private double unitPrice;
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	/**
	 * 单价小计
	 * @return
	 */
	public double getSubTotal() {
		return units*unitPrice;
	}
	/**
	 * 金额格式化
	 */
	public String formatCurrency(double amnt) {
		return NumberFormat.getInstance().format(amnt);
	}
	
	/**
	 * 打印
	 */
	public void printLine() {
		System.out.println(itemName+"\t"+units+"\t"+
					formatCurrency(unitPrice)+"\t"+formatCurrency(getSubTotal()));
	}
	public static void main(String[] args) {
		String format = NumberFormat.getInstance().format(100.12308977);
		System.out.println(format);
	}
}
