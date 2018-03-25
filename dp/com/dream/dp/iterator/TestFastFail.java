package com.dream.dp.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class TestFastFail {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("111");
		list.add("112");
		list.add("113");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String s = (String) iterator.next();
			list.add("114");
			System.out.println(s);
		}
	}
}
