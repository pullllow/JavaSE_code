package com.datastructure.algorithm;
/*
 *  @author changqi
 *  @date 2021/10/22 14:19
 *  @description
 *  @Version V1.0
 */

public class KMPCase {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        System.out.println(str1.indexOf(str2));
        System.out.println(kmpSearch(str1, str2, kmpNext(str2)));
    }


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
        return j == str2.length() ? i - j : -1;

    }

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
