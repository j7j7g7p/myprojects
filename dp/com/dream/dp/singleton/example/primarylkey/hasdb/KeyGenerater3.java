package com.dream.dp.singleton.example.primarylkey.hasdb;

import java.util.HashMap;

/**
 * 适应duo主键生成
 * 多例模式
 * 关联依赖keyInfo
 * @author 罗尚林
 *
 */
public class KeyGenerater3 {

	private static final int POOL_SIZE = 20;
	//构造一个带指定初始容量和默认加载因子 (0.75) 的空 HashMap。
	private static HashMap<String, KeyGenerater3> keyGens = new HashMap<>(10);

	private	KeyInfo key;
	
	private KeyGenerater3() {
	}
	
	private KeyGenerater3(String keyName) {
		key = new KeyInfo(POOL_SIZE, keyName);
	}

	public static KeyGenerater3 getInstance(String keyName) {
		KeyGenerater3 keyGenerater;
		if (keyGens.containsKey(keyName)) {
			return keyGens.get(keyName);
		}else {
			keyGenerater = new KeyGenerater3(keyName);
			keyGens.put(keyName, keyGenerater);
		}
		return keyGenerater;
	}

	public int getNextKey() {
		return key.getNextKey();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 40; i++) {
			System.out.println("key"+i+"=" + KeyGenerater3.getInstance("ii"+i).getNextKey());
		}
		System.out.println(211);
		System.out.println("key=" + KeyGenerater3.getInstance("iii").getNextKey());
	}
}
