package com.dream.dp.multiton;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * 提供对货币数字的支持
 * Map instanceMap = new HashMap(11);
 * 多例模式
 * @author 罗尚林
 *
 */
public class NumberFormatTest {
	
	public static void displayNumber(Double amount,Locale currentLocale){
		NumberFormat formatter = NumberFormat.getPercentInstance(currentLocale);
		String amountOut = formatter.format(amount);
		System.out.println(amountOut+"  "+currentLocale.toString());
	}
	public static void main(String[] args) {
		Double amount = new Double(1234567.89);
		displayNumber(amount, new Locale("en", "US"));
		displayNumber(amount, new Locale("de", "DE"));
		displayNumber(amount, new Locale("fr", "FR"));
	}
}
