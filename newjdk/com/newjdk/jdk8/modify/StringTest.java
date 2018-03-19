package com.newjdk.jdk8.modify;

import java.util.Arrays;
import java.util.List;

public class StringTest {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("q","e","w");
		String str = String.join(",", "a", "b", "c");
		System.out.println(str);
		str = String.join(",",list);
		System.out.println(str);
	}
}
