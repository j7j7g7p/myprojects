package com.dream.dp.memo.white;

/**
 * 备忘录角色
 * @author thinkpad
 *
 */
public class Memento {
	private String state;
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
	}
	/**
	 * Constructor
	 * @param state
	 */
	public Memento(String state) {
		this.state = state;
	}

}
