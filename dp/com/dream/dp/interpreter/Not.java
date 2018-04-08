package com.dream.dp.interpreter;

/**
 * 布尔常量
 */
public class Not extends Expresstion {
	private Expresstion exp;
	
	public Not(Expresstion exp) {
		this.exp = exp;
	}

	@Override
	public boolean interpret(Context context) {
		return !exp.interpret(context);
	}

	@Override
	public boolean equals(Object o) {
		if (o!=null && o instanceof Not) {
			return this.exp.equals(((Not)o).exp);
		}
		return false;
	}

	@Override
	public int hashcode() {
		return this.toString().hashCode();
	}

	@Override
	public String toString() {
		return "(Not "+exp.toString()+")";
	}

}
