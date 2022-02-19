package com.togo.algorithm.easy.link;

import com.togo.algorithm.common.ListNode;

/**
 * @Author taiyn
 * @Description 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
 * 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 * @Date 上午11:04 2022/2/19
 **/
public class No141 {

    /**
     * 设置快慢指针, 若链表有环, 则快指针必定会对慢指针套圈, 所以通过判断快慢指针是否相等就可以判断是否有环.
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        // 初始化指针
        ListNode slow = head, fast = head;

        // 快指针为null了表示链表尾了, 不存在环
        while (fast != null && fast.next != null) {
            // 慢指针走一步
            slow = slow.next;
            // 快指针走两步
            fast = fast.next.next;
            // 相等则表示有环
            if (slow == fast) return true;
        }
        // 循环结束表示没有环
        return false;
    }
}
