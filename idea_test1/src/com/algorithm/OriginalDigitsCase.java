package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/24 9:34
 *  @description
 *  @Version V1.0
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OriginalDigitsCase {
    public static String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};


    public static void main(String[] args) {
        //String s = ;
        String[] ss = {"0001","00011", "0123456789", "000122344569"};
        String[] s = {"zerozerozeroone","zeorzerozerooneone", "zeroonetwothreefourfivesixseveneightnine", "zeorzerozeroonetwotwothreefivefourfoursixnien"};
        //String s = ;
        for (int i = 0; i < s.length; i++) {
            System.out.println(ss[i]);
            System.out.println(originalDigits(s[i]));
            System.out.println("-----------");
        }


    }


    public static String originalDigits(String s) {


        Map<Character, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int[] cnt = new int[10];

        cnt[0] = map.getOrDefault('z',0);
        cnt[2] = map.getOrDefault('w',0);
        cnt[4] = map.getOrDefault('u',0);
        cnt[6] = map.getOrDefault('x',0);
        cnt[8] = map.getOrDefault('g',0);

        cnt[1] = map.getOrDefault('o',0)-cnt[0]-cnt[2]-cnt[4];
        cnt[3] = map.getOrDefault('r',0)-cnt[0]-cnt[4];
        cnt[5] = map.getOrDefault('f',0)-cnt[4];
        cnt[7] = map.getOrDefault('v',0)-cnt[5];
        cnt[9] = map.getOrDefault('n',0)-cnt[1]-cnt[7];
        cnt[9] = cnt[9]/2;
        String ans = "";
        int i=0;
        while(i<=9){
            if(cnt[i]!=0){
                ans = ans+i;
                cnt[i]--;
            } else {
                i++;
            }
        }
        return ans;
        /*

        Map<Character, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        backTrack(map, list, "", 0);

        return list.isEmpty() ? "" : list.get(0);*/
    }

    public static void backTrack(Map<Character, Integer> map, List<String> list, String res, int index) {
        if (map.isEmpty()) {
            list.add(res);
            return;
        }

        int num = index;
         String temp = "";
        while (num <= 9 && !map.isEmpty()) {
            //String temp = "";
            for (int i = 0; i < nums[num].length(); i++) {
                char c = nums[num].charAt(i);
                if (map.containsKey(c) && map.get(c) > 0) {
                    temp = temp + c;
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) == 0) {
                        map.remove(c);
                    }
                } else {
                    for (char ch : temp.toCharArray()) {
                        map.put(ch, map.getOrDefault(ch, 0) + 1);
                    }
                    temp = "";
                    num++;
                    return;
                }
            }
            if (num < 10) {
                backTrack(map, list, res + (temp.equals(nums[num]) ? num : ""), num + 1);
                res = res + (temp.equals(nums[num]) ? num : "");
            }


        }
        if (index > 9 && !map.isEmpty()) {
            return;
        }

    }

}
