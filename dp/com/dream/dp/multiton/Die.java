package com.dream.dp.multiton;

import java.util.Date;
import java.util.Random;

public class Die {
	private static Die die1 = new Die();
	private static Die die2 = new Die();
	private Die(){}
	
	public static Die getInstance(int num) throws Exception {
		switch (num) {
		case 1:
			return die1;
		case 2:
			return die2;
		default:
			throw new Exception("no such die"+num);
		}
	}
	public synchronized int dice() {
//		Date date=new Date();
//		Random random = new Random(date.getTime());
//		int value = Math.abs(random.nextInt());
		Random random = new Random();
		int value = random.nextInt(10000);
		System.out.println(value);
		value = value % 6;
		value +=1;
		return value;
	}
	public static void main(String[] args) throws Exception {
		System.out.println(Die.getInstance(1).dice());
		System.out.println(Die.getInstance(2).dice());
	}
}
