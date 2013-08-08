package com.xingzhe.conutingsort;

/**
 * �������� ����Ҫ�������������д洢�Ķ��ǷǸ�����(0��k)���������Ͽ�������������������Ҫ
 * �Ѹ���������������Ѹ������������������Ҫ��ʱ������Լ��޸ģ�
 * 
 * @author Hersules
 */
public class CountingSort {
	public static int[] countingSort(int[] a) {
		int[] b = new int[a.length];
		// 1�����ҳ������е����ֵ
		int largest = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > largest)
				largest = a[i];
		}
		// 2����ʼ������������c
		int[] c = new int[largest + 1];
		for (int i = 0; i < c.length; i++) {
			c[i] = 0;
		}
		// 3������������������ÿ��Ԫ�صĳ��ֵĸ���
		for (int i = 0; i < a.length; i++) {
			c[a[i]]++;
		}// ����c[m]�ͱ�ʾֵm���ֵĴ���
		// 4��ͳ��
		for (int i = 1; i < c.length; i++) {
			c[i] += c[i - 1];
		}// ����c[m]�ͱ�ʾ С�ڵ���m��ֵ ���ֵĴ���
		// 5������
		for (int j = a.length - 1; j >= 0; j--) {
			b[c[a[j]] - 1] = a[j];
			c[a[j]]--;
		}
		return b;
	}
	public static void main(String[] args) {
		int[] a = new int[100000000];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random()*1000000);
		}
		long from = System.currentTimeMillis();
		int[] b = countingSort(a);
		long to = System.currentTimeMillis();
		System.out.println((to-from)/1000);
	}

}
