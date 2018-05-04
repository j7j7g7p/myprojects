package sort.change;

/**
 * 时间复杂度：O(n)~O(n²) -- O(n²)
 * 空间复杂度：O(1)
 */
public class BubbleSort{

	public static void sort(int[] arr) {
		int extimes = 0;
		int cptimes = 0;
		int temp0 = 0;
		int temp1 = 0;
		for(int i =0; i<arr.length-1; i++) {
			for(int j = i+1; j<arr.length;j++ ) {
				temp0 = arr[i];
				temp1 = arr[j];
				if (temp0 < temp1) {
//				if (front > back) {
					arr[i] = temp1;
					arr[j] = temp0;
					extimes++;
				}
				cptimes++;
			}
		}
		System.out.println("交换次数："+extimes);
		System.out.println("比较次数："+cptimes);
	}

}
