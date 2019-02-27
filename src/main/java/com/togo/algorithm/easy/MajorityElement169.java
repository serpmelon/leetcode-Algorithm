package com.togo.algorithm.easy;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.easy.MajorityElement169
 * <p>
 * Descdription: 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年2月28日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class MajorityElement169 {

	/**
	 * 
	 * <p>
	 * Method ：majorityElement
	 * <p>
	 * Description :摩尔投票法，因为最后要求的数字存在的个数大于一半，所以通过计数+1-1的方式，最后肯定会剩下众数
	 *
	 * @param nums
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年2月27日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public int majorityElement(int[] nums) {

		int count = 0;
		int result = 0;

		for (int n : nums) {

			if (count == 0) {

				result = n;
				count = 1;
			} else if (result == n) {

				count++;
			} else {

				count--;
			}
		}

		return result;
	}

	public int majorityElement_1(int[] nums) {
		return find(nums, 0, nums.length - 1);
	}

	public int find(int[] nums, int begin, int end) {
		if (begin == end) {
			return nums[begin];
		} else {
			int mid = (begin + end) / 2;
			int left = find(nums, begin, mid);
			int right = find(nums, mid + 1, end);
			// 左右两部分的众数相同 则这个数是这部分的众数
			if (left == right) {
				return left;
			} else {

				int countLeft = 0;
				int countRight = 0;
				for (int i = begin; i <= end; i++) {
					if (nums[i] == left) {
						countLeft++;
					} else if (nums[i] == right) {
						countRight++;
					}
				}
				if (countLeft > countRight) {
					return left;
				} else {
					return right;
				}
			}
		}
	}
}
