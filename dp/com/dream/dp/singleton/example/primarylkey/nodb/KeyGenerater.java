package com.dream.dp.singleton.example.primarylkey.nodb;

public class KeyGenerater {
	private static KeyGenerater keyGenerater = new KeyGenerater();
	
	private int key = 1000;
	
	public static KeyGenerater getInstance() {
		return keyGenerater;
	}
	
	private KeyGenerater(){}
	
	public int getNextKey(){
		return key++;
	}
	public static void main(String[] args) {
		System.out.println("key1="+KeyGenerater.getInstance().getNextKey());
		System.out.println("key2="+KeyGenerater.getInstance().getNextKey());
		System.out.println("key3="+KeyGenerater.getInstance().getNextKey());
	}
}
