package com.togo.algorithm.sort;

public class InsertionSort extends AbstractSort {

	@Override
	protected String getName() {
		return "InsertionSort 插入排序";
	}
	
	@Override
	protected void sort(int[] nums) {

		for (int i = 1; i < nums.length; i++) {

			int pre = i - 1;
			int current = nums[i];
			while (pre >= 0 && nums[pre] > current) {

				nums[pre + 1] = nums[pre];
				pre--;
			}

			nums[pre + 1] = current;
		}
	}

}
