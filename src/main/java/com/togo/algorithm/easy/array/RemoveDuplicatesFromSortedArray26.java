package com.togo.algorithm.easy.array;

/**
 * 
 * @author AI
 * @desc 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *       不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。 示例 1: 给定数组 nums =
 *       [1,1,2], 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 你不需要考虑数组中超出新长度后面的元素。
 * 
 *       示例 2: 给定 nums = [0,0,1,1,1,2,2,3,3,4], 函数应该返回新的长度 5, 并且原数组 nums
 *       的前五个元素被修改为 0, 1, 2, 3, 4。 你不需要考虑数组中超出新长度后面的元素。
 * 
 *       2019年4月13日
 */
public class RemoveDuplicatesFromSortedArray26 {

	/**
	 * 
	 * @author AI
	 * @desc 因为数组是排好序的，所以我们可以定义两个指针，一个快指针用来遍历数组，另一个慢指针用来指向的是不重复的值，
	 *       所以如果出现不重复的值，则将慢指针向后移动，然后替换元素
	 * 
	 * @param nums
	 * @return
	 * 
	 * 		2019年4月13日
	 */
	public int removeDuplicates(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		// 慢指针
		int index = 0;
		// 快指针遍历数组
		for (int i = 1; i < nums.length; i++) {

			// 找到非重复元素
			if (nums[i] != nums[index]) {
				// 指针后移
				index++;
				// 替换
				nums[index] = nums[i];
			}
		}

		// index是下标，数组长度需要加1；
		return ++index;
	}
}
