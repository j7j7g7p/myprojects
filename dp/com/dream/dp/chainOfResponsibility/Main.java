package com.dream.dp.chainOfResponsibility;

import com.dream.dp.chainOfResponsibility.FilterChain;

public class Main {

	public static void main(String[] args) {
		String target = "敏感词, <h1>h1标签</h1>,/xl,hello word! this is a song for breken harted!";
		FilterChain fc = new FilterChain();
		fc.addFilter(new SensitiveFilter())
		  .addFilter(new TagFilter())
		  .addFilter(new FaceFilter());
		String result = fc.doFilter(target);
		System.out.println(result);
	}

}
