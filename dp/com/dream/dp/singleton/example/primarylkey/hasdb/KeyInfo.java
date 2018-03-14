package com.dream.dp.singleton.example.primarylkey.hasdb;

public class KeyInfo {
	private int minKey;
	private int maxKey;
	private int nextKey;
	private int poolSize;
	private String keyName;
	
	public KeyInfo(int poolSize) {
		this.poolSize = poolSize;
		retriveFromDB();
	}
	
	public KeyInfo(int poolSize, String keyName) {
		this.poolSize = poolSize;
		this.keyName = keyName;
		retriveFromDB();
	}

	public int getNextKey() {
		if (nextKey > maxKey) {
			retriveFromDB();
		}
		return minKey++;
	}
	
	private void retriveFromDB() {
		int keyFromDB = getNextKeyFromDB();
		maxKey = keyFromDB;
		minKey = keyFromDB - poolSize + 1;
		nextKey = minKey;
	}
	
	private int getNextKeyFromDB() {
		//update db
		// getNextKeyFromDB
		
		return 1000;
	}
}
