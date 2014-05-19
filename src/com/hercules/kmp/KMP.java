package com.hercules.kmp;

// KMP 算法的只寻找一次的版本
public class KMP {
	public static int KMPMatcher(String t, String p) {
		int targetLength = t.length(), patternLength = p.length();
		int r[] = computePrefix(p);
		int pattern_index = 0; 
		int target_index = 0;
		while (pattern_index < patternLength && target_index < targetLength) { // 这个是只找一个的版本
			if (t.charAt(target_index) == p.charAt(pattern_index)) {
				++target_index;
				++pattern_index;
			} else if (pattern_index == 0) { // 没有匹配的字符
				++target_index;
			} else {
				pattern_index = r[pattern_index - 1] + 1; // 至移动pattern的索引
			}
		}
		if (pattern_index == patternLength) {
			return target_index - pattern_index;
		} else {
			return -1;
		}
	}

	public static int[] computePrefix(String p) {
		int m = p.length();
		int r[] = new int[m];
		r[0] = -1; // 第一个的值绝对是-1
		int index = -1; // 是一个值，将来要作为 r[i]的值，意义是“匹配到了哪里”
		for (int q = 1; q < m; q++) { // 太精妙的写法了
			while (index >= 0 && p.charAt(index + 1) != p.charAt(q)) // 说明已经有匹配的了
				index = r[index];
			if (p.charAt(index + 1) == p.charAt(q))
				index++;
			r[q] = index;
		}
		return r;
	}

	public static void main(String[] args) {
		String s = "abaabcaba";
		int a[] = computePrefix(s);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+", ");
		}
		System.out.println();
		String t = "BBC ABCDAB ABCDABCDABDE", p = "ABCDABD";
		System.out.println(KMPMatcher(t, p) + " : "
				+ t.charAt(KMPMatcher(t, p)));
		
		System.out.println(KMPMatcher("abcab", "ab"));
	}
}
