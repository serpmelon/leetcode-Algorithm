package com.togo.algorithm.medium.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.medium.string.GroupAnagrams49
 * <p>
 * Descdription:给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"], 输出: [ ["ate","eat","tea"],
 * ["nat","tan"], ["bat"] ]
 * 
 * 说明：
 * 
 * 所有输入均为小写字母。 不考虑答案输出的顺序。
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
public class GroupAnagrams49 {

	/**
	 * 
	 * <p>
	 * Method ：groupAnagrams
	 * <p>
	 * Description :将每组字符串排序，然后将结果作为key存储到map中，value是这个key值对应的list
	 *
	 * @param strs
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年3月30日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public List<List<String>> groupAnagrams(String[] strs) {

		if (strs.length == 0)
			return new ArrayList<>();

		HashMap<String, List<String>> maps = new HashMap<>();
		for (String s : strs) {
			char[] c = s.toCharArray();
			// 排序
			Arrays.sort(c);
			String key = String.valueOf(c);
			if (!maps.containsKey(key)) // map中没有则创建一个新的
				maps.put(key, new ArrayList<>());
			maps.get(key).add(s);
		}

		return new ArrayList<>(maps.values());
	}
}
