package com.togo.algorithm.easy.array;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.easy.array.MergeSortedArray88
 * <p>
 * Descdription:给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 
 * 说明:
 * 
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存
 * nums2 中的元素。
 * 
 * 示例:
 * 
 * 输入: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3
 * 
 * 输出: [1,2,2,3,5,6]
 *
 * 
 * 
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年4月16日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class MergeSortedArray88 {

	/**
	 * 
	 * <p>
	 * Method ：merge
	 * <p>
	 * Description
	 * :思路：比较两个数组的最后一个元素，最后一个元素肯定是每个数组的最大值，比较大的元素直接放到第一个数组的最后一位，遍历将次大的放到第二位
	 *
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年4月16日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {

		// 最后一位下标
		// m-- n--是为了下面循环可以直接当做下标用
		int end = m-- + n-- - 1;
		while (m > -1 && n > -1) { // 其中一个数组没有有效数字则跳出
			// 将两个最大的值比较，将更大的放到后面
			// 这里面的m-- n--使用的很巧妙，可以在插入值的时候再把这个数组下标迁移。
			nums1[end--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
		}

		// nums1数组有效数字多并不影响，因为是在nums1数组上进行的插入，多出来的部分已经是排好序的
		while (n > -1) {
			// n剩下来表示nums1数组的值都比较大，现在剩下的都是前面的位置，按照顺序将nums2插入
			nums1[end--] = nums2[n--];
		}
	}
}