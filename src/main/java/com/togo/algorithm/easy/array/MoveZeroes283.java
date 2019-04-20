package com.togo.algorithm.easy.array;

import com.togo.algorithm.sort.util.ArrayUtil;

/**
 * 
 * @author AI
 * @desc 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 *       示例:
 * 
 *       输入: [0,1,0,3,12] 输出: [1,3,12,0,0]
 * 
 *       说明:
 * 
 *       必须在原数组上操作，不能拷贝额外的数组。 尽量减少操作次数。
 * 
 * 
 * @date 2019年4月21日
 *
 */
public class MoveZeroes283 {

	/**
	 * 
	 * @author AI
	 * @desc 思路僵化~一直想着就是交换~~两个指针，一个指向0一个指向非0，当0指针位置在非0指针之前则交换
	 * 
	 * @param nums
	 *
	 * @date 2019年4月21日
	 */
	public void moveZeroes_0(int[] nums) {

		if (nums == null || nums.length < 2)
			return;

		// 0指针
		int i = 0;
		// 非0指针
		int j = 1;

		while (i < nums.length && j < nums.length) {

			if (nums[i] == 0) {
				if (nums[j] != 0 && i < j) {
					// 0指针和非0指针交换
					ArrayUtil.swap(nums, i, j);
					i++;
					j++;
				} else {
					j++;
				}
			} else {
				i++;
			}
		}
	}

	/**
	 * 
	 * @author AI
	 * @desc 最优解，思路：一个指针用于指向非零值，一个指针遍历，遍历将非零值覆盖到非零指针，这样遍历完毕后，非零指针前面都已
	 *       经按照顺序排好了，后面再讲后面的位置设置为0即可。
	 * 
	 * @param nums
	 *
	 * @date 2019年4月21日
	 */
	public void moveZeroes(int[] nums) {

		if (nums == null || nums.length < 2)
			return;

		// 记录非零值
		int size = 0;
		for (int i = 0; i < nums.length; i++) {

			// 当i指向非零值，则将它覆盖size指向的元素，然后size向后移动
			if (nums[i] != 0) {
				nums[size] = nums[i];
				size++;
			}
		}

		// 一次遍历后，size前面都是按顺序排好的非零值，那么将size及后面的都设置为0
		for (int i = size; i < nums.length; i++) {
			nums[i] = 0;
		}
	}
}
