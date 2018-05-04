package sort.insert;

import java.util.Arrays;

/**
 * 时间复杂度：O(n)~O(n²) -- O(n¹·³)
 * 空间复杂度：O(1)
 */

/**
 * Shell排序是DL. Shell于1959年针对直接插入排序算法改进提出的，属于插入排序的范畴，是对直接插入排序算法的改进。
 * 直接插入排序在基本有序时效率较高，并且在序列规模不是很大时效率也很高，Shell排序就是针对这两点进行改进。
 * 核心思想是：待排序列有n个元素，先取一个小于n的整数h1作为第一个增量，把待排序列以间隔h1分成若干子序列，子序列内使用插入排序；然后取第二个增量h2(<
 * h1)， 重复上述的划分和排序，直至所取的增量hl = 1 (h1 > h2 > ... > hl)。
 * 
 * @author A170227 Shell排序是一种不稳定的排序算法
 * 
 * 插入排序的改进，通过增量（一般为0.5*length）将整个数组若干个子子序列，子序列之间进行插入排序，大大提高了排序的效率
 */
public class ShellSort {

	public static void sort(int[] array) {
		int increment = array.length;
		do {
			increment = increment / 2; // 增量序列
			for (int i = increment; i < array.length; i++) {
				if (array[i] < array[i - increment]) {
					Integer guard = array[i];
					int j;
					for (j = i - increment; (j >= 0) && (guard < array[j]); j -= increment) // 记录后移，查找插入位置
					{
						array[j + increment] = array[j];
					}
					array[j + increment] = guard; // 插入
				}
				System.out.println("sort:"+Arrays.toString(array));
			}
		} while (increment > 1);
	}
}
