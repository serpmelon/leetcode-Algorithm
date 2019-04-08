package com.togo.algorithm.medium.link;

import com.togo.algorithm.easy.link.ReverseLinkedList206.ListNode;

/**
 * 
 * <p>
 * Method ：longestPalindrome
 * <p>
 * Description 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位
 * 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 *
 * 
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
public class AddTwoNumbers2 {

	/**
	 * 迭代，当前两个节点相加，然后对next节点继续操作
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		return addTwoNumbers(l1, l2, 0);
	}

	private ListNode addTwoNumbers(ListNode l1, ListNode l2, int r) {

		ListNode l1next = null;
		ListNode l2next = null;

		if (l1 != null)
			l1next = l1.next;
		if (l2 != null)
			l2next = l2.next;

		if (r == 0) {
			if (l1 == null)
				return l2;
			if (l2 == null)
				return l1;
		}

		int val_1 = l1 == null ? 0 : l1.val;
		int val_2 = l2 == null ? 0 : l2.val;

		int val = val_1 + val_2 + r;

		ListNode newNode = new ListNode(val % 10);
		newNode.next = addTwoNumbers(l1next, l2next, val / 10);

		return newNode;
	}
}
