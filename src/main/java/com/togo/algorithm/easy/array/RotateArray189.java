package com.togo.algorithm.easy.array;

import java.util.Arrays;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.easy.RotateArray189
 * <p>
 * Descdription:给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,4,5,6,7] 和 k = 3 输出: [5,6,7,1,2,3,4] 解释: 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5] 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 
 * 示例 2:
 * 
 * 输入: [-1,-100,3,99] 和 k = 2 输出: [3,99,-1,-100] 解释: 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年3月4日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class RotateArray189 {

	/**
	 * 
	 * <p>
	 * Method ：rotate
	 * <p>
	 * Description :这是自己想的算法，但是没有满足题目的空间复杂度O(1); 思路就是将后半部分移到前半部分，将前半部分移动到后半部分
	 *
	 * @param nums
	 * @param k
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年3月4日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public void rotate(int[] nums, int k) {

		int arrLength = nums.length;
		if (arrLength == 0 || k == 0)
			return;
		if (k > arrLength)
			k %= arrLength;
		int newHead = arrLength - k;
		int[] head = Arrays.copyOfRange(nums, newHead, arrLength);
		int[] end = Arrays.copyOfRange(nums, 0, newHead);
		System.arraycopy(head, 0, nums, 0, head.length);
		System.arraycopy(end, 0, nums, head.length, end.length);
	}

	/**
	 * 
	 * <p>
	 * Method ：rotate_1
	 * <p>
	 * Description
	 * :这个方法的空间复杂度满足要求，思路是通过K值可以将数组分为两个部分，两个部分分别旋转，然后整个数组旋转；这个想法按照先整体旋转，然后两个部分分别旋转，可能好理解一点
	 *
	 * @param nums
	 * @param k
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年3月4日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public void rotate_1(int nums[], int k) {

		int arrLength = nums.length;
		if (k >= arrLength)
			k %= arrLength;
		if (arrLength == 0 || k == 0)
			return;

		reverse(nums, 0, arrLength - k - 1);
		reverse(nums, arrLength - k, arrLength - 1);
		reverse(nums, 0, arrLength - 1);
	}

	private void reverse(int[] nums, int start, int end) {

		while (start < end) {

			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
}
