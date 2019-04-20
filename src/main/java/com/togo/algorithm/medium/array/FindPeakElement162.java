package com.togo.algorithm.medium.array;

/**
 * 
 * @author AI
 * @desc 峰值元素是指其值大于左右相邻值的元素。 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *       数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。 你可以假设 nums[-1] = nums[n] = -∞。 示例 1:
 *       输入: nums = [1,2,3,1] 输出: 2 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 
 *       示例 2: 输入: nums = [1,2,1,3,5,6,4] 输出: 1 或 5 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *       或者返回索引 5， 其峰值元素为 6。
 * 
 * @date 2019年4月20日
 *
 */
public class FindPeakElement162 {

	/**
	 * 
	 * @author AI
	 * @desc 这是我开始的想法，没有注意到题目要求的时间复杂度logN，这个解法的时间复杂度是O（n）。
	 *       思路就是循环找到波峰，因为起点和末尾都是负无穷，所以只要找到后面的值比前面的值小，那么前面的这个值就是波峰。
	 * 
	 * @param nums
	 * @return
	 *
	 * @date 2019年4月20日
	 */
	public int findPeakElement_0(int[] nums) {

		if (nums == null || nums.length == 0)
			return -1;
		if (nums.length == 1)
			return 0;

		for (int i = 0, j = 1; j < nums.length; i++, j++) {

			// 因为开始为负无穷，所以nums[0]肯定大于，所以后面只需要找到小的值就可以了
			if (nums[i] > nums[j]) {

				return i;
			}
		}

		// 没有找到的话就是最后一个值
		return nums.length - 1;
	}
	
	
}
