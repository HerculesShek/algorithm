package com.xingzhe.too;

public class Tool {
	public static void swap(int[] a, int i, int j) {
		if (i == j)
			return;
		a[i] += a[j];
		a[j] = a[i] - a[j];
		a[i] -= a[j];
	}
}
