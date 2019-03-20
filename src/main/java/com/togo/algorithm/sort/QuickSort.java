package com.togo.algorithm.sort;

import com.togo.algorithm.sort.util.ArrayUtil;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.sort.QuickSort
 * <p>
 * Descdription:快速排序，不稳定，时间复杂度nlogn，空间复杂度nlogn，空间复杂度是因为递归调用消耗的
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
public class QuickSort extends AbstractSort {

	@Override
	protected String getName() {
		return "QuickSort 快速排序";
	}

	@Override
	protected void sort(int[] nums) {

		quickSort(nums, 0, nums.length - 1);
	}

	private void quickSort(int[] nums, int start, int end) {

		if (start >= end)
			return;

		int point = partition(nums, start, end);
		quickSort(nums, start, point - 1);
		quickSort(nums, point + 1, end);
	}

	/**
	 * 
	 * <p>
	 * Method ：partition
	 * <p>
	 * Description :取末尾为区分点
	 *
	 * @param nums
	 * @param start
	 * @param end
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年3月20日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	// private int partition(int[] nums, int start, int end) {
	//
	// int point = nums[end];
	// int i = start;
	// for (int j = start; j < end; j++) {
	//
	// if (nums[j] < point) {
	//
	// ArrayUtil.swap(nums, i, j);
	// i++;
	// }
	// }
	//
	// ArrayUtil.swap(nums, i, end);
	//
	// return i;
	// }

	/**
	 * 
	 * <p>
	 * Method ：partition
	 * <p>
	 * Description :以队首为区分点
	 *
	 * @param nums
	 * @param start
	 * @param end
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年3月20日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	private int partition(int[] nums, int start, int end) {

		int point = nums[start];
		int i = start + 1;
		for (int j = start; j <= end; j++) {

			if (nums[j] < point) {

				ArrayUtil.swap(nums, i, j);
				i++;
			}
		}

		ArrayUtil.swap(nums, i - 1, start);

		return i - 1;
	}
}
