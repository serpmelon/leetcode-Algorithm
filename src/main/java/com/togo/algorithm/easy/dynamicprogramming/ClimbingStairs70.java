package com.togo.algorithm.easy.dynamicprogramming;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.easy.ClimbingStairs70
 * <p>
 * Descdription: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
 * 示例 1：
 * 
 * 输入： 2 输出： 2 解释： 有两种方法可以爬到楼顶。 1. 1 阶 + 1 阶 2. 2 阶
 * 
 * 示例 2：
 * 
 * 输入： 3 输出： 3 解释： 有三种方法可以爬到楼顶。 1. 1 阶 + 1 阶 + 1 阶 2. 1 阶 + 2 阶 3. 2 阶 + 1 阶
 *
 * 
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
public class ClimbingStairs70 {

	// 计算中间值存储
	private static int[] memory;

	/**
	 * 
	 * <p>
	 * Method ：climbStairs
	 * <p>
	 * Description :递归的思想，爬n节台阶的方法等于开始走一个台阶的方法数加上开始走两个台阶的方法数。即f(n) = f(n - 1) + f(n
	 * - 2); 在计算中肯定会重复计算一些值，比如f(9) = f(8) + f(7), f(8) = f(7) +
	 * f(6),其中f(7)就计算了两遍，所以，我们可以在计算过程中将结果存起来，减少重复计算
	 *
	 * @param n
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年3月7日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public int climbStairs(int n) {

		memory = new int[n + 1];
		return climb(n);
	}

	private int climb(int n) {

		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		if (memory[n] == 0) {

			memory[n] = climb(n - 1) + climb(n - 2);
		}

		return memory[n];
	}
}
