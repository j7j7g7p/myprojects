package com.dream.dp.singleton.impl;

public class Client {
	public static void main(String[] args) {
		Ehan ehan =Ehan.getInstance();
		Ehan ehan1 =Ehan.getInstance();
		System.out.println(ehan.equals(ehan1));
		LanHan lanhan =LanHan.getInstance();
		LanHan  lanhan1 =LanHan.getInstance();
		System.out.println(lanhan1.equals(lanhan));
	}
}
