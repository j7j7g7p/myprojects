package com.dream.dp.chainOfResponsibility;

public class TagFilter implements Filter {

	@Override
	public String doFilter(String target) {
		//链式编程
		return target.replace("<", "[")
					 .replace(">", "]");
	}

}
