package com.togo.algorithm.easy.search;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.easy.search.FirstBadVersion278
 * <p>
 * Descdription:你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version
 * 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * 
 * 示例:
 * 
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 * 
 * 调用 isBadVersion(3) -> false 调用 isBadVersion(5) -> true 调用 isBadVersion(4) ->
 * true
 * 
 * 所以，4 是第一个错误的版本。
 *
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年3月25日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class FirstBadVersion278 {

	/**
	 * 
	 * <p>
	 * Method ：firstBadVersion
	 * <p>
	 * Description :二分查找，在遇到有序的数据时，可以考虑这种算法
	 *
	 * @param n
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年3月25日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public int firstBadVersion(int n) {

		int high = n;
		int low = 1;

		while (high > low) {
			// 每次找到中间值
			int mid = low + (high - low) / 2;
			if (isBadVersion(mid)) { // 中间值是bad则将最高值指向中间值
				high = mid;
			} else {
				// 中间不是bad则将最低值指向中间值，并+1，这里不+1，则会一直停留在某个值上，
				// 陷入死循环。比如最后一个值是bad，不+1的话low永远到不了最后一个值。
				// 比如到最后，low = n-1, high = n, 那么low + (high - low) / 2;结果永远是n-1
				low = mid + 1;
			}
		}

		return high;
	}

	private boolean isBadVersion(int i) {
		return true;
	}

}
