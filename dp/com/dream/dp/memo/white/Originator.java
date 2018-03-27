package com.dream.dp.memo.white;

/**
 * 发起人角色
 * @author thinkpad
 *
 */
public class Originator {
	private String state;
	
	public Originator() {
		
	}
	
	/**
	 * 工厂方法，创建备忘录角色
	 * @return
	 */
	public Memento createMemento() {
		return new Memento(state);
	}
	
	/**
	 * 还原发起人的状态
	 * @param memento
	 */
	public void restoreMemento(Memento memento) {
		this.state = memento.getState();
		System.out.println("Current state:"+state);
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
		System.out.println("Current state:"+state);
	}
	
	
}
