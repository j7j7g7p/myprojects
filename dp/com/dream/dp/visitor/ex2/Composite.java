package com.dream.dp.visitor.ex2;

import java.util.Iterator;
import java.util.Vector;

public class Composite extends Equipment {
	private Vector parts = new Vector<>();
	
	public double price() {
		double total = 0;
		Iterator it = parts.iterator();
		while (it.hasNext()) {
			total += ((Equipment)it.next()).price();
		}
		return total;
	}

	@Override
	public void accept(Visitor vi) {
		Iterator it = parts.iterator();
		while (it.hasNext()) {
			((Equipment)it.next()).accept(vi);
		}
	}
	
	public void add(Equipment e) {
		parts.add(e);
	}
}
