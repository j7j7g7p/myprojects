package com.dream.dp.adapter.cube2ball;

public class Cube {
	private double width;
	
	public Cube(double width){
		this.width = width;
	}
	
	public double calV(){
		return Math.pow(width, 3.0);
	}
	public double calS(){
		
		return Math.pow(width, 2.0)*4;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
}
