package com.togo.algorithm.sort;

public class Tmp {

	public static void main(String[] args) {

		Tmp tmp = new Tmp();
		int[] nums = { 1, 2, 0 };
		tmp.sortColors(nums);
		System.out.println(nums);
	}

	public void sortColors(int[] nums) {

		int red = 0;
		int blue = nums.length - 1;

		for (int i = 0; i < blue + 1; i++) {

			if (nums[i] == 0) {

				swap(i, red, nums);
				red++;
			} else if (nums[i] == 2) {

				swap(i, blue, nums);
				blue--;
			}
		}

	}

	private void swap(int i, int j, int[] nums) {

		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
