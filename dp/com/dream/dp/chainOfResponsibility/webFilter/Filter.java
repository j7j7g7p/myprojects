package com.dream.dp.chainOfResponsibility.webFilter;

public interface Filter {
	void doFilter(Request request ,Response response,FilterChain filterChain);
}
