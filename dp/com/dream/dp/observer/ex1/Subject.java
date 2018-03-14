package com.dream.dp.observer.ex1;

public interface Subject {

	/**
	 * 添加一个观察者对象 
	 */
	public void attach(Observer observer);
	
	/**
	 * 删除一个观察者对象
	 */
	public void detach(Observer observer);
	
	/**
	 * 通知所有登记过的观察者对象
	 */
	void notifyObserver();
}
