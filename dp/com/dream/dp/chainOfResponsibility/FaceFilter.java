package com.dream.dp.chainOfResponsibility;

public class FaceFilter implements Filter {

	@Override
	public String doFilter(String target) {
		String expression = "/xl";
		return target.replace(expression, ">>::<<");
	}

}
