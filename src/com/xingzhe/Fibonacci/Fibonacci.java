package com.xingzhe.Fibonacci;
/**
 * 打印斐波那契序列
 * @author Hersules
 *
 */
public class Fibonacci {

	public static void print(int a, int b, int limit) {
		System.out.println(a);
		int f1 = a;
		int f2 = b;
		while (f2 <= limit) {
			System.out.println(f2);
			f2 += f1;
			f1 = f2 - f1;
		}
	}

	public static void main(String[] args) {
		Fibonacci.print(1, 1, 50000);
	}

}
