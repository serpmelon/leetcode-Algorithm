package com.togo.algorithm.medium.dp;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 上午8:39 2022/2/15
 **/
public class No300 {

    public int lengthOfLIS(int[] nums) {

        if(nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = dp[0];
        for(int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        No300 no300 = new No300();
        System.out.println(no300.lengthOfLIS(nums));
    }
}
