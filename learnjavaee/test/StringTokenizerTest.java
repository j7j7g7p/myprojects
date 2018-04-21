package test;

import java.util.StringTokenizer;

/**
 * 字符分解器对象
 * @author A170227
 *
 */
public class StringTokenizerTest {
	public static void main(String[] args) {
		StringTokenizer tokenizer = new StringTokenizer("girl-boy", "-");
		String nextToken = tokenizer.nextToken();
		System.out.println(nextToken);
		nextToken = tokenizer.nextToken();
		System.out.println(nextToken);
	}
}
