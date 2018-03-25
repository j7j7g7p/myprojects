package com.dream.dp.iterator;

public class Outer {

	public Outer() {
		// TODO Auto-generated constructor stub
	}
	
	public Inner getInner() {
		return (new Inner(this));
	}
	
	public class Inner {
		private Outer outer;
		public Inner(Outer outer) {
			this.outer = outer;
		}
		public void output() {
			System.out.println(123);
		}
		
		public Outer getOutter() {
			return outer;
		}
	}
	public static void main(String[] args) {
		Outer outer = new Outer();
		Inner inner1 = outer.getInner();
		Inner inner2 = outer.getInner();
		System.out.println(inner1==inner2);
		System.out.println(inner1.getOutter() == inner2.getOutter());
	}
}

