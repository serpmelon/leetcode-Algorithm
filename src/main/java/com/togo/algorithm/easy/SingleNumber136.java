package com.togo.algorithm.easy;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.easy.SingleNumber136
 * <p>
 * Descdription:给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 示例 1:
 *
 * 输入: [2,2,1] 输出: 1
 *
 *
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年2月27日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class SingleNumber136 {

	public int singleNumber(int[] nums) {

		int result = 0;
		for (int n : nums) {
			// a ^ b ^ b = a, 因为b ^ b = 0， 0 ^ x = x 。
			// 所以相同的数异或之后都为0， 独立的数异或0就是自己了
			result = result ^ n;
		}

		return result;
	}
}
