package com.togo.algorithm.easy.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.easy.TwoSumSolution
 * <p>
 * Descdription: Given an array of integers, return indices of the two numbers
 * such that they add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 *
 * 
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年2月17日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class TwoSumSolution1 {

	/**
	 * 
	 * <p>
	 * Method ：twoSum
	 * <p>
	 * Description :循环遍历数组，每个数字对应的差值即 target - nums[i]，存储在哈希表中，然后在哈希表中寻找数字对应的差值
	 *
	 * @param nums
	 * @param target
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年2月17日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {

			// nums[i]对应的差值
			int x = target - nums[i];
			if (map.containsKey(x)) { // 哈希表中是否有这个差值

				// 有则返回
				return new int[] { i, map.get(x) };
			}

			// 没有则把这个差值存储在哈希表中
			map.put(nums[i], i);
		}

		throw new IllegalArgumentException("No two sum solution");
	}
}
