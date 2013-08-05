package com.xingzhe.permutation;

import java.util.ArrayList;

public class Permutation {
	public static void print() {
		int[] a = new int[] { 1, 2, 3 };
		ArrayList<int[]> index = new ArrayList<int[]>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					int[] temp = new int[3];
					temp[0] = i;
					temp[1] = j;
					temp[2] = k;
					index.add(temp);
				}
			}
		}
		for (int m = 0; m < index.size(); m++) {
			int[] arr = index.get(m);
			for (int i = 0; i < a.length; i++) {
				swap(a, i, arr[i]);
			}
			printArr(a);
			a = new int[] { 1, 2, 3 };
		}
	}

	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
	}

	public static void swap(int[] arr, int a, int b) {
		if (a == b)
			return;
		arr[a] += arr[b];
		arr[b] = arr[a] - arr[b];
		arr[a] = arr[a] - arr[b];
	}

	public static void main(String[] args) {
		print();
	}
}
