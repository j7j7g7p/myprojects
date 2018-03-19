package com.newjdk.jdk8.genericsJudge;

public class Value<T> {
	public static<T> T defaultValue(){
		return null;
	}
	public T getOrDefault(T value,T def) {
		return (value != null)? value:def;
	}
	
	public static void main(String[] args) {
		Value<String> value = new Value<>();
		String orDefault = value.getOrDefault("hello", Value.defaultValue());//以前的方式Value.< String >defaultValue()
		System.out.println(orDefault);
	}
}
