package com.togo.algorithm.medium;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.medium.LongestPalindromeSolution
 * <p>
 * Descdription:Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * Input: "babad" Output: "bab" Note: "aba" is also a valid answer.
 * 
 * Example 2:
 * 
 * Input: "cbbd" Output: "bb"
 *
 * 
 * 
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年2月17日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class LongestPalindromeSolution {

	/**
	 * 
	 * <p>
	 * Method ：longestPalindrome
	 * <p>
	 * Description
	 * :寻找一个字符串中的最长回文数，采用中间扩展算法，即从某个位置开始，如果左边的元素等于右边的元素则是回文数，所以最长回文数就是其中长度最长的
	 *
	 * @param s
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年2月17日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public String longestPalindrome(String s) {

		if (s == null || s.length() < 1) {
			return "";
		}

		int start = 0; // 最后返回子串的起始位置
		int end = 0; // 最后返回子串的结束位置
		for (int i = 0; i < s.length(); i++) {

			// 这种情况是中心在某个元素上
			int len0 = expandAroundCenter(s, i, i);
			// 而这种情况是中心在某两个相邻元素中间
			int len1 = expandAroundCenter(s, i, i + 1);
			// 取两者长度最大
			int len = Math.max(len0, len1);

			if (len > end - start) {// 长度大于收尾长度则重置收尾位置
				// 起始位置就是在中心位置向左启动一半的长度
				start = i - (len - 1) / 2;
				// 同上
				end = i + len / 2;
			}
		}

		return s.substring(start, end + 1);
	}

	/**
	 * 
	 * <p>
	 * Method ：expandAroundCenter
	 * <p>
	 * Description :从某个位置向左右扩展，如果左右元素相等则继续，否则结束。这个“某个位置”就是 (left + right) / 2
	 *
	 * @param s
	 * @param left
	 * @param right
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年2月17日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	private int expandAroundCenter(String s, int left, int right) {

		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}

		// 返回长度
		return right - left - 1;
	}
}
