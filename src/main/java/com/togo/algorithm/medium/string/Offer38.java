package com.togo.algorithm.medium.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author taiyn
 * @Description 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * <p>
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= s 的长度 <= 8
 * @Date 9:35 下午 2020/11/24
 **/
public class Offer38 {

    List<String> res = new LinkedList<>();
    char[] c;

    /**
     * @Author taiyn
     * @Description 做这个提还是应该想象下栈执行
     *
     * @Date 10:19 下午 2020/11/24
     * @Param [s]
     * @return java.lang.String[]
     **/
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c)); // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x); // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1); // 开启固定第 x + 1 位字符
            swap(i, x); // 恢复交换
        }
    }

    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    public static void main(String[] args) {

        Offer38 offer38 = new Offer38();
        offer38.permutation("abc");
    }
}
