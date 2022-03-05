package com.togo.algorithm.competition.hard;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 下午12:15 2022/2/20
 **/
public class No6015 {

    public long coutPairsCorrect(int[] nums, int k) {
        int[] count = new int[100001];
        for (int num : nums) {
            count[num]++;
        }
        Long dp[] = new Long[100001], result = 0L;
        for (int num : nums) {
            int gcd = k / BigInteger.valueOf(num).gcd(BigInteger.valueOf(k)).intValue();
            if (dp[gcd] == null) {
                dp[gcd] = 0L;
                for (int i = gcd; i <= 100000; i += gcd) {
                    dp[gcd] += count[i];
                }
            }
            result += dp[gcd] - (num % gcd > 0 ? 0 : 1);
        }
        return result / 2;
    }

    public long coutPairs(int[] nums, int k) {

        Map<String, Boolean> map = new HashMap<>();
        long count = 0L;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (map.getOrDefault(i + "+" + j + "," + j + "+" + i, false)) {
                    count++;
                } else {
                    if (nums[i] * nums[j] % k == 0) {
                        map.put(i + "+" + j + "," + j + "+" + i, true);
                        count++;
                    } else {
                        map.put(i + "+" + j + "," + j + "+" + i, false);
                    }
                }

            }
        }

        return count;
    }
}
