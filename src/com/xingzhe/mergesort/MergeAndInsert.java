package com.xingzhe.mergesort;
/**
 * 其实该算法表明了分治策略的本质
 * @author Hersules
 *
 */
public class MergeAndInsert {

	public static void mergeAndInsertSort(int[] array, int from, int to) {
		if (to - from + 1 <= lg(array.length)) {
			insertionSort(array, from, to);
		} else {
			int middle = (int) Math.floor((to + from) / 2);
			mergeAndInsertSort(array, from, middle);
			mergeAndInsertSort(array, middle + 1, to);
			merge(array, from, middle, to);
		}
	}

	private static void insertionSort(int[] array, int from, int to) {
		for (int i = from + 1; i <= to; i++) {
			int key = array[i];
			int j = i - 1;
			while (j >= from && key < array[j]) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
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

	private static double lg(double n) {
		return Math.log(n) / Math.log(2);
	}

	public static void main(String[] args) {
		int[] a = {777777, 4, 7, 8, 77,5,69,486,159,124,136,187,182,183,194,172,14,168,14,139,137,129,184,468,9, 1,5,4,34,3,4,5,56,5,6,43,5,354,3,42,43,23,23,1,23123 };
		MergeAndInsert.mergeAndInsertSort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}

