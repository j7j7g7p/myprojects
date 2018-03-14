package com.dream.dp.proxy.smartReference;

public class Client {
	public static void main(String[] args) {
		Proxy searcher = new Proxy();
		String doSearch = searcher.doSearch("userid", "1");
		System.out.println(doSearch);
	}
}
