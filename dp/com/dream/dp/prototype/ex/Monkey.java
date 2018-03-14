package com.dream.dp.prototype.ex;

import java.util.Date;

public class Monkey implements Cloneable{
	private int height;
	private int width;
	private GoldRingedStaff staff;
	private Date birthDate;
	
	public Monkey(){
		this.birthDate = new Date();
		this.staff = new GoldRingedStaff();
		this.height = 200;
		this.width = 30;
	}
	/**
	 * 克隆
	 * @return
	 */
	
	public Object clone() {
		Monkey monkey =null;
		try {
			monkey = (Monkey) super.clone();
			return monkey;
		} catch (Exception e) {
			System.out.println("clone failed!");
		}finally{
			return monkey;
		}
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public GoldRingedStaff getStaff() {
		return staff;
	}
	public void setStaff(GoldRingedStaff staff) {
		this.staff = staff;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "Monkey [height=" + height + ", width=" + width + ", staff="
				+ staff + ", birthDate=" + birthDate + "]";
	}
	
}
