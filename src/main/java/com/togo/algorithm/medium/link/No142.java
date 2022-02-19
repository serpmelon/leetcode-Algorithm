package com.togo.algorithm.medium.link;

import com.togo.algorithm.common.ListNode;
import com.togo.algorithm.easy.link.No141;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author taiyn
 * @Description 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 *
 * @Date 下午12:25 2022/2/19
 **/
public class No142 {

    /**
     * @see No141
     * 与141相同, 这个就是要找到进入环的起点.
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        boolean hasCycle = false;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if(!hasCycle) return null;

        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    /**
     * 通过hashset记录每一个节点, 当出现重复节点的时候表示绕了一圈回来了, 也就是入口.
     * @param head
     * @return
     */
    public ListNode detectCycleByHashSet(ListNode head) {

        ListNode p = head;
        Set<ListNode> set = new HashSet<>();
        while(p != null) {
            if(set.contains(p)) return p;
            set.add(p);
            p = p.next;
        }

        return null;
    }
}
