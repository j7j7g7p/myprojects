package com.dream.dp.interpreter;

public class Test {
	public static void main(String[] args) {
		try {
			Context cxt = new Context();
			Variable x = new Variable("x");
			Variable y = new Variable("y");
			Constant c = new Constant(true);
			cxt.assign(x, false);
			cxt.assign(y, true);
			Expresstion exp = new Or(new And(c, x),new And(y, new Not(x)));
			System.out.println(x.toString() +"="+x.interpret(cxt));
			System.out.println(y.toString() +"="+y.interpret(cxt));
			System.out.println(exp.toString()+"="+exp.interpret(cxt));
		} catch (Exception e) {
		}
	}
}

