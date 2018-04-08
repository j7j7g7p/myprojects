package com.dream.dp.interpreter;

/**
 * 布尔常量
 */
public class Constant extends Expresstion {
	private boolean value;
	
	public boolean isValue() {
		return value;
	}
	
	public Constant(boolean value) {
		this.value = value;
	}

	@Override
	public boolean interpret(Context context) {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (o!=null && o instanceof Constant) {
			return value==((Constant)o).isValue();
		}
		return false;
	}

	@Override
	public int hashcode() {
		return this.toString().hashCode();
	}

	@Override
	public String toString() {
		return (new Boolean(value)).toString();
	}

}
