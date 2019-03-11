package com.togo.algorithm.sort;

public class BubbleSort extends AbstractSort {

	public void sort(int[] nums) {

		if (nums == null || nums.length == 0)
			return;
		if (nums.length == 1)
			return;

		for (int i = 0; i < nums.length; i++) {

			for (int j = 0; j < nums.length - i - 1; j++) {

				if(nums[j] > nums[j + 1]) {
					
					int temp = nums[j + 1];
					nums[j + 1] = nums[j];
					nums[j] = temp;
				}
			}
		}
	}
}
