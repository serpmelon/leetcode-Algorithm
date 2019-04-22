package com.togo.algorithm.easy.dynamicprogramming;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.easy.dynamicprogramming.HouseRobber198
 * <p>
 * Descdription:
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,1] 输出: 4 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。 偷窃到的最高金额 = 1
 * + 3 = 4 。
 * 
 * 示例 2:
 * 
 * 输入: [2,7,9,3,1] 输出: 12 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋
 * (金额 = 1)。 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
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
public class HouseRobber198 {

	/**
	 * 
	 * <p>
	 * Method ：rob
	 * <p>
	 * Description :思路：是否抢劫第n个房子，取决于抢劫n-1和n-2的收益及dp(n) = MAX(dp(n-1), dp(n-2) +
	 * nums[n]);
	 *
	 * @param nums
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年4月22日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public int rob(int[] nums) {

		// current相当于n-1，previous相当于n-2
		int current = 0, previous = 0;

		for (int i = 0; i < nums.length; i++) {

			int result = Math.max(current, previous + nums[i]);
			previous = current;
			current = result;
		}

		return current;
	}
}
