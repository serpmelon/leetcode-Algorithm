package com.togo.algorithm.easy.string;

import java.util.Arrays;

/**
 * 
 * @author AI
 * @desc 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * 
 *       示例 1:
 * 
 *       输入: s = "anagram", t = "nagaram" 输出: true
 * 
 *       示例 2:
 * 
 *       输入: s = "rat", t = "car" 输出: false
 * 
 *       说明: 你可以假设字符串只包含小写字母。
 * 
 *       进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 
 * @date 2019年5月4日
 *
 */
public class ValidAnagram242 {

	/**
	 * 
	 * @author AI
	 * @desc 思路是将两个字符串排序，然后一个一个字母比较
	 * 
	 * @param s
	 * @param t
	 * @return
	 *
	 * @date 2019年5月4日
	 */
	public boolean isAnagram_0(String s, String t) {

		if (s == null || t == null || s.length() != t.length())
			return false;

		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();

		Arrays.sort(sArr);
		Arrays.sort(tArr);

		for (int i = 0; i < sArr.length; i++) {

			if (sArr[i] != tArr[i])
				return false;
		}

		return true;
	}

	/**
	 * 
	 * @author AI
	 * @desc 思路是将出现的字符和次数记录在数组中，巧妙的是利用了题目说的只有“小写字母”的特点。
	 * 
	 * @param s
	 * @param t
	 * @return
	 *
	 * @date 2019年5月4日
	 */
	public boolean isAnagram_1(String s, String t) {

		if (s == null || t == null || s.length() != t.length())
			return false;

		// 记录26个字母出现的次数
		int[] count = new int[26];

		// s加次数
		for (char c : s.toCharArray()) {

			count[c - 'a']++;
		}

		// t减次数
		for (char c : t.toCharArray()) {

			count[c - 'a']--;
		}

		// 最后不等于0就是不一样
		for (int i : count) {

			if (i != 0)
				return false;
		}

		return true;
	}
}
