package com.togo.algorithm.medium.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * <p>
 * Class :
 * com.togo.algorithm.medium.string.LongestSubstringWithoutRepeatingCharacters3
 * <p>
 * Descdription:给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 示例 2:
 * 
 * 输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 示例 3:
 * 
 * 输入: "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。 请注意，你的答案必须是 子串
 * 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 
 * 
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年3月30日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class LongestSubstringWithoutRepeatingCharacters3 {

	/**
	 * 
	 * <p>
	 * Method ：lengthOfLongestSubstring
	 * <p>
	 * Description :暴力法，两层for循环遍历字符串，确定子串的开头和结尾，然后判断这个子串是否不重复
	 *
	 * @param s
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年3月30日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public static int lengthOfLongestSubstring_0(String s) {

		if (s == null || s.equals(""))
			return 0;

		// 最大长度
		int max = 0;
		int strLength = s.length();

		for (int i = 0; i < strLength; i++) {

			for (int j = i + 1; j <= strLength; j++) {

				// i为首，j为尾
				if (allUnique(s, i, j)) // 如果不重复则给max赋值
					max = Math.max(max, j - i);

			}
		}

		return max;
	}

	private static boolean allUnique(String s, int start, int end) {

		Set<Character> set = new HashSet<>();
		for (int r = start; r < end; r++) {

			// 如果重复则返回false
			if (set.contains(s.charAt(r)))
				return false;

			// 不包含则增加该元素
			set.add(s.charAt(r));
		}

		return true;
	}

	/**
	 * 
	 * <p>
	 * Method ：lengthOfLongestSubstring_1
	 * <p>
	 * Description :滑动窗口，[i,j) i为首，j为尾，j++，当出现重复时，i++，然后再判断是否重复，如果还重复则i++。
	 *
	 * @param s
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年3月30日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public int lengthOfLongestSubstring_1(String s) {

		if (s == null || s.length() == 0)
			return 0;

		int max = 0, strLength = s.length();
		if (strLength == 1)
			return 1;
		int i = 0, j = 0;

		Set<Character> set = new HashSet<>();

		while (i < strLength && j < strLength) {

			// 集合包含则表示重复
			if (set.contains(s.charAt(j))) {
				// 删除i，并i++
				set.remove(s.charAt(i++));
			} else {
				// 不重复则增加元素，并且j++
				set.add(s.charAt(j++));
				max = Math.max(max, j - i);
			}
		}

		return max;
	}

	/**
	 * 
	 * <p>
	 * Method ：lengthOfLongestSubstring
	 * <p>
	 * Description :优化的滑动窗口，如果有重复数据，则直接从重复数据之后在重新计算
	 *
	 * @param s
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年3月30日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public int lengthOfLongestSubstring_2(String s) {

		if (s == null || s.length() == 0)
			return 0;

		int max = 0, strLength = s.length();
		if (strLength == 1)
			return 1;

		int i = 0, j = 0;
		// 将字符和位置存储在map中
		Map<Character, Integer> map = new HashMap<>();
		while (j < strLength) {

			if (map.containsKey(s.charAt(j))) {

				// 存在则充map中获取重复元素后面的位置
				// 这里取max是因为i位置之前的元素重复的话是不关心的，所以重复了还是取现在的i值，即取最大的i值
				i = Math.max(map.get(s.charAt(j)) + 1, i);
			}

			map.put(s.charAt(j), j);
			max = Math.max(max, j - i + 1);
			j++;
		}

		return max;
	}

	public static void main(String[] args) {

		String a = "bb";
		// System.out.println(lengthOfLongestSubstring(a));
	}
}
