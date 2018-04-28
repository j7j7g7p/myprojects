package utils;

import java.util.Arrays;

import org.junit.Test;

import sort.change.BubbleSort;
import sort.change.QuickSort;
import sort.insert.InsertSort;

public class SortClient {
	public static void main(String[] args) {
		int[] arr = ArithUtil.getNumberArray(10);
		System.out.println("before sort:"+Arrays.toString(arr));
		BubbleSort.sort(arr);
		System.out.println("after sort:"+Arrays.toString(arr));
	}
	
	@Test
	public void quick() {
		int[] arr = ArithUtil.getNumberArray(5);
		System.out.println("before sort:"+Arrays.toString(arr));
		QuickSort.sort(arr);
		System.out.println("after sort:"+Arrays.toString(arr));
	}
	
	@Test
	public void issert() {
		int[] arr = ArithUtil.getNumberArray(10);
		System.out.println("before sort:"+Arrays.toString(arr));
		InsertSort.sort(arr);
		System.out.println("after sort:"+Arrays.toString(arr));
	}
}
