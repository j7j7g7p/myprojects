package com.dream.dp.singleton.example.primarylkey.hasdb;

/**
 * 现在只适应单一主键生成
 * @author 罗尚林
 *
 */
public class KeyGenerater1 {
	private static KeyGenerater1 keyGenerater = new KeyGenerater1();

	private static final int POOL_SIZE = 20;

	private KeyInfo key;

	private KeyGenerater1() {
		key = new KeyInfo(POOL_SIZE);
	}

	public static KeyGenerater1 getInstance() {
		return keyGenerater;
	}

	public int getNextKey() {
		return key.getNextKey();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.println("key"+i+"=" + KeyGenerater1.getInstance().getNextKey());
		}
	}
}
