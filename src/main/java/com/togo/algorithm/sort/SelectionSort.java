package com.togo.algorithm.sort;

public class SelectionSort extends AbstractSort {

	@Override
	protected void sort(int[] nums) {
		
		for(int i = 0; i < nums.length; i ++) {
			
			int minIndex = i;
			for(int j = i + 1; j < nums.length; j ++) {
				
				if(nums[j] < nums[minIndex]) {
					minIndex = j;
				}
			}
			
			int temp = nums[minIndex];
			nums[minIndex] = nums[i];
			nums[i] = temp;
		}
	}
}
