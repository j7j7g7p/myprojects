package com.dream.dp.prototype.ex;

public class GoldRingedStaff {
	private float height = 100.0F;
	private float diameter = 10.0F;
	public GoldRingedStaff() {
		super();
	}
	
	public void grow(){
		this.height *= height;
		this.diameter *= diameter;
	}
	public void shrink(){
		this.height /= height;
		this.diameter /= diameter;
	}
	public void move(){
		
	}
	
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getDiameter() {
		return diameter;
	}
	public void setDiameter(float diameter) {
		this.diameter = diameter;
	}
	
}
