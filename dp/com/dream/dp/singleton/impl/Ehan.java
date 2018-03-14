package com.dream.dp.singleton.impl;

public class Ehan {
	 private static final Ehan instance = new Ehan();
	
	 private Ehan(){}
	
	 public static Ehan getInstance() {
	 return instance;
	 }
}
