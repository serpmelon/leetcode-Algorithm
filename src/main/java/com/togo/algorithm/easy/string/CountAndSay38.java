package com.togo.algorithm.easy.string;

/**
 * <p>
 * Class : com.togo.algorithm.easy.string.FirstUniqueCharacterInAString387
 * <p>
 * Descdription: 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * <p>
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * <p>
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 *
 * @author taiyn
 * @version 1.0.0
 * <p>
 * --------------------------------------------------------------<br>
 * 修改履历：<br>
 * <li>2019年5月17日，taiyn，创建文件；<br>
 * --------------------------------------------------------------<br>
 * </p>
 */
public class CountAndSay38 {

    /**
     * desc: 这是一个动态规划的问题，后面一个数字的结果依赖上一个数字，所以整体思路就是对上一个数字的结果进行操作拼接
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {

        if (n < 1)
            return null;
        if (n == 1)
            return "1";

        // 大于1就进行迭代操作
        String result = countAndSay(--n);

        // 从第一个元素开始循环，则第零个元素出现次数为1
        int count = 1;
        StringBuilder sb = new StringBuilder();

        // 从第一个元素开始循环
        for (int i = 1; i < result.length(); i++) {

            // 如果当前元素和上一个元素相等则计数加1
            if (result.charAt(i - 1) == result.charAt(i))
                count++;
            else {// 否则则将之前的数字拼接到字符串上，重置计数为1，表示当前元素出现次数
                sb.append(count + "");
                sb.append(result.charAt(i - 1));
                count = 1;
            }
        }

        // 循环中每次拼接的是上一个元素，所以循环后需要将最后的元素拼接进去
        sb.append(count + "");
        sb.append(result.charAt(result.length() - 1));

        return sb.toString();
    }
}
