package com.newjdk.jdk8.compile;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
 //???????????
public class ParameterNames {
	public static void main(String[] args){
		try {
			Method method = ParameterNames.class.getMethod( "test", String.class );
			for( final Parameter parameter: method.getParameters() ) {
				System.out.println( "Parameter: " + parameter.getName() );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void test(String para) {
		System.out.println("test parametername");
	}
}
