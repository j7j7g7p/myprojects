package com.dream.dp.interpreter;

/**
 * 布尔常量
 */
public class Or extends Expresstion {
	private Expresstion left,right;
	
	public Or(Expresstion left,Expresstion right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean interpret(Context context) {
		return left.interpret(context) || right.interpret(context);
	}

	@Override
	public boolean equals(Object o) {
		if (o!=null && o instanceof Or) {
			return this.left.equals(((Or)o).left) && this.right.equals(((Or)o).right);
		}
		return false;
	}

	@Override
	public int hashcode() {
		return this.toString().hashCode();
	}

	@Override
	public String toString() {
		return "("+left.toString()+" Or "+right.toString()+")";
	}

}
