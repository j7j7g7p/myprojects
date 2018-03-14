package com.dream.dp.FlyWeightPattern.coffeetable;

public class Client {
	private static Order[] flavors = new Flavor[20];
	private static int orderMade = 0;
	private static FlavorFactory factory = null;
	
	public static void takeOrder(String flavor) {
		flavors[orderMade++] = factory.factory(flavor);
	}
	
	public static void serve() {
		for (int i = 0; i < orderMade; i++) {
			flavors[i].serve(new Table(i));
		}
	}
	
	public static void main(String[] args) throws Exception {
		factory = new FlavorFactory(20);
		takeOrder("Black coffee");
		takeOrder("Capucino");
		takeOrder("Espresso");
		takeOrder("Espresso");
		takeOrder("Capucino");
		takeOrder("Capucino");
		takeOrder("Espresso");
		takeOrder("Black coffee");
		takeOrder("Espresso");
		serve();
	}
}
