package com.togo.algorithm.easy.link;

import com.togo.algorithm.common.ListNode;

/**
 * @Author taiyn
 * @Description 给你单链表的头指针 head 和两个整数 left 和 right ，
 * 其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * @Date 上午11:36 2022/2/26
 **/
public class No92 {

    /**
     * 第一版自己写的递归实现
     */
    int end;
    ListNode endNode;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        end = right;
        int index = 1;
        ListNode p = head, pre = null;
        while(p != null && index < left) {
            index++;
            pre = p;
            p = p.next;
        }

        ListNode last = reverse(p, index);
        if(pre != null) {
            pre.next = last;
            return head;
        }

        return last;
    }

    private ListNode reverse(ListNode node, int index) {
        if(index >= end || node.next == null) {
            endNode = node.next;
            return node;
        }
        index++;
        ListNode last = reverse(node.next, index);
        node.next.next = node;
        node.next = endNode;
        return last;
    }
}
