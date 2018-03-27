package com.dream.dp.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class TestFastFail {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("111");
		list.add("112");
		list.add("113");
		ListIterator<String> listIterator = list.listIterator();
		while (listIterator.hasNext()) {
			String s = (String) listIterator.next();
			if ("113".equals(s)) {				
				listIterator.add("114");
			}
		}
		
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String s = (String) iterator.next();
			System.out.println(s);
		}
	}
}
