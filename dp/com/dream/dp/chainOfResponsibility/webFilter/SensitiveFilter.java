package com.dream.dp.chainOfResponsibility.webFilter;

public class SensitiveFilter implements Filter {

	@Override
	public void doFilter(Request request ,Response response,FilterChain filterChain) {
		String sensitive = "敏感";
		String harmony = "和谐";
		System.out.println("SensitiveFilter-request");
		request.setReqStr(request.getReqStr().replace(sensitive, harmony));
		filterChain.doFilter(request, response, filterChain);
		System.out.println("SensitiveFilter-"+response.getRespStr());
	}

}
