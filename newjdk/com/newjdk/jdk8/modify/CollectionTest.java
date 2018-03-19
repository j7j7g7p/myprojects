package com.newjdk.jdk8.modify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class CollectionTest {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Jq1","Je","w");
		System.out.println((list instanceof ArrayList));
		list = new ArrayList<>();
		System.out.println((list instanceof ArrayList));
		list.add("Jq1");
		list.add("Je");
		list.add("w");
		//集合可以使用foreach
		for (String string : list) {
			System.out.println(string);
		}
		//removeif
		System.out.println(String.join("-", list));
		Predicate<String> predicate = (s) -> s.startsWith("J");
		list.removeIf(predicate);
//		list.removeIf(Predicate<T>);
		System.out.println(String.join("-", list));
		
//		List<String> strings = new ArrayList<>();
//	    strings.add("ab");
//	    strings.add("Jc");
//	    strings.add("bc");
//	    strings.add("cd");
//	    Predicate<String> predicate = (s) -> s.startsWith("J"); // 这里单独定义了过滤器
//	    strings.removeIf(predicate);                            // 过滤掉以"a"开头的元素
//	    strings.forEach(s -> System.out.println(s)); 
	}
}
