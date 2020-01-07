package com.togo.algorithm.easy.link;

import com.togo.algorithm.common.ListNode;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.easy.ReverseLinkedList206
 * <p>
 * Descdription:单链表翻转
 *
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年3月18日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class ReverseLinkedList206 {

	/**
	 * 
	 * <p>
	 * Method ：reverseList
	 * <p>
	 * Description :迭代实现
	 *
	 * @param head
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年3月17日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public static ListNode reverseList_0(ListNode head) {

		if (head == null)
			return head;

		ListNode current = head.next;
		head.next = null;

		while (current != null) {// 每次拿两个节点当做head和current，

			ListNode currentNext = current.next;
			// 当前节点指向前面的节点
			current.next = head;

			head = current;
			current = currentNext;
		}

		return head;
	}

	/**
	 * 
	 * <p>
	 * Method ：reverseList_1
	 * <p>
	 * Description :递归实现
	 *
	 * @param head
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年3月18日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public static ListNode reverseList_1(ListNode head) {

		if (head == null || head.next == null)
			return head;

		// 已经翻转的链表的头节点
		ListNode newNode = reverseList_1(head.next);
		// 在翻转之前，当前节点的下一个节点就是现在翻转后新链表的尾节点，所以将尾节点指向当前节点
		// 原 1 -> 2 -> 3, 设当前节点为1，新翻转链表为 3 ->
		// 2,1节点目前的下一个节点还是2，所以1.next.next指的就是2的下一个节点，这里将1.next.next =
		// 1，就表示2的下一个节点为1，然后将1的下一个节点设置null
		head.next.next = head;
		// 设置当前节点的下一个节点为null
		head.next = null;

		return newNode;
	}

	public static void main(String[] args) {

		ListNode q = new ListNode(1);
		q.next = new ListNode(2);
		q.next.next = new ListNode(3);
		q.next.next.next = new ListNode(4);
		q.next.next.next.next = new ListNode(5);
		q.next.next.next.next.next = new ListNode(6);

		ListNode a = q;

		ListNode b = reverseList_1(q);
		while (b != null) {
			System.out.println(b.val);
			b = b.next;
		}
	}
}
