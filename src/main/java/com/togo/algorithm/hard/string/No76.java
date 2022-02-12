package com.togo.algorithm.hard.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 下午11:08 2022/2/12
 **/
public class No76 {
    Map<Character, Integer> tMap = new HashMap<>();
    Map<Character, Integer> currMap = new HashMap<>();

    public String minWindow(String s, String t) {

        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0, r = -1, ansL = -1, ansR = -1;
        int min = Integer.MAX_VALUE;
        while (r < s.length() - 1) {
            r++;
            currMap.put(s.charAt(r), currMap.getOrDefault(s.charAt(r), 0) + 1);
            while (check() && l <= r) {
                if (min >= (r - l + 1)) {
                    min = r - l + 1;
                    ansL = l;
                    ansR = r;
                }

                currMap.put(s.charAt(l), currMap.get(s.charAt(l)) - 1);
                l++;
            }
        }

        return ansL > 0 ? s.substring(ansL, ansR + 1) : "";
    }

    private boolean check() {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            if (currMap.get(entry.getKey()) == null || currMap.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        No76 no76 = new No76();
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(no76.minWindow(s, t));;
    }
}

