package com.togo.algorithm.medium.link;

import com.togo.algorithm.common.ListNode;

/**
 * <p>给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author taiyn
 * @version 1.0
 * @date Created in 2020年01月07日 08:49
 * @since 1.0
 */
public class RemoveNthNodeFromEndofList19 {

    /**
     * <pre>
     * desc : 一次遍历实现;
     * 设置两个指针, 一前一后, 中间间隔n个节点, 这样当前节点到达最后时, 后节点就是要删除节点的前驱节点.
     * @author : taiyn
     * date : 2020-01-07 08:52
     * @param : [head, n]
     * @return com.togo.algorithm.common.ListNode
     * </pre>
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (n <= 0)
            return head;

        // 设置哑结点, 方便处理边界条件
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 后节点
        ListNode back = dummy;
        // 前节点
        ListNode forward = dummy;

        while (forward.next != null) {

            forward = forward.next;
            if (n == 0)
                back = back.next;
            else
                n--;
        }

        back.next = back.next.next;
        return dummy.next;

    }
}