package com.dream.dp.chainOfResponsibility.webFilter;

public class Main {

	public static void main(String[] args) {
		String target = "敏感词, <h1>h1标签</h1>,/xl,hello word! this is a song for breken harted!";
		Request request = new Request();
		Response response = new Response();
		request.setReqStr(target);
		FilterChain fc = new FilterChain();
		fc.addFilter(new SensitiveFilter())
		  .addFilter(new TagFilter())
		  .addFilter(new FaceFilter());
		System.out.println(request.getReqStr());
		fc.doFilter(request, response,fc);
		System.out.println(request.getReqStr());
	}

}
