package com.imageread;

import java.util.Arrays;

public class SortTest {
	public static void main(String[] args) {
		int[] bubbleSort = new int[] { 324, 22, 1, -12, 0, 12, 4, 6, 2222,
				1111, 5 };
		int[] bubbleSort1 = new int[] { 324, 22, 1, -12, 0, 12, 4, 6, 2222,
				1111, 5 };
		int[] bubbleSort2 = new int[] { 324, 22, 1, -12, 0, 12, 4, 6, 2222,
				1111, 5 };
		// ����1
		int count = 0;
		System.out.println("����ǰ��" + Arrays.toString(bubbleSort));
		count = bubbleSort(bubbleSort, 0);
		System.out.println("�����" + Arrays.toString(bubbleSort));
		System.out.println("����Ƚϴ�����" + count);

		System.out.println("-----------------------------------");
		// ����1
		int count1 = 0;
		System.out.println("����ǰ��" + Arrays.toString(bubbleSort1));
		count1 = bubbleSort1(bubbleSort1, 0);
		System.out.println("�����" + Arrays.toString(bubbleSort1));
		System.out.println("����Ƚϴ�����" + count1);

		System.out.println("-----------------------------------");
		// ����2
		int count2 = 0;
		System.out.println("����ǰ��" + Arrays.toString(bubbleSort2));
		count2 = bubbleSort2(bubbleSort2, 0);
		System.out.println("�����" + Arrays.toString(bubbleSort2));
		System.out.println("����Ƚϴ�����" + count2);
	}

	// ð��0 ��һ��ģ��
	public static int bubbleSort(int[] datas, int count) {
		// ������Ҫ�Ƚϣ�����ֻ��Ҫ�Ƚ�n-1�� ���űȽ�
		for (int j = 0; j < datas.length - 1; j++) {
			System.out.println("aaa:"+Arrays.toString(datas));
			for (int i = datas.length - 1; i >= 1; i--) {
				count++;
				int temp;
				if (datas[i] < datas[i - 1]) {
					// n��ֵ ���� n-1��ֵ������ֵ����
					temp = datas[i - 1];
					datas[i - 1] = datas[i];
					datas[i] = temp;
					//System.out.println("bijiaohou:"+Arrays.toString(datas));
				}
				System.out.println("bijiaohoua:"+Arrays.toString(datas));
			}
		}
		return count;
	}

	// ð��1 ���޸Ĺ���
	public static int bubbleSort1(int[] datas, int count) {
		// ������Ҫ�Ƚϣ�����ֻ��Ҫ�Ƚ�n-1��
		for (int j = 0; j < datas.length - 1; j++) {
			for (int i = 0; i <= j; i++) {
				count++;
				int temp;
				if (datas[i] < datas[i + 1]) {
					// n��ֵ ���� n-1��ֵ������ֵ����
					temp = datas[i + 1];
					datas[i + 1] = datas[i];
					datas[i] = temp;
				}
			}
		}
		return count;
	}

	// ð��2
	public static int bubbleSort2(int[] datas, int count) {
		for (int i = 0; i < datas.length; i++) {
			for (int j = 0; j < datas.length - 1; j++) {
				if (datas[j] > datas[j + 1]) {
					int temp = datas[j + 1];
					datas[j + 1] = datas[j];
					datas[j] = temp;
				}
				count++;
			}
		}
		return count;
	}

}