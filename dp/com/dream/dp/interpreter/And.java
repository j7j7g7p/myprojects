package com.dream.dp.interpreter;

/**
 * 布尔常量
 */
public class And extends Expresstion {
	private Expresstion left,right;
	
	public And(Expresstion left,Expresstion right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean interpret(Context context) {
		return left.interpret(context) && right.interpret(context);
	}

	@Override
	public boolean equals(Object o) {
		if (o!=null && o instanceof And) {
			return this.left.equals(((And)o).left) && this.right.equals(((And)o).right);
		}
		return false;
	}

	@Override
	public int hashcode() {
		return this.toString().hashCode();
	}

	@Override
	public String toString() {
		return "("+left.toString()+" And "+right.toString()+")";
	}

}
