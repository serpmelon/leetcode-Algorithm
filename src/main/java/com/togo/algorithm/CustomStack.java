package com.togo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 11:43 上午 2020/3/15
 **/
class CustomStack {

    private int index = -1;
    private List<Integer> list;
    private int maxSize;

    public CustomStack(int maxSize) {

        this.list = new ArrayList<>(maxSize);
        this.maxSize = maxSize;
    }

    public void push(int x) {

        index++;
        if (index < maxSize)
            list.set(index, x);
        else
            index--;
        System.out.println(toString());
    }

    public int pop() {
        if (index < 0)
            return -1;
        int result = list.get(index);
        index--;
        System.out.println(toString());
        return result;
    }

    public void increment(int k, int val) {

        for (int i = index; i > -1 && k > 0; i--, k--) {
            list.set(i, list.get(i) + val);
        }
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "CustomStack{" +
                "index=" + index +
                ", list=" + list +
                ", maxSize=" + maxSize +
                '}';
    }

    public static void main(String[] args) {

        CustomStack stack = new CustomStack(3);
//        "CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop";

        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(3);
        stack.push(4);
        stack.increment(5, 100);
        stack.increment(2, 100);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }
}

