package com.dream.dp.chainOfResponsibility.webFilter;

public class FaceFilter implements Filter {

	@Override
	public void doFilter(Request request, Response response,FilterChain filterChain) {
		System.out.println("FaceFilter-request");
		String expression = "/xl";
		request.setReqStr(request.getReqStr().replace(expression, ">>::<<"));
		filterChain.doFilter(request, response, filterChain);
		System.out.println("FaceFilter-"+response.getRespStr());
	}

}
