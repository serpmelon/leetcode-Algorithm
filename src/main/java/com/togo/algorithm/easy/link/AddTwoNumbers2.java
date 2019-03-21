package com.togo.algorithm.easy.link;

import com.togo.algorithm.easy.link.ReverseLinkedList206.ListNode;

public class AddTwoNumbers2 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode sumNode = new ListNode(0);

		int a1 = 0;
		int a2 = 0;

		if (l1 != null) {

			a1 = l1.val;
		}

		if (l2 != null) {

			a2 = l2.val;
		}

		sumNode.val = a1 + a2;
		int remain = 0;

		if (sumNode.val > 9) {

			remain = sumNode.val / 10;
			sumNode.val = sumNode.val % 10;
		}

		if (remain > 0) {
			if (l1 != null && l1.next != null) {

				l1.next.val += remain;
			} else if (l2 != null && l2.next != null) {

				l2.next.val += remain;
			} else {

				sumNode.next = new ListNode(remain);

				return sumNode;
			}
		}

		if (l1.next == null && l2.next == null) {

			return sumNode;
		}

		if (l1.next != null && l2.next != null) {

			sumNode.next = addTwoNumbers(l1.next, l2.next);
		}

		if (l1.next == null) {

			sumNode.next = addTwoNumbers(new ListNode(0), l2.next);
		}

		if (l2.next == null) {

			sumNode.next = addTwoNumbers(l1.next, new ListNode(0));
		}

		return sumNode;

	}
}
