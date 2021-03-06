package com.togo.algorithm.easy.array;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.easy.array.BestTimeToBuyAndSellStockII122
 * <p>
 * Descdription:与121题的差别是本题可以进行多次交易； 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 
 * 示例 1:
 * 
 * 输入: [7,1,5,3,6,4] 输出: 7 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出,
 * 这笔交易所能获得利润 = 5-1 = 4 。 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出,
 * 这笔交易所能获得利润 = 6-3 = 3 。
 * 
 * 示例 2:
 * 
 * 输入: [1,2,3,4,5] 输出: 4 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出,
 * 这笔交易所能获得利润 = 5-1 = 4 。 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 
 * 示例 3:
 * 
 * 输入: [7,6,4,3,1] 输出: 0 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 
 * 
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年4月15日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class BestTimeToBuyAndSellStockII122 {

	/**
	 * 
	 * <p>
	 * Method ：maxProfit
	 * <p>
	 * Description :思路：当后一个值大于前一个值，则计算两者差值，差值即为一天的收益，直到数组结束
	 *
	 * @param prices
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年4月15日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public int maxProfit(int[] prices) {

		if (prices == null || prices.length == 0)
			return 0;

		// 收益
		int profit = 0;

		// 遍历数组
		for (int i = 1; i < prices.length; i++) {

			// 当价格上涨
			if (prices[i] > prices[i - 1]) {
				// 收益再加上当前收益
				profit += prices[i] - prices[i - 1];
			}
			// 价格没有上涨则继续
		}

		return profit;
	}
}
