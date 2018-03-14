package com.dream.dp.adapter.cube2ball;

public class MagicFinger implements IBall{
	private Cube cube;
	private double r = 0.0;
	private double pi = 3.1415926;
	
	public MagicFinger(Cube cube){
		super();
		this.cube = cube;
		r = cube.getWidth();
	}
	
	@Override
	public double calV() {
		return (3/4)*pi*Math.pow(r, 3);
	}

	@Override
	public double calS() {
		return 4*pi*Math.pow(r, 2);
	}

	@Override
	public double getR() {
		return r;
	}

	@Override
	public void setR(double r) {
		this.r = r;
	}

}
