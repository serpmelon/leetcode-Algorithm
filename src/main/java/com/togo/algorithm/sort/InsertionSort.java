package com.togo.algorithm.sort;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.sort.InsertionSort
 * <p>
 * Descdription:插入排序，稳定，时间复杂度n^2，空间复杂度1
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
public class InsertionSort extends AbstractSort {

	@Override
	protected String getName() {
		return "InsertionSort 插入排序";
	}

	/**
	 * 
	 * <p>
	 * Method ：sort
	 * <p>
	 * Description :遍历元素，将元素从排好序的后面比较，在合适的地方插入元素
	 *
	 * @param nums
	 * @see com.togo.algorithm.sort.AbstractSort#sort(int[])
	 */
	@Override
	protected void sort(int[] nums) {

		// 从1开始，也就是0位置算排好序了
		for (int i = 1; i < nums.length; i++) {

			// pre指向排好序的最后一位
			int pre = i - 1;
			int current = nums[i];
			// 如果是从大到小，则nums[pre] < current
			while (pre >= 0 && nums[pre] > current) {

				// 这一步是将pre的值向后移动了一步，pre位置上还是pre的值，这个值会在最后替换成current
				nums[pre + 1] = nums[pre];
				pre--;
			}

			// 替换
			nums[pre + 1] = current;
		}
	}

}
