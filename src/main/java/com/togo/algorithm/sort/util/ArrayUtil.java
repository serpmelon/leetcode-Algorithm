package com.togo.algorithm.sort.util;

public class ArrayUtil {

	private ArrayUtil() {
	}

	public static void swap(int[] nums, int i, int j) {

		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
