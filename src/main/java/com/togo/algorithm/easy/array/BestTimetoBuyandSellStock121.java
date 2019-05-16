package com.togo.algorithm.easy.array;

/**
 * <p>
 * Class : com.togo.algorithm.easy.BestTimetoBuyandSellStock121
 * <p>
 * Descdription:给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4] 输出: 5 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润
 * = 6-1 = 5 。 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1] 输出: 0 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * @author taiyn
 * @version 1.0.0
 * <p>
 * --------------------------------------------------------------<br>
 * 修改履历：<br>
 * <li>2019年3月7日，taiyn，创建文件；<br>
 * --------------------------------------------------------------<br>
 * </p>
 */
public class BestTimetoBuyandSellStock121 {

    /**
     * <p>
     * Method ：maxProfit
     * <p>
     * Description :思路，我们把数组中的数字画在坐标系中，会发现，我们所要求的就是波峰和波谷的最大差值，所以我们只需要记录波峰和波谷就可以了
     *
     * @param prices
     * @return
     * @author taiyn
     * <p>
     * --------------------------------------------------------------<br>
     * 修改履历：<br>
     * <li>2019年3月7日，taiyn，创建方法；<br>
     * --------------------------------------------------------------<br>
     * </p>
     */
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) {
            return 0;
        }

        // 波谷
        int min = Integer.MAX_VALUE;
        // 波峰
        int max = 0;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < min) // 当前数小于波谷则为新波谷
                min = prices[i];
            else if (prices[i] - min > max) // 当前数减去波谷的值大于波峰，则为新波峰
                max = prices[i] - min;
        }

        return max;
    }
}
