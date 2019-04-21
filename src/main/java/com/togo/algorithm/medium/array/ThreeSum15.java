package com.togo.algorithm.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author AI
 * @desc 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 *       ？找出所有满足条件且不重复的三元组。
 * 
 *       注意：答案中不可以包含重复的三元组。
 * 
 *       例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 *       满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * 
 * @date 2019年4月21日
 *
 */
public class ThreeSum15 {

	/**
	 * 
	 * @author AI
	 * @desc 思路：将数组排序，排序后固定一个指针，然后使用双指针遍历。
	 * 
	 * @param nums
	 * @return
	 *
	 * @date 2019年4月21日
	 */
	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> listList = new ArrayList<>();
		// 如果为null或者长度小于3则返回空
		if (nums == null || nums.length < 3)
			return listList;
		// 对数组进行排序
		Arrays.sort(nums);

		// 排序后，如果最小值大于0或者最大值小于0则不可能三个数加起来等于0,
		if (nums[0] > 0 || nums[nums.length - 1] < 0)
			return listList;

		// 遍历数组
		for (int i = 0; i < nums.length - 2; i++) {

			// 当不是第一个元素的时候，如果该元素和前面的元素相等则continue；删除重复
			if (i != 0 && nums[i] == nums[i - 1])
				continue;

			// 左右指针
			int l = i + 1;
			int r = nums.length - 1;

			// 左指针小于右指针，而且当前值必须小于1，否则三个数都大于等于1.
			while (l < r && nums[i] < 1) {
				int s = nums[i] + nums[l] + nums[r];
				if (s == 0) { // 满足条件

					// 结果添加到列表，左右指针相向移动
					listList.add(Arrays.asList(nums[i], nums[l], nums[r]));
					l++;
					r--;
					// 检查左右指针是否重复，重复则移动
					while (l < r && nums[l] == nums[l - 1])
						l++;
					while (l < r && nums[r] == nums[r + 1])
						r--;
				} else if (s > 0) {
					r--;
				} else {
					l++;
				}
			}
		}

		return listList;
	}
}
