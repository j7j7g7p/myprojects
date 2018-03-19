package com.newjdk.jdk8.lambda;

public  class Add{
	private int x = 1;
	private int y = 2;
	public Add(LambdaItf lambTest) {
		System.out.println(lambTest.run(x, y));
	}
	
}
