package com.dream.dp.state.tcp;

public interface TcpState {
	void open();
	void close();
	void ackonwledge();
}
