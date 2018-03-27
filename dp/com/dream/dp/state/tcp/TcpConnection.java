package com.dream.dp.state.tcp;

/**
 * @author thinkpad
 *
 */
public class TcpConnection {
	private TcpState state;
	/**
	 * @param state the state to set
	 */
	public void setState(TcpState state) {
		this.state = state;
	}
	/**
	 * operation
	 */
	public void open() {
		state.open();
	}
	
	/**
	 * operation
	 */
	public void close() {
		state.close();
	}
	
	/**
	 * operation
	 */
	public void ackonwledge() {
		state.ackonwledge();
	}
}
