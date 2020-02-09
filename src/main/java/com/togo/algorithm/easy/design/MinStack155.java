package com.togo.algorithm.easy.design;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author taiyn
 * @version 1.0
 * @date Created in 2020年02月09日 09:05
 * @since 1.0
 */
class MinStack155 {

    interface MinStack {
        void push(int x);

        void pop();

        int top();

        int getMin();
    }

    static class MinStackOne {
        private Node head;

        /**
         * initialize your data structure here.
         */
        public MinStackOne() {

        }

        public void push(int x) {

            Node node = new Node(x);
            node.next = head;
            if (head == null)
                node.min = node.num;
            else if (head.min > node.num)
                node.min = node.num;
            else
                node.min = head.min;

            head = node;
        }

        public void pop() {

            if (head == null)
                return;

            head = head.next;
        }

        public int top() {

            if (head == null)
                throw new RuntimeException();
            return head.num;
        }

        public int getMin() {
            return head.min;
        }
    }

    static class Node {
        private int num;
        private Node next;
        private int min;

        Node(int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) {

        MinStackOne obj = new MinStackOne();
        int x = 10;
        obj.push(x);
        x = 20;
        obj.push(x);
        x = 30;
        obj.push(x);
        x = 40;
        obj.push(x);
        obj.push(5);
        obj.push(4);
        obj.push(10);
        obj.pop();
        System.out.println(obj.getMin());
        int param_3 = obj.top();
        obj.pop();
        System.out.println(obj.getMin());
        int param_4 = obj.top();
        System.out.println(param_3 + ", " + param_4);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */