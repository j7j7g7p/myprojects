package utils;

import java.util.Random;

public class ArithUtil {
	
	/**
	 * 生成随机数组
	 * @param length
	 * @return
	 */
	public static int[]  getNumberArray(int length) {
		if (length<=0) {
			throw new IllegalStateException("数组长度不可为空!");
		}
		int arr[] = new int[length];
		Random random = new Random();
		for(int i =0; i<length ;i++) {
			arr[i] =  random.nextInt(100);
		}
		return arr;
	}
	
}
