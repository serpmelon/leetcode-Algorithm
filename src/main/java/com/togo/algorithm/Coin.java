package com.togo.algorithm;

public class Coin {

	public static int countWays(int n) {
		// write code here
		int[] coins = { 1, 5, 10, 25 };
		int[] dp = new int[10001];
		dp[0] = 1;
		for (int i = 0; i < 4; ++i) {
			for (int j = coins[i]; j <= n; ++j) {
				dp[j] = (dp[j] + dp[j - coins[i]]);
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		int n = 5;
		System.out.println(countWays(n));
	}

}
