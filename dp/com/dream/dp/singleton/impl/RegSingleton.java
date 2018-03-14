package com.dream.dp.singleton.impl;

import java.util.HashMap;

public class RegSingleton {
	static HashMap m_registry = new HashMap();
	
	static{
		RegSingleton regSingleton = new RegSingleton();
		m_registry.put(regSingleton.getClass().getName(), regSingleton);
	}
	/**
	 * 受保护的构造子
	 */
	protected RegSingleton(){}
	
	static public RegSingleton getInsatance(String name){
		if (name == null) 
			name =  RegSingleton.class.getName();
		if (m_registry.get(name) == null){
			try {
				m_registry.put(name, Class.forName(name).newInstance());
			} catch (Exception e) {
				System.out.println("error happens!");
			}
			
		}
		return (RegSingleton) m_registry.get(name);
	}
	
	public static void main(String[] args) {
		System.out.println(RegSingleton.class.getName());
		System.out.println(RegSingleton.getInsatance("com.dream.dp.singleton.RegSingleton") ==
				RegSingleton.getInsatance("com.dream.dp.singleton.RegSingleton"));
	}
}
