package com.togo.algorithm.easy.array;

import java.util.Arrays;

/**
 * 
 * @author AI
 * @desc 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 
 *       最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 
 *       你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 *       示例 1:
 * 
 *       输入: [1,2,3] 输出: [1,2,4] 解释: 输入数组表示数字 123。
 * 
 *       示例 2:
 * 
 *       输入: [4,3,2,1] 输出: [4,3,2,2] 解释: 输入数组表示数字 4321。
 *
 * 
 * 
 * @date 2019年4月20日
 *
 */
public class PlusOne66 {

	/**
	 * 
	 * @author AI
	 * @desc 思路就是按照正常加法做就行了。用到了Arrays不太好，主要是这个题没啥意思
	 * 
	 * @param digits
	 * @return
	 *
	 * @date 2019年4月20日
	 */
	public int[] plusOne(int[] digits) {

		int[] result = null;
		if (digits[0] == 9) {
			result = new int[digits.length + 1];
			result[0] = 0;
			for (int i = 0; i < digits.length; i++) {
				result[i + 1] = digits[i];
			}
		} else {
			result = digits;
		}

		plusOne(result, result.length - 1);

		if (result[0] != 0)
			return result;
		return Arrays.copyOfRange(result, 1, result.length);
	}

	private void plusOne(int[] digits, int index) {

		if (index < 0)
			return;
		digits[index]++;
		if (digits[index] > 9) {
			digits[index] = digits[index] % 10;
			plusOne(digits, --index);
		}
	}

}
