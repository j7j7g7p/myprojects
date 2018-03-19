package com.newjdk.jdk8.lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class LambdaTest {
	public static void main(String[] args) {
//		testLambda();
//		testLambda2();
//		testLambda3();
//		testLambda6();
//		testLambda7();
//		testLambda8();
		testLambda9();
		
	}
	
   /**
	* 1 Lambda表达式和函数式接口
	* (params) -> expression
	* (params) -> statement
	* (params) -> { statements }
	*/
	public static void testLambda() {
		List<String> asList = Arrays.asList("q","e","w");
		asList.forEach(e -> System.out.println(e));
	}
	
	public static void testLambda2() {
		new Thread( () -> run() ).start();
	}
	
	public static void testLambda3() {
		new Add((int x ,int y) -> x*y);
		new Add((int x ,int y) -> run(x, y));
		new Add((int x ,int y) -> run(x, y));
	}
	
	@org.junit.Test
	public void testLambda4() {
		List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		features.forEach(n -> System.out.println(n));
		features.forEach(n -> {System.out.println(n);});
		 
		// 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
		// 看起来像C++的作用域解析运算符
		features.forEach(System.out::println);
	}
	
	@org.junit.Test
	public void testLambda5() {
		//java8添加了java.util.function包支持函数式编程
		List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		features.forEach(n -> System.out.println(n));
		 
		// 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
		// 看起来像C++的作用域解析运算符
		features.forEach(System.out::println);
	}
	public static void testLambda6() {
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		 
//	    System.out.println("Languages which starts with J :");
//	    filter(languages, (str)->str.toString().startsWith("J"));
//	 
//	    System.out.println("Languages which ends with a ");
//	    filter(languages, (str)->str.toString().endsWith("a"));
//	 
	    System.out.println("Print all languages :");
	    filter2(languages, (str)->true);
//	 
//	    System.out.println("Print no language : ");
//	    filter(languages, (str)->false);
//	 
//	    System.out.println("Print language whose length greater than 4:");
//	    filter(languages, (str)->str.toString().length() > 4);
	}
	
	public static void filter(List<String> names, Predicate<String> condition) {
	    for(String name: names)  {
	        if(condition.test(name)) {
	            System.out.println(name + " ");
	        }
	    }
	}
	
	public static void testLambda7() {
		// 甚至可以用and()、or()和xor()逻辑函数来合并Predicate，
		// 例如要找到所有以J开始，长度为四个字母的名字，你可以合并两个Predicate并传入
		List<String> names = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp", "JLisp");
		Predicate<String> startsWithJ = (n) -> n.startsWith("J");
		Predicate<String> fourLetterLong = (n) -> n.length() == 4;
		names.stream()
		    .filter(startsWithJ.and(fourLetterLong))
		    .forEach((n) -> System.out.print("nName, which starts with 'J' and four letter long is : " + n));
	}
	
	public static void testLambda8() {
		// 不使用lambda表达式为每个订单加上12%的税
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//		for (Integer cost : costBeforeTax) {
//		    double price = cost + .12*cost;
//		    System.out.println(price);
//		}
		 
		// 使用lambda表达式
		costBeforeTax.stream().map((cost) -> cost + .12*cost).forEach(System.out::println);
	}

	public static void testLambda10() {
		// 为每个订单加上12%的税
		// 老方法：
//		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//		double total = 0;
//		for (Integer cost : costBeforeTax) {
//		    double price = cost + .12*cost;
//		    total = total + price;
//		}
//		System.out.println("Total : " + total);
		 
		// 新方法：
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		double bill = costBeforeTax.stream().map((cost) -> cost + .12*cost).reduce((sum, cost) -> sum + cost).get();
		System.out.println("Total : " + bill);
	}
	
	public static void testLambda11() {
		// 创建一个字符串列表，每个字符串长度大于2
		List<String> strList = Arrays.asList("Java", "Scala", "C++", "Haskell", "L", "JLisp");
		List<String> filtered = strList.stream().filter(x -> x.length()> 2).collect(Collectors.toList());
		System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
	}
	
	
	public static void testLambda12() {
		// 将字符串换成大写并用逗号链接起来
		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
		String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
		System.out.println(G7Countries);
	}
	
	public static void testLambda13() {
		// 用所有不同的数字创建一个正方形列表
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		List<Integer> distinct = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
		System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
	}
	
	public static void testLambda9() {
		//获取数字的个数、最小值、最大值、总和以及平均值
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("Highest prime number in List : " + stats.getMax());
		System.out.println("Lowest prime number in List : " + stats.getMin());
		System.out.println("Sum of all prime numbers : " + stats.getSum());
		System.out.println("Average of all prime numbers : " + stats.getAverage());
	}
	public static void filter2(List<String> names, Predicate condition) {
		names.stream().filter(name -> condition.test(name)).forEach(name -> {
			 System.out.println(name+" ");
		});
//	    names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
//	        System.out.println(name + " ");
//	    });
	}
	
	public static void run() {
		while (true) {
			System.out.println("In Java8, Lambda expression rocks !!");
		}
	}
	public static int run(int x,int y) {
		return (x+y)*10;
	}
}
