package com.dream.dp.FlyWeightPattern.coffee;

public class FlavorFactory {
	private Order[] orders = null;
	private int orderMade = 0;
	private int orderTotal = 0;
	
	public FlavorFactory(int flavorNumber) throws Exception {
		if (flavorNumber<=0) {
			throw new Exception("No Flavor");
		}
		this.orders = new Flavor[flavorNumber];
	}
	
	public Order factory(String flavor) {
		if (orderMade>0) {
			for (int i = 0; i < orderMade; i++) {
				if (flavor.equals(orders[i].getFlavor())) {					
					return orders[i];
				}
			}
		}
		Order order = new Flavor(flavor);
		orders[orderMade] = order;
		setOrderTotal(getOrderTotal() + 1);
		return orders[orderMade++];
	}

	public int getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	} 
}
