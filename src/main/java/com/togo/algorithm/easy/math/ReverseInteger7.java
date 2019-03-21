package com.togo.algorithm.easy.math;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.easy.ReverseInteger
 * <p>
 * Descdription:给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。假设我们的环境只能存储得下 32
 * 位的有符号整数，则其数值范围为 [−2^31, 2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年2月18日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class ReverseInteger7 {

	/**
	 * 
	 * <p>
	 * Method ：reverse
	 * <p>
	 * Description :将给定x取出最低位，然后弹出最低位，然后将取出的数以此加在新数上组成翻转后的数字。
	 *
	 * @param x
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年2月18日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public int reverse(int x) {

		int rev = 0;
		while (x != 0) {

			int pop = x % 10;
			x /= 10;

			// rev = rev * 10 + pop; 这里的操作可能导致溢出，所以要先做判断
			if (rev > Integer.MAX_VALUE / 10 // rev * 10 肯定大于 MAX
					|| (rev == Integer.MAX_VALUE / 10 && pop > 7)) // rev = MAX / 10
																	// ，7是MAX的个位，所以pop大于7则溢出
				return 0;
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) // 同上
				return 0;

			rev = rev * 10 + pop;
		}

		return rev;
	}
}
