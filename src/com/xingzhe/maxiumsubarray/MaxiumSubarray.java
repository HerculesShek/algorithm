package com.xingzhe.maxiumsubarray;

public class MaxiumSubarray {
	public static void printMaxSubarrayInfo(int[] a) {
		int max_sum = a[0];
		int max_temp = a[0];
		int start_index = -1;
		int end_index = 0;
		for (int i = 1; i < a.length; i++) {
			max_temp += a[i];
			if (max_temp < 0) {
				max_temp = 0;
				start_index = i;
			} else if (max_sum < max_temp) {
				max_sum = max_temp;
				end_index = i;
			}
		}
		System.out.println("from:"+start_index);
		System.out.println("to:"+end_index);
		System.out.println("max sum:"+max_sum);
	}
	public static void main(String[] args) {
		int[] a = {1,5,2,6,2,1,-52,2,6,2,5,4,12,-62,2,1,-61,5,1,56,-12,156,1,126,1,5};
		MaxiumSubarray.printMaxSubarrayInfo(a);
	}
}
