package com.togo.algorithm.medium.link;

import com.togo.algorithm.easy.link.ReverseLinkedList206.ListNode;

/**
 * 
 * @author AI
 * @desc 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 
 *       请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * 
 *       示例 1:
 * 
 *       输入: 1->2->3->4->5->NULL 输出: 1->3->5->2->4->NULL
 * 
 *       示例 2:
 * 
 *       输入: 2->1->3->5->6->4->7->NULL 输出: 2->3->6->7->1->5->4->NULL
 * 
 *       说明:
 * 
 *       应当保持奇数节点和偶数节点的相对顺序。 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 * 
 * 
 * @date 2019年5月3日
 *
 */
public class OddEvenLinkedList328 {

	/**
	 * 
	 * @author AI
	 * @desc 创建奇数头和偶数头，然后将奇数的节点连接到奇数头后面，偶数同上
	 * 
	 * @param head
	 * @return
	 *
	 * @date 2019年5月3日
	 */
	public ListNode oddEvenList(ListNode head) {

		// 如果链表长度为0/1/2则直接返回链表
		if (head == null || head.next == null || head.next.next == null)
			return head;

		// 其实这里直接可以用head当做奇链表头
		// 奇链表头
		ListNode odd = head;
		// 奇链表尾
		ListNode oddP = head;
		// 同上
		ListNode even = head.next;
		ListNode evenP = head.next;

		do {
			// 交替把节点连接到奇数或偶数后面
			oddP.next = evenP.next;
			oddP = oddP.next;
			evenP.next = oddP.next;
			evenP = evenP.next;
		} while (oddP.next != null && evenP.next != null);

		// 最后将偶数连到奇数最后
		oddP.next = even;

		return odd;
	}
}
