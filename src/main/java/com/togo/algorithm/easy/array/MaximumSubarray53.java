package com.togo.algorithm.easy.array;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.easy.MaximumSubarray53
 * <p>
 * Descdription: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例:
 * 
 * 输入: [-2,1,-3,4,-1,2,1,-5,4], 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年3月10日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class MaximumSubarray53 {

	/**
	 * 
	 * <p>
	 * Method ：maxSubArray
	 * <p>
	 * Description :暴力解决：循环遍历每一个元素到结尾元素的序列和
	 *
	 * @param nums
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年3月10日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public int maxSubArray0(int[] nums) {

		// 最大子序列和
		int max = nums[0];

		for (int i = 0; i < nums.length; i++) {

			// 以i开头的序列的子序列和
			int thisMax = 0;
			for (int j = i; j < nums.length; j++) {

				thisMax += nums[j];
				if (max < thisMax)
					max = thisMax;
			}
		}

		return max;
	}

	public static int maxSubArray(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		if (nums.length == 1)
			return nums[0];

		int max = nums[0];
		int thisMax = 0;

		for (int i = 0; i < nums.length; i++) {

			thisMax += nums[i];

			if (thisMax > max)
				max = thisMax;
			else if (thisMax < 0)
				thisMax = 0;
		}

		return max;
	}

	public static void main(String[] args) {

//		int[] a = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int[] a = { -3, -2, 0, -1 };

		System.out.println(maxSubArray(a));
	}
}
