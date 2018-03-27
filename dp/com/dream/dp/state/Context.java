package com.dream.dp.state;

/**
 * 减少条件转移的好方式
 * 代码的重构可以参考该模式
 * @author thinkpad
 *
 */
public class Context {
	private State state;
	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}
	/**
	 * operation
	 */
	public void sampleOperation() {
		state.sampleOperation();
	}
}
