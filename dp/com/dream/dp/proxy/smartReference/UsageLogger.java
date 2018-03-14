package com.dream.dp.proxy.smartReference;

public class UsageLogger {
 public String info(String id,String type) {
	 System.out.println("log info:[id=:"+id+",type:"+type+"]");
	 return "yes";
 }
}
