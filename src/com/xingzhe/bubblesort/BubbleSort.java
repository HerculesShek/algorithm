package com.xingzhe.bubblesort;

import com.xingzhe.tool.Tool;

/**
 * 冒泡排序
 * 
 * @author Hersules
 * 
 */
public class BubbleSort {
	public static void sort(int[] a) {
		for (int i = 1; i < a.length - 1; i++) {
			for (int j = a.length - 1; j >= i; j--) {
				if (a[j] < a[j - 1]) {
					Tool.swap(a, j, j - 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 2, 5, 4, 3, 9, 2 };
		BubbleSort.sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
