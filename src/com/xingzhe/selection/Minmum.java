package com.xingzhe.selection;

public class Minmum {
	/**
	 * 选择问题之选取最小值
	 * @param a 待选的数组
	 * @return
	 */
	public static int minmum(int[] a) {
		int min = a[0];
		for (int i = 1; i < a.length; i++) {
			if (min > a[i])
				min = a[i];
		}
		return min;
	}
	
}
