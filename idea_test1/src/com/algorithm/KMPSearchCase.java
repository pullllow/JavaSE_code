package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/10/21 10:49
 *  @description KMP算法 https://www.cnblogs.com/dusf/p/kmp.html
 *  @Version V1.0
 */

import java.util.Arrays;

public class KMPSearchCase {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        System.out.println(violentMatch(str1, str2));
        int[] next = kmpNext(str2);
        System.out.println(kmpSearch(str1, str2, next));

    }

    public static int violentMatch(String str1, String str2) {
        int i = 0;
        int j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == str2.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    //根据最大长度表和根据next数组进行匹配两种方案

    /**
     * @param str1
     * @param str2
     * @param next
     * @return int
     * @Description kmpSearch
     **/
    public static int kmpSearch(String str1, String str2, int[] next) {


        int i = 0;
        int j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (j == -1 || str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == str2.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * @param str
     * @return int[]
     * @Description kmpNext 求模式串的next数组
     **/
    public static int[] kmpNext(String str) {
        int[] next = new int[str.length()];
        next[0] = -1;
        int j = 0;
        int k = -1;

        while (j < str.length() - 1) {
            if (k == -1 || str.charAt(j) == str.charAt(k)) {
                next[++j] = ++k;

            } else {
                k = next[k];
            }

        }

        return next;
    }
}
