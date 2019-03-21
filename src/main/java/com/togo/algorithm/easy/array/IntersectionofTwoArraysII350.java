package com.togo.algorithm.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.easy.IntersectionofTwoArraysII350
 * <p>
 * Descdription: 给定两个数组，编写一个函数来计算它们的交集。
 * 
 * 示例 1:
 * 
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2] 输出: [2,2]
 * 
 * 示例 2:
 * 
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4] 输出: [4,9]
 *
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年3月7日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class IntersectionofTwoArraysII350 {

	/**
	 * 
	 * <p>
	 * Method ：intersect
	 * <p>
	 * Description :整体思路就是先排序，然后从头比较，相同则指针移动，不同则数字小的移动
	 *
	 * @param nums1
	 * @param nums2
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年3月7日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public int[] intersect(int[] nums1, int[] nums2) {

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		List<Integer> numsList = new ArrayList<>();

		for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {

			if (nums1[i] == nums2[j]) {

				numsList.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] > nums2[j]) {

				j++;
			} else {

				i++;
			}
		}

		int[] result = new int[numsList.size()];
		int k = 0;
		for (int i : numsList)
			result[k++] = i;

		return result;

	}
}
