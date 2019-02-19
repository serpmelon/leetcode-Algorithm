package com.togo.algorithm.easy;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.easy.PalindromeNumber
 * <p>
 * Descdription: 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 比如121是，-121倒过来是121-就不是
 *
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年2月19日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class PalindromeNumber {

	public boolean isPalindrome(int x) {

		if (x == 0) // 0肯定是回文数
			return true;

		if (x < 0 || x % 10 == 0) // 负数肯定不是；数字末尾是0的不为0的数肯定不是，比如10
			return false;

		int r = 0;
		while (x > r) { // 循环翻转x的一半的数，比如1221，把后面的21翻转和12作比较就可以了

			r = r * 10 + x % 10;
			x /= 10;
		}

		// r/10是因为如果是奇位数字的话，121，r = 12,需要除以10 再和首部的1作比较
		return x == r || x == r / 10;
	}
}
