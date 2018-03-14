package com.dream.dp.prototype.ex;

public class TheGreatestSage {
	private Monkey monkey = new Monkey();
	
	public void change(){
		Monkey monkeyCopy;
		for(int i=1;i<2000;i++){}
		monkeyCopy = (Monkey) monkey.clone();
		System.out.println(monkeyCopy);
		System.out.println(monkeyCopy == monkey);
		System.out.println(monkeyCopy.getStaff() == monkey.getStaff());
	}
	public static void main(String[] args) {
		TheGreatestSage sage = new TheGreatestSage();
		sage.change();
	}
}
