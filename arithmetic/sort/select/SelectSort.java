package sort.select;

/**
 * 时间复杂度：O(n)~O(n²) -- O(n²)
 * 空间复杂度：O(1)
 */
public class SelectSort{

	public static void sort(int[] arr) {
		int changetimes = 0;
		int comparetimes = 0;
		for(int i =0; i<arr.length; i++) {
			int flag = i;
			for(int j = i;j < arr.length;j++) {
				int min = arr[flag];
				int temp0 = arr[j];
				comparetimes++;
				if (temp0<min) {
					flag = j;
				}
			}
			if (arr[i]>arr[flag]) {
				int temp = arr[i];
				arr[i] = arr[flag];
				arr[flag] = temp;
				changetimes++;
			}
		}
		System.out.println("交换次数："+changetimes);
		System.out.println("比较次数："+comparetimes);
	}

}
