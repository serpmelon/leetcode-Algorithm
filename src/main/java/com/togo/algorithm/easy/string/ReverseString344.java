package com.togo.algorithm.easy.string;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.easy.string.ReverseString344
 * <p>
 * Descdription: 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：["h","e","l","l","o"] 输出：["o","l","l","e","h"]
 * 
 * 示例 2：
 * 
 * 输入：["H","a","n","n","a","h"] 输出：["h","a","n","n","a","H"]
 *
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
public class ReverseString344 {

	/**
	 * 
	 * <p>
	 * Method ：reverseString
	 * <p>
	 * Description :翻转数组，就是将数组前后对应的元素交换
	 *
	 * @param s
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年3月22日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public void reverseString(char[] s) {

		int length = s.length;
		if (length <= 1)
			return;

		// 交换对应元素
		for (int i = 0; i < length / 2; i++) {

			swap(s, i, length - 1 - i);
		}
	}

	/**
	 * 
	 * <p>
	 * Method ：swap
	 * <p>
	 * Description :交换数组中的两个元素
	 *
	 * @param s
	 * @param i
	 * @param j
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年3月22日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	private void swap(char[] s, int i, int j) {

		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}
}
