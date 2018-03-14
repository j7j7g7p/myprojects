package com.dream.dp.observer.ex3;

import java.util.Observable;

public class Watched extends Observable {
	private String data = "";
	
	public Watched() {}

	public boolean changeData(String data) {
		if (data!=null && !this.data.equals(data)) {
			this.data = data;
			super.setChanged();
			super.notifyObservers();
		}
		return true;
	}

	
}
