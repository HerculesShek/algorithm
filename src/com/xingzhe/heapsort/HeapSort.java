package com.xingzhe.heapsort;

/**
 * 堆排序 数组形式表示的时候，开始位置从1计数，所以会有标量的转换
 * 
 * @author Hercules
 */
public class HeapSort {
	private static int heap_size;
	public static void heap_sort(int[] a) {
		heap_size = a.length;
		build_max_heap(a);
		for (int i = a.length; i >= 2; i--) {
			swap(a, 0, i - 1);
			heap_size--;
			max_heapify(a, 0);
		}
	}

	// 建立一个最大堆,采用自底向上的方式把数组array转换为最大堆
	public static void build_max_heap(int[] a) {
		int from = (int) Math.floor(heap_size / 2);
		for (int i = from; i >= 1; i--) {
			max_heapify(a, i - 1);
		}
	}

	/*
	 * 让堆a中的i结点上的值“堆化”——就是让i结点上的值是以i为根节点的子树的最大值
	 */
	public static void max_heapify(int[] a, int i) {
		int l = 2 * (i + 1) - 1;
		int r = 2 * (i + 1);
		int largest = i;
		if (l < heap_size && a[l] > a[largest]) {
			largest = l;
		}
		if (r < heap_size && a[r] > a[largest]) {
			largest = r;
		}
		if (largest != i) {
			swap(a, i, largest);
			max_heapify(a, largest);
		}
	}
	
	// "堆化"的while版本
	private static void max_heapify_while_version(int[] a, int i) {
		int root = i;
		int l = 2 * (i + 1) - 1;
		int r = 2 * (i + 1);
		int largest = root;
		boolean needChange = true;
		while ((l < heap_size || r < heap_size) && needChange) {
			if (l < heap_size && a[l] > a[largest]) {
				largest = l;
			}
			if (r < heap_size && a[r] > a[largest]) {
				largest = r;
			}
			if (largest != root) {
				swap(a, root, largest);
				root = largest;
				l = 2 * (root + 1) - 1;
				r = 2 * (root + 1);
				needChange = true;
			} else {
				needChange = false;
			}
		}
	}

	private static void swap(int[] a, int i, int j) {
		if (i == j)
			return;
		a[i] += a[j];
		a[j] = a[i] - a[j];
		a[i] -= a[j];
	}
/**
	public static void main(String[] args) {
		int[] a = new int[100000000];
		Random r = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(Integer.MAX_VALUE);
		}
		long l1 = System.currentTimeMillis();
		heap_sort(a);
		long l2 = System.currentTimeMillis();
		System.out.println((l2 - l1) / 1000);
		
//		int[] a = {6,51,88,8,5,55,4,7,1,5,8,6,2,5,6,211,5,1,1,5,2,1,12,12,12,12,12,15,4564};
//		heap_sort(a);
//		for (int i = 0; i < a.length; i++) {
//			System.out.println(a[i]);
//		}
	}
	*/
}
