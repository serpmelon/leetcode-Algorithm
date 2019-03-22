package com.togo.algorithm.easy.string;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.easy.string.FirstUniqueCharacterInAString387
 * <p>
 * Descdription: 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 
 * 案例:
 * 
 * s = "leetcode" 返回 0.
 * 
 * s = "loveleetcode", 返回 2.
 * 
 * 
 * 
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * 
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年3月22日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class FirstUniqueCharacterInAString387 {

	/**
	 * 
	 * <p>
	 * Method ：firstUniqChar
	 * <p>
	 * Description :两层for循环遍历，找不重复的元素
	 *
	 * @param s
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年3月22日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public int firstUniqChar(String s) {

		if (s == null || s.length() == 0)
			return -1;
		if (s.length() == 1)
			return 0;

		for (int i = 0; i < s.length(); i++) {

			// 元素出现的次数
			int count = 0;
			for (int j = 0; j < s.length(); j++) {

				if (s.charAt(i) == (s.charAt(j)))
					count++;
				if (count > 1)
					break;
			}

			if (count == 1) // 出现一次表示没有重复
				return i;
		}

		return -1;
	}
}
