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
		// 方法1
		int count = 0;
		System.out.println("排序前：" + Arrays.toString(bubbleSort));
		count = bubbleSort(bubbleSort, 0);
		System.out.println("排序后：" + Arrays.toString(bubbleSort));
		System.out.println("排序比较次数：" + count);

		System.out.println("-----------------------------------");
		// 方法1
		int count1 = 0;
		System.out.println("排序前：" + Arrays.toString(bubbleSort1));
		count1 = bubbleSort1(bubbleSort1, 0);
		System.out.println("排序后：" + Arrays.toString(bubbleSort1));
		System.out.println("排序比较次数：" + count1);

		System.out.println("-----------------------------------");
		// 方法2
		int count2 = 0;
		System.out.println("排序前：" + Arrays.toString(bubbleSort2));
		count2 = bubbleSort2(bubbleSort2, 0);
		System.out.println("排序后：" + Arrays.toString(bubbleSort2));
		System.out.println("排序比较次数：" + count2);
	}

	// 冒泡0 第一个模板
	public static int bubbleSort(int[] datas, int count) {
		// 自身不需要比较，所以只需要比较n-1次 倒着比较
		for (int j = 0; j < datas.length - 1; j++) {
			System.out.println("aaa:"+Arrays.toString(datas));
			for (int i = datas.length - 1; i >= 1; i--) {
				count++;
				int temp;
				if (datas[i] < datas[i - 1]) {
					// n的值 大于 n-1的值，进行值交换
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

	// 冒泡1 你修改过的
	public static int bubbleSort1(int[] datas, int count) {
		// 自身不需要比较，所以只需要比较n-1次
		for (int j = 0; j < datas.length - 1; j++) {
			for (int i = 0; i <= j; i++) {
				count++;
				int temp;
				if (datas[i] < datas[i + 1]) {
					// n的值 大于 n-1的值，进行值交换
					temp = datas[i + 1];
					datas[i + 1] = datas[i];
					datas[i] = temp;
				}
			}
		}
		return count;
	}

	// 冒泡2
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