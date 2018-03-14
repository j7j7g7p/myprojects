package com.dream.dp.chainOfResponsibility;

public class SensitiveFilter implements Filter {

	@Override
	public String doFilter(String target) {
		String sensitive = "敏感";
		String harmony = "和谐";
		return target.replace(sensitive, harmony);
	}

}
