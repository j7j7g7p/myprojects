package com.dream.dp.interpreter;

/**
 * 布尔常量
 */
public class Variable extends Expresstion {
	private String name;
	
	public Variable(String value) {
		this.name = value;
	}

	@Override
	public boolean interpret(Context context) {
		return context.lookup(this);
	}

	@Override
	public boolean equals(Object o) {
		if (o!=null && o instanceof Variable) {
			return name.equals(((Variable)o).name);
		}
		return false;
	}

	@Override
	public int hashcode() {
		return this.toString().hashCode();
	}

	@Override
	public String toString() {
		return name;
	}

}
