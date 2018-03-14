package com.dream.dp.observer.ex3;

import java.util.Observable;
import java.util.Observer;

public class Watcher implements Observer {
	private Observable o = null;
	
	public Watcher(Observable o) {
		this.o = o;
		o.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("update self...");
	}

}
