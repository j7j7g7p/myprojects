package com.dream.dp.singleton.example.primarylkey.hasdb;

import java.util.HashMap;

/**
 * 适应duo主键生成
 * @author 罗尚林
 *
 */
public class KeyGenerater2 {
	private static KeyGenerater2 keyGenerater = new KeyGenerater2();

	private static final int POOL_SIZE = 20;
	
	private HashMap keyList = new HashMap<>(10);

	private KeyGenerater2() {
	}

	public static KeyGenerater2 getInstance() {
		return keyGenerater;
	}

	public int getNextKey(String keyName) {
		KeyInfo key;
		if (keyList.containsKey(keyName)) {
			key = (KeyInfo) keyList.get(keyName);
			System.out.println("key found!");
		}
		else {
			key = new KeyInfo(POOL_SIZE,keyName);
			keyList.put(keyName, key);
			System.out.println("create new keyInfo");
		}
		return key.getNextKey();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.println("key"+i+"=" + KeyGenerater2.getInstance().getNextKey("zhujian"));
		}
	}
}
