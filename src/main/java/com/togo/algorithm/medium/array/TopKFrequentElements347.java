package com.togo.algorithm.medium.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.medium.array.TopKFrequentElements347
 * <p>
 * Descdription:给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 
 * 示例 1:
 * 
 * 输入: nums = [1,1,1,2,2,3], k = 2 输出: [1,2]
 * 
 * 示例 2:
 * 
 * 输入: nums = [1], k = 1 输出: [1]
 * 
 * 说明：
 * 
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 你的算法的时间复杂度必须优于 O(n log n) , n
 * 是数组的大小。
 *
 * 
 * 
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年4月17日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class TopKFrequentElements347 {

	/**
	 * 
	 * <p>
	 * Method ：topKFrequent
	 * <p>
	 * Description :思路是先将出现次数存储到map中，然后创建多个桶，按照出现次数将元素放到桶中，最后按照从尾到首的顺序将元素放到返回的list中
	 *
	 * @param nums
	 * @param k
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年4月17日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	@SuppressWarnings("unchecked")
	public List<Integer> topKFrequent(int[] nums, int k) {

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : nums) { // 统计频率，key为元素，value为次数

			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		// 创建nums.length + 1个桶
		List<Integer>[] bucket = new List[nums.length + 1];

		// 遍历map，根据value值放到对应的桶中
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {

			Integer value = e.getValue();
			if (bucket[value] == null) {
				bucket[value] = new ArrayList<Integer>();
			}

			bucket[value].add(e.getKey());
		}

		List<Integer> freList = new ArrayList<>();
		// 桶的编号表示出现次数，所以倒数桶
		for (int j = bucket.length - 1; j > -1 && freList.size() < k; j--) {

			if (bucket[j] != null)
				freList.addAll(bucket[j]);
		}

		return freList;
	}
}
