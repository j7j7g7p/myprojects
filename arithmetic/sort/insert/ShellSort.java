package sort.insert;

/**
 * 时间复杂度：O(n)~O(n*n) -- O(n*n)
 * 空间复杂度：O(1)
 */
public class ShellSort{

	public static void sort(int[] arr) {
		int changetimes = 0;
		int comparetimes = 0;
		for(int i =1; i<arr.length; i++) {
			for(int j = i;j > 0;j--) {
				int temp0 = arr[j];
				int temp1 = arr[j-1];
				comparetimes++;
				if (temp0<temp1) {
					arr[j] = temp1;
					arr[j-1] =temp0;
					changetimes++;
				}else {
					break;
				}
			}
		}
		System.out.println("交换次数："+changetimes);
		System.out.println("比较次数："+comparetimes);
	}

}
