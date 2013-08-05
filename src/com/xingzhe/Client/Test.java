package com.xingzhe.Client;

import com.xingzhe.insertionSort.InsertionSort;

public class Test {
	public static void main(String[] args) {
		InsertionSort insertion = new InsertionSort();
		int[] array = new int[] {133,133,444, 0,9,333, 5, 7, 8, 6,-111 ,-22};
		insertion.sort(array);
		for (int m : array) {
			System.out.println(m);
		}
	}
}
