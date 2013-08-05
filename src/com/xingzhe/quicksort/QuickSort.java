package com.xingzhe.quicksort;

import com.xingzhe.too.Tool;

public class QuickSort {
	public static void quick_sort(int[] a, int p, int r) {
		if (p < r) {
			int q = partion(a, p, r);
			quick_sort(a, p, q - 1);
			quick_sort(a, q + 1, r);
		}
	}

	private static int partion(int[] a, int p, int r) {
		int x = a[r];
		int i = p - 1;
		for (int j = p; j <= r - 1; j++) {
			if (a[j] <= x) {
				i++;
				Tool.swap(a, i, j);
			}
		}
		Tool.swap(a, i + 1, r);
		return i + 1;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 32, 25, 34, 95, 34, 173, 23, 12, 33, 142, 53, 32, 34, 34, 123,
				34, 15, 435, 12, 43, 305, 23, 14, 1243, 123 };
		quick_sort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
