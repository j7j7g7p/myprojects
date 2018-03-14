package com.dream.dp.singleton.impl;

public class LanHan {
	private static LanHan lanHan;
	
	private LanHan(){}
	
	public static LanHan getInstance() {
		synchronized (LanHan.class) {
			if (lanHan == null) {
				lanHan = new LanHan();
			}
		}
		return lanHan;
	}
	
}
