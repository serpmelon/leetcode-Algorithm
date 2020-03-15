package com.togo.algorithm.medium.design;

/**
 * @Author taiyn
 * @Description 请你设计一个支持下述操作的栈。
 * <p>
 * 实现自定义栈类 CustomStack ：
 * <p>
 * CustomStack(int maxSize)：用 maxSize 初始化对象，maxSize 是栈中最多能容纳的元素数量，栈在增长到 maxSize 之后则不支持 push 操作。
 * void push(int x)：如果栈还未增长到 maxSize ，就将 x 添加到栈顶。
 * int pop()：返回栈顶的值，或栈为空时返回 -1 。
 * void inc(int k, int val)：栈底的 k 个元素的值都增加 val 。如果栈中元素总数小于 k ，则栈中的所有元素都增加 val 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-a-stack-with-increment-operation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 8:25 下午 2020/3/15
 **/
public class DesignAStackWithIncrementOperation5357 {

    private int index = -1;
    private int[] stack;
    private int maxSize;

    /**
     * @Author taiyn
     * @Description 通过一个数组存储数据, 并通过一个指针指向当前栈顶
     *
     * @Date 8:26 下午 2020/3/15
     * @Param [maxSize]
     * @return
     **/
    public DesignAStackWithIncrementOperation5357(int maxSize) {

        this.stack = new int[maxSize];
        this.maxSize = maxSize;
    }

    public void push(int x) {

        index++;
        if (index < maxSize)
            stack[index] = x;
        else
            index--;
    }

    public int pop() {
        if (index < 0)
            return -1;
        int result = stack[index];
        index--;
        return result;
    }

    public void increment(int k, int val) {

        for (int i = 0; i <= index && k > 0; i++, k--) {
            stack[i] = stack[i] + val;
        }
    }
}
