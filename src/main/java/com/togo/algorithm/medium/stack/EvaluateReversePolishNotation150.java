package com.togo.algorithm.medium.stack;

import java.util.LinkedList;

/**
 * <p>根据逆波兰表示法，求表达式的值。
 * <p>
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 说明：
 * <p>
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 * <p>
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * 示例 2：
 * <p>
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * 示例 3：
 * <p>
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author taiyn
 * @version 1.0
 * @date Created in 2019年07月02日 09:40
 * @since 1.0
 */
public class EvaluateReversePolishNotation150 {

    /**
     * <pre>
     * desc : 使用链表构造栈，当遇到操作符则弹出最上面两个数字进行相应操作；当遇到数字则入栈；
     * @author : taiyn
     * date : 2019-07-02 09:41
     * @param tokens 表达式
     * @return int
     * </pre>
     */
    public int evalRPN_0(String[] tokens) {

        LinkedList<Integer> stack = new LinkedList<>();

        String add = "+";
        String subtract = "-";
        String multipl = "*";
        String divide = "/";

        for (String s : tokens) {

            int result = 0;
            if (add.equals(s)) {

                result = add(stack);
            } else if (subtract.equals(s)) {

                result = subtract(stack);
            } else if (multipl.equals(s)) {

                result = multipl(stack);
            } else if (divide.equals(s)) {

                result = divide(stack);
            } else {

                result = Integer.parseInt(s);
            }

            stack.push(result);
        }

        int result = stack.pop();
        return result;
    }

    private int add(LinkedList<Integer> stack) {

        int ia = popNum(stack);
        int ib = popNum(stack);

        return ia + ib;
    }

    private int subtract(LinkedList<Integer> stack) {

        int ia = popNum(stack);
        int ib = popNum(stack);

        return ib - ia;
    }

    private int multipl(LinkedList<Integer> stack) {

        int ia = popNum(stack);
        int ib = popNum(stack);

        return ia * ib;
    }

    private int divide(LinkedList<Integer> stack) {

        int ia = popNum(stack);
        int ib = popNum(stack);

        return ib / ia;
    }

    private int popNum(LinkedList<Integer> stack) {

        return stack.pop();
    }


    /**
     * <pre>
     * desc : 原理都一样，使用数组实现栈，速度飞起，而且空间还比之前小。。。。
     * @author : taiyn
     * date : 2019-07-02 13:52
     * @param [tokens]
     * @return int
     * </pre>
     */
    public int evalRPN(String[] tokens) {

        if (tokens == null || tokens.length == 0)
            return 0;

        int[] stack = new int[tokens.length];
        int top = -1;

        for (String s : tokens) {

            int right = 0, left = 0;
            switch (s) {
                case "+":
                    right = stack[top--];
                    left = stack[top];
                    stack[top] = right + left;
                    break;
                case "-":
                    right = stack[top--];
                    left = stack[top];
                    stack[top] = left - right;
                    break;
                case "*":
                    right = stack[top--];
                    left = stack[top];
                    stack[top] = left * right;
                    break;
                case "/":
                    right = stack[top--];
                    left = stack[top];
                    stack[top] = left / right;
                    break;
                default:
                    stack[++top] = Integer.parseInt(s);
                    break;
            }
        }

        return stack[top];
    }
}