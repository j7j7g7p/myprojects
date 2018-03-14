package com.test;

public class Test {

	public static void main(String[] args){
		getSanJiao(5);
	}

	public static void getSanJiao(int degree) {
		for (int i = 1; i <= degree; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(getNum(j, i)+" ");
			}
			System.out.println();
		}
	}
	
	public static int getNum(int column,int row) {
		if (column==1) {
			return 1;
		}else if (column==row) {
			return 1;
		}else {
			return getNum(column-1, row-1)+getNum(column, row-1);
		}
	}
}
