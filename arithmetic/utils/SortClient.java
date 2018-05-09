package utils;

import java.util.Arrays;

import org.junit.Test;

import sort.change.BubbleSort;
import sort.change.QuickSort;
import sort.insert.InsertSort;
import sort.insert.ShellSort;
import sort.merge.MergeSort;
import sort.select.SelectSort;

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
	
	@Test
	public void shellSort() {
//		int[] arr = ArithUtil.getNumberArray(10);
		int[] arr = {9,1,5,8,3,7,4,6,2};
		System.out.println("before sort:"+Arrays.toString(arr));
		ShellSort.sort(arr);
		System.out.println("after sort:"+Arrays.toString(arr));
	}
	
	@Test
	public void selectSort() {
		int[] arr = ArithUtil.getNumberArray(10);
		System.out.println("before sort:"+Arrays.toString(arr));
		SelectSort.sort(arr);
		System.out.println("after sort:"+Arrays.toString(arr));
	}

	@Test
	public void mergeSort() {
		int[] arr = ArithUtil.getNumberArray(10);
		System.out.println("before sort:"+Arrays.toString(arr));
		MergeSort.sort(arr);
		System.out.println("after sort:"+Arrays.toString(arr));
	}
}
