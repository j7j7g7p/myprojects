package com.dream.dp.singleton.example.mx;

import java.util.Hashtable;

import javax.naming.NamingEnumeration;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.NamingException;



public class SingletonAndMX {
	public static void main(String[] args) throws NamingException {
		Hashtable env = new Hashtable<>();
		env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
		env.put("java.naming.provider.url", "dns://dns01390.ny.jeffcorp.com");
		
		DirContext dirContext = new InitialDirContext(env);
		/**
		 * 读取环境对象的属性
		 */
		Attributes atrs = dirContext.getAttributes("jefcorp.com", new String[]{"MX"});
		for(NamingEnumeration all = atrs.getAll(); all !=null&&all.hasMoreElements();){
			Attribute attribute = (Attribute) all.next();
			NamingEnumeration e = attribute.getAll();
			while (e.hasMoreElements()) {
				String element = e.nextElement().toString();
				System.out.println(element);
			}
		}
	}
}
