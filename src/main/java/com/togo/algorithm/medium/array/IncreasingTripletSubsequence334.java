package com.togo.algorithm.medium.array;

/**
 * 
 * @author AI
 * @desc 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 * 
 *       数学表达式如下:
 * 
 *       如果存在这样的 i, j, k, 且满足 0 ≤ i < j < k ≤ n-1， 使得 arr[i] < arr[j] < arr[k]
 *       ，返回 true ; 否则返回 false 。
 * 
 *       说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 * 
 *       示例 1:
 * 
 *       输入: [1,2,3,4,5] 输出: true
 * 
 *       示例 2:
 * 
 *       输入: [5,4,3,2,1] 输出: false
 *
 * 
 * 
 * @date 2019年5月3日
 *
 */
public class IncreasingTripletSubsequence334 {

	/**
	 * 
	 * @author AI
	 * @desc 先确定前两个位置，然后再遍历查找第三个值，在遍历中，根据值得大小调整前两个值
	 * 
	 * @param nums
	 * @return
	 *
	 * @date 2019年5月3日
	 */
	public boolean increasingTriplet(int[] nums) {

		if (nums == null || nums.length < 3)
			return false;

		// 前两个值
		int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

		for (int num : nums) {

			// first是最小的值
			if (num < first) {

				first = num;
			} else if (num > first && num < second) {

				// 大于first小于second的更新second
				second = num;
			} else if (num > second) {

				// 比second大的则表示有第三个值
				// 这里存在second，则说明存在满足条件的first和second，所以出现大于second则满足题目
				// 但是当前并不表示first的下标在second前面，second表示存在，并不表示是当前first的second，
				// first可能向后移动了
				return true;
			}
		}

		return false;
	}
}
