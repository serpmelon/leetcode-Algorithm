package com.togo.algorithm.easy.link;

import com.togo.algorithm.easy.link.ReverseLinkedList206.ListNode;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.easy.MergeTwoSortedLists
 * <p>
 * Descdription:将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
 *
 * 
 * 
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年3月21日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
class MergeTwoSortedLists21 {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode newHead = new ListNode(0);
		ListNode current = newHead;

		while (l1 != null && l2 != null) {

			if (l1.val <= l2.val) {
				current.next = l1;
				l1 = l1.next;
				current = current.next;
			} else {
				current.next = l2;
				l2 = l2.next;
				current = current.next;
			}
		}

		if (l1 != null) {
			current.next = l1;
		}
		if (l2 != null) {
			current.next = l2;
		}

		return newHead.next;
	}
}
