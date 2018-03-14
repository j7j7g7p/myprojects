package com.dream.dp.FlyWeightPattern.coffeetable;

public class Flavor extends Order {
	private String flavor;
	
	public Flavor(String flavor) {
		this.flavor = flavor;
	}
	@Override
	void serve(Table table) {
		System.out.println("Serve coffee "+flavor+" to Table "+(table.getNumber()+1)+" customer ");
	}

	@Override
	String getFlavor() {
		return this.flavor;
	}

}
