package com.togo.algorithm.easy.link;


import com.togo.algorithm.common.ListNode;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.easy.link.IntersectionOfTwoLinkedLists160
 * <p>
 * Descdription: 编写一个程序，找到两个单链表相交的起始节点。
 * 
 * 如下面的两个链表：
 * 
 * 在节点 c1 开始相交。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2,
 * skipB = 3 输出：Reference of the node with value = 8 输入解释：相交节点的值为 8
 * （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A
 * 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * 
 * 
 * 
 * 示例 2：
 * 
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
 * 1 输出：Reference of the node with value = 2 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为
 * 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B
 * 中，相交节点前有 1 个节点。
 * 
 * 
 * 
 * 示例 3：
 * 
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以
 * intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。 解释：这两个链表不相交，因此返回 null。
 * 
 * 
 * 
 * 注意：
 * 
 * 如果两个链表没有交点，返回 null. 在返回结果后，两个链表仍须保持原有的结构。 可假定整个链表结构中没有循环。 程序尽量满足 O(n)
 * 时间复杂度，且仅用 O(1) 内存。
 *
 * 
 * 
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年4月12日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class IntersectionOfTwoLinkedLists160 {

	/**
	 * 
	 * <p>
	 * Method ：getIntersectionNode
	 * <p>
	 * Description :思路：两个链表相交，则表示从某一个节点开始一直到结束都在一个链表上，判断两个节点是不是相交只要判断两个节点是否相等==，
	 * 这里比较的就是地址。但是两个链表的长度可能不一样，所以笨办法就是两层遍历每一个节点，但是根据我们之前的分析，
	 * 从相交节点开始后面的节点都是一样的，所以我们可以把长链表前端截掉，使得它和短链表长度相等，然后一个一个节点比较
	 *
	 * @param headA
	 * @param headB
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年4月12日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		// 创建临时节点
		ListNode tmpA = headA;
		ListNode tmpB = headB;

		// 记录两个链表的长度
		int lengthA = 0, lengthB = 0;

		// 计算链表长度
		while (tmpA != null) {

			tmpA = tmpA.next;
			lengthA++;
		}

		while (tmpB != null) {

			tmpB = tmpB.next;
			lengthB++;
		}

		// 默认长链表为A，短链表为B
		ListNode longNode = headA;
		ListNode shortNode = headB;

		// 如果默认不对则调整
		if (lengthA < lengthB) {
			longNode = headB;
			shortNode = headA;
		}

		// 计算长度差值
		int step = Math.abs(lengthA - lengthB);

		// 遍历，寻找相同节点
		while (longNode != null && shortNode != null) {

			if (step != 0) {// 首先需要让长链表截掉多出来的部分
				step--;
				longNode = longNode.next;
			} else { // 截掉之后一个一个比较
				if (longNode == shortNode) {
					return longNode;
				} else {
					longNode = longNode.next;
					shortNode = shortNode.next;
				}
			}
		}

		// 没有相交
		return null;
	}
}
