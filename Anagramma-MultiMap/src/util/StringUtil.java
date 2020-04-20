package util;

import java.util.Arrays;

public class StringUtil {
	
	private StringUtil() {
	}

	public static String sortChars (String s) {
		char[] chars = s.toCharArray();
		Arrays.parallelSort(chars);
		return new String (chars);
	}
}
