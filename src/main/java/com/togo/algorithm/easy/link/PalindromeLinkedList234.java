package com.togo.algorithm.easy.link;

import com.togo.algorithm.easy.link.ReverseLinkedList206.ListNode;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.easy.link.PalindromeLinkedList234
 * <p>
 * Descdription:请判断一个链表是否为回文链表。
 * 
 * 示例 1:
 * 
 * 输入: 1->2 输出: false
 * 
 * 示例 2:
 * 
 * 输入: 1->2->2->1 输出: true
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
public class PalindromeLinkedList234 {

	/**
	 * 
	 * <p>
	 * Method ：isPalindrome
	 * <p>
	 * Description :通过快慢指针寻找到中间点，然后将中间点后的链表翻转，比较前半部分和后半部分，相同则是会问链表
	 *
	 * @param head
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年3月22日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public boolean isPalindrome(ListNode head) {

		if (head == null)
			return true;
		if (head.next == null)
			return true;

		ListNode fast = head;
		ListNode slow = head;

		// 快慢指针查找中间点
		while (fast.next != null && fast.next.next != null) {

			fast = fast.next.next;
			slow = slow.next;
		}

		// 翻转后半部分
		ListNode reNode = reverse(slow.next);

		while (reNode != null) { // 循环比较两部分链表

			if (head.val != reNode.val)
				return false;
			head = head.next;
			reNode = reNode.next;
		}

		return true;
	}

	private ListNode reverse(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode newHead = reverse(head.next);
		head.next.next = head;
		head.next = null;

		return newHead;
	}
}
