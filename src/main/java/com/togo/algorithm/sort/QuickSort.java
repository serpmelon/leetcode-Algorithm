package com.togo.algorithm.sort;

import com.togo.algorithm.sort.util.ArrayUtil;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.sort.QuickSort
 * <p>
 * Descdription:快速排序，不稳定，时间复杂度nlogn，空间复杂度nlogn，空间复杂度是因为递归调用消耗的
 * 算法中的j是遍历游标，i是指向中间点的游标，每次遍历结束需要将中间值和区分点交换； 区分点取头结点，则交换的时候需要i -
 * 1，因为i指向的是值大于区分点，交换后该值就在区分点的左边了，所以需要 -
 * 1，而区分点选择尾节点则直接交换i，这是因为交换后i指向的元素还是在区分点右边。还有一种情况是区分点取头结点，头节点最大，
 * 则i最后指向末尾+1，所以也需要减1。使用尾节点当区分点逻辑比较清晰
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
	private int partition(int[] nums, int start, int end) {

		int point = nums[end];
		int i = start;
		for (int j = start; j < end; j++) {

			if (nums[j] < point) {

				ArrayUtil.swap(nums, i, j);
				i++;
			}
		}

		ArrayUtil.swap(nums, i, end);

		return i;
	}

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
//	private int partition(int[] nums, int start, int end) {
//
//		int point = nums[start];
//		int i = start + 1;
//		for (int j = start + 1; j <= end; j++) {
//
//			if (nums[j] < point) {
//
//				ArrayUtil.swap(nums, i, j);
//				i++;
//			}
//		}
//
//		ArrayUtil.swap(nums, i - 1, start);
//
//		return i - 1;
//	}
}
