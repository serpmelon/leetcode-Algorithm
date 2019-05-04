package com.togo.algorithm.medium.array;

/**
 * 
 * @author AI
 * @desc 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 
 *       你的算法时间复杂度必须是 O(log n) 级别。
 * 
 *       如果数组中不存在目标值，返回 [-1, -1]。
 * 
 *       示例 1:
 * 
 *       输入: nums = [5,7,7,8,8,10], target = 8 输出: [3,4]
 * 
 *       示例 2:
 * 
 *       输入: nums = [5,7,7,8,8,10], target = 6 输出: [-1,-1]
 *
 * 
 * 
 * @date 2019年5月4日
 *
 */
public class FindFirstAndLastPositionOfElementInSortedArray34 {

	/**
	 * 
	 * @author AI
	 * @desc 这个是自己写的，首尾两个指针遍历查找，但是题目已经说明是已排序的数组，所以可以用更有效的二分查找。 首尾指针更适合使用在无序数组中。
	 * 
	 * @param nums
	 * @param target
	 * @return
	 *
	 * @date 2019年5月4日
	 */
	public int[] searchRange_0(int[] nums, int target) {

		int[] result = new int[] { -1, -1 };

		for (int i = 0, j = nums.length - 1; i <= j && (result[0] == -1 || result[1] == -1);) {

			if (nums[i] == target)
				result[0] = i;
			else
				i++;

			if (nums[j] == target)
				result[1] = j;
			else
				j--;

		}

		return result;
	}

	/**
	 * 
	 * @author AI
	 * @desc 二分查找，当看到有序数组，就要先想到二分查找。
	 * 
	 * @param nums
	 * @param target
	 * @return
	 *
	 * @date 2019年5月4日
	 */
	public int[] searchRange_1(int[] nums, int target) {

		if (nums.length == 0)
			return new int[] { -1, -1 };

		int low = 0, high = nums.length - 1, mid = 0;
		int i;

		while (low <= high) {

			mid = (low + high) / 2;
			if (nums[mid] == target) {// 找到目标则跳出循环
				break;
			}
			if (nums[mid] < target) {
				low = mid + 1;
			}
			if (nums[mid] > target) {
				high = mid - 1;
			}
		}

		if (low > high) // 表示没找到
			return new int[] { -1, -1 };
		// 存在目标值，就是循环中break；这里循环是找是不是有多个连续目标值在mid左侧
		for (i = mid; i >= 0 && nums[i] == target; i--)
			;

		// 当不满足条件时，肯定是从满足的i--得到的，所以+1，high同理
		low = i + 1;

		for (i = mid; i < nums.length && nums[i] == target; i++)
			;

		high = i - 1;

		return new int[] { low, high };
	}
}
