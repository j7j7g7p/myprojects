package com.dream.dp.strategy.ex1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Context {
	private Strategy strategy;
	
	public void contextInterface() {
		strategy.strategyInterface();
	}
	HashMap map = new HashMap<>();
	Set set = new HashSet<>();
	
	
}
