package com.togo.algorithm.sort;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.sort.SelectionSort
 * <p>
 * Descdription:选择排序，不稳定，时间复杂度n^2，空间复杂度1
 *
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年3月20日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class SelectionSort extends AbstractSort {

	@Override
	protected String getName() {
		return "SelectionSort 选择排序";
	}

	@Override
	protected void sort(int[] nums) {

		for (int i = 0; i < nums.length; i++) {

			int minIndex = i;
			for (int j = i + 1; j < nums.length; j++) {

				if (nums[j] < nums[minIndex]) {
					minIndex = j;
				}
			}

			int temp = nums[minIndex];
			nums[minIndex] = nums[i];
			nums[i] = temp;
		}
	}
}
