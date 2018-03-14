package com.dream.dp.chainOfResponsibility.webFilter;

public class TagFilter implements Filter {

	@Override
	public void doFilter(Request request ,Response response,FilterChain filterChain) {
		System.out.println("TagFilter-request");
		request.setReqStr(request.getReqStr().replace("<", "[").replace(">", "]"));
		filterChain.doFilter(request, response, filterChain);
		System.out.println("TagFilter-"+response.getRespStr());
	}

}
