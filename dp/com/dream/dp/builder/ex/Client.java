package com.dream.dp.builder.ex;

public class Client {
	public static void main(String[] args) {
		Director director = new Director();
		Builder builder = director.contructor();
		Product product = builder.retrieveResult();
		product.product();
	}
}
