package com.togo.algorithm.medium.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author taiyn
 * @Description 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * @Date 9:43 上午 2020/12/3
 **/
public class CoinChange322 {

    /**
     * @return int
     * @Author taiyn
     * @Description 动态规划dp是一个自底向上的一个过程, 即从0 到n;
     * dp[i]表示凑够i元需要的最少硬币数量, 比如dp[11]表示凑够11需要的最少硬币数量, 可以很容易想到,
     * dp[11] = dp[10] + 1, 1表示的是一个1元硬币, 转换为变量形式dp[i] = dp[i - coin] + 1. 这里的coin就是参数提供的数组中的某个元素,
     * 需要我们遍历获取到最小值.
     * @Date 9:43 上午 2020/12/3
     * @Param [coins, amount]
     **/
    public int coinChange_1(int[] coins, int amount) {

        // 初始化dp, 多一个位置是为了处理0
        int[] dp = new int[amount + 1];
        // 凑够0需要0个硬币
        dp[0] = 0;
        // 初始化数组, 因为要求最小值, 所以这里设置大值. amount最多可以使用amount个1硬币,
        // 所以如果可以使用硬币凑够的话数组的值一定小于amount + 1
        Arrays.fill(dp, amount + 1);

        // 遍历每个数字
        for (int i = 1; i < amount + 1; i++) {

            // 尝试每一个硬币
            for (int coin : coins) {

                // 不满足的直接跳过
                if (i - coin < 0) continue;

                // 每次取最小值, 因为是在循环中, 后面的dp[i]有可能是前面算出来的值, 所以这里不能直接等于dp[i - coin] + 1
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // dp的值如果等于amount + 1, 说明不可能凑够则返回-1;
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    int[] coins;
    int amount;
    Map<Integer, Integer> dic = new HashMap<>();

    /**
     * @return int
     * @Author taiyn
     * @Description 同样是动态规划, 下面这个方法体现了自顶向下的思想. 计算思路一致, 需要注意的是重复计算的问题, 这里构建一个map
     * 记录中间结果
     * @Date 11:05 上午 2020/12/3
     * @Param [coins, amount]
     **/
    public int coinChange_2(int[] coins, int amount) {
        this.coins = coins;
        this.amount = amount;
        return dp(amount);
    }

    private int dp(int i) {

        // 一些边界问题
        if (i == 0) return 0;
        if (i < 0) return -1;

        // 先从字典中查找
        Integer dicResult = dic.get(i);
        if (dicResult != null) return dicResult;

        // 同样设置一个大值
        int result = amount + 1;
        // 循环遍历同上
        for (int coin : coins) {
            int r = dp(i - coin);
            if (r == -1) continue;

            result = Math.min(r + 1, result);
        }
        result = result == amount + 1 ? -1 : result;
        // 结果记录在map中
        dic.put(i, result);
        return result;
    }
}
