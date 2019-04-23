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

	/**
	 * 
	 * <p>
	 * Method ：sort
	 * <p>
	 * Description :每次遍历寻找当前最小值，然后把最小值放到前边
	 *
	 * @param nums
	 * @see com.togo.algorithm.sort.AbstractSort#sort(int[])
	 */
	@Override
	protected void sort(int[] nums) {

		for (int i = 0; i < nums.length; i++) {

			// 默认每次遍历的第一个为最小值
			int minIndex = i;
			for (int j = i + 1; j < nums.length; j++) {

				// 遍历寻找最小值
				if (nums[j] < nums[minIndex]) {
					minIndex = j;
				}
			}

			// 找到后 交换
			int temp = nums[minIndex];
			nums[minIndex] = nums[i];
			nums[i] = temp;
		}
	}
}
