package com.xingzhe.binarysearch;
/**
 * ���ֲ��ҵ�����ʵ�ַ�ʽ
 * @author Herules
 *
 */
public class BinarySearch {
	public static int iterativeBinarySearch(int[] array, int v, int low,
			int high) {
		while (low <= high) {
			int mid = (int) Math.floor((low + high) / 2);
			if (v == array[mid]) {
				return mid;
			} else if (v > array[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static int recursiveBinarySerarch(int[] array, int v, int low,
			int high) {
		if (low > high)
			return -1;
		int mid = (int) Math.floor((low + high) / 2);
		if (v == array[mid])
			return mid;
		else if (v > array[mid])
			return recursiveBinarySerarch(array, v, mid + 1, high);
		else
			return recursiveBinarySerarch(array, v, low, mid - 1);
	}
}
