package com.dream.dp.FlyWeightPattern.coffee;

public class Flavor extends Order {
	private String flavor;
	
	public Flavor(String flavor) {
		this.flavor = flavor;
	}
	@Override
	void serve() {
		System.out.println("Serve coffee "+flavor+" to customer!");
	}

	@Override
	String getFlavor() {
		return this.flavor;
	}

}
