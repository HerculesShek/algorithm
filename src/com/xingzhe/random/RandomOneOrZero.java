package com.xingzhe.random;

public class RandomOneOrZero {
	public static int get() {
		int a = 0;
		int b = 0;
		while (a == b) {
			a = getBase();
			b = getBase();
		}
		return a;
	}

	// ���������ģ��ģ�ÿ�����е�ʱ��p��ֵ�ǹ̶��ĵ��Ǽ�������ǲ���֪��
	private static int getBase() {
		double p = 0.1;// �����pֵ������������Ϊ0��1֮�������
		double ref = Math.random();
		if (ref > p)
			return 1;
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
	}
}
