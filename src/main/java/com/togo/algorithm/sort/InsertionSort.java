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
