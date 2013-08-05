package com.xingzhe.mergesort;

import java.util.Random;

import com.xingzhe.binarysearch.BinarySearch;

/**
 * 归并排序的实现
 * 
 * @author Hersules
 */
public class MergeSort {
	public static void mergeSort(int[] array, int from, int to) {
		if (from < to) {
			int middle = (int) Math.floor((to + from) / 2);
			mergeSort(array, from, middle);
			mergeSort(array, middle + 1, to);
			merge(array, from, middle, to);
		}
	}

	private static void merge(int[] array, int from, int middle, int to) {
		int[] leftArray = new int[middle - from + 1];
		int[] rightArray = new int[to - middle];
		for (int i = 0; i < leftArray.length; i++) {
			leftArray[i] = array[from + i];
		}
		for (int i = 0; i < rightArray.length; i++) {
			rightArray[i] = array[middle + i + 1];
		}

		int idxL = 0;
		int idxR = 0;
		for (int idx = from; idx <= to; idx++) {
			if (leftArray[idxL] <= rightArray[idxR]) {
				array[idx] = leftArray[idxL];
				idxL++;
				if (idxL == leftArray.length) {
					copyRest(array, idx + 1, rightArray, idxR);
					return;
				}
			} else {
				array[idx] = rightArray[idxR];
				idxR++;
				if (idxR == rightArray.length) {
					copyRest(array, idx + 1, leftArray, idxL);
					return;
				}
			}
		}
	}

	/**
	 * 把oriArr数组中的内容从oIdex开始复制到desArr中，从dIdx开始复制
	 */
	private static void copyRest(int[] desArr, int dIdx, int[] oriArr, int oIdx) {
		for (; oIdx < oriArr.length; oIdx++) {
			desArr[dIdx] = oriArr[oIdx];
			dIdx++;
		}
	}

	public static void main(String[] args) {
		f2();
	}

	public static void f2() {
		int[] a = { 4, 7, 8, 9, 1 };
		MergeSort.mergeSort(a, 0, a.length - 1);
		int res = BinarySearch.recursiveBinarySerarch(a, 9, 0, a.length - 1);
		System.out.println(res);
	}

	public static void f() {
		int[] a = new int[100000000];
		Random r = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(Integer.MAX_VALUE);
		}
		long f = System.currentTimeMillis();
		MergeSort.mergeSort(a, 0, a.length - 1);
		long t = System.currentTimeMillis();
		System.out.println((t - f) / 1000);
	}
}
