package com.togo.algorithm.easy.link;

import com.togo.algorithm.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author taiyn
 * @Description 给你两个单链表的头节点 headA 和 headB ，
 * 请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null
 * @Date 下午10:25 2022/2/19
 **/
public class No160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode a = headA, b = headB;

        while(a != b) {
            if(a == null) a = headB;
            else a = a.next;

            if(b == null) b = headA;
            else b = b.next;
        }

        return a;
    }

    public ListNode getIntersectionNodeWithHash(ListNode headA, ListNode headB) {

        ListNode h1 = headA, h2 = headB;
        Set<ListNode> set = new HashSet<>();

        while(h1 != null || h2 != null) {
            if(h1 == h2) return h1;
            if(set.contains(h1)) return h1;
            if(set.contains(h2)) return h2;

            if(h1 != null) {
                set.add(h1);
                h1 = h1.next;
            }
            if(h2 != null) {
                set.add(h2);
                h2 = h2.next;
            }
        }

        return null;
    }
}
