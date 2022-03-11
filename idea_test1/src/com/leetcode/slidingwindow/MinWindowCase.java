package com.leetcode.slidingwindow;
/*
 *  @author changqi
 *  @date 2022/2/16 15:39
 *  @description 76. 最小覆盖子串
 *  @Version V1.0
 */

import java.util.HashMap;
import java.util.Map;

public class MinWindowCase {
    public static void main(String[] args) {

        String s = "ADOBECODEBANCC";
        String t = "ABC";

        String s1 = minWindow(s, t);
        System.out.println(s1);
    }

    public static String minWindow(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> sliding = new HashMap<>();

        int start = 0;
        int end = 0;
        String res = s;
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        while (end < s.length()) {

            char cur = s.charAt(end);
            if (map.containsKey(cur) && sliding.getOrDefault(cur, 0) < map.get(cur)) {
                sliding.put(cur, sliding.getOrDefault(cur, 0) + 1);
            }

            while (map.equals(sliding)) {
                res = res.length() < s.substring(start, end+1).length() ? res : s.substring(start, end + 1);
                cur = s.charAt(start);
                if (sliding.containsKey(cur)) {
                    sliding.put(cur, sliding.get(cur) - 1);
                    if (sliding.get(cur) == 0) sliding.remove(cur);
                }


                start++;


            }
            end++;
        }

        return res.equals(s) ? "" : res;
    }
}
