package com.togo.algorithm.medium.binarySearch;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 上午8:38 2022/2/14
 **/
public class No875 {

    public int minEatingSpeed(int[] piles, int h) {

        int left = 1, right = max(piles);
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(mid, piles) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int max(int[] piles) {
        int max = 0;
        for (int i : piles) {
            max = Math.max(max, i);
        }
        return max;
    }

    private int f(int x, int[] piles) {
        int hour = 0;
        for (int i : piles) {
            hour += i / x;
            if (i % x != 0) {
                hour++;
            }
        }

        return hour;
    }

    public static void main(String[] args) {

        int[] piles = new int[]{3, 6, 7, 11};
        int target = 8;
        No875 no875 = new No875();
        System.out.println(no875.minEatingSpeed(piles, target));
    }
}
