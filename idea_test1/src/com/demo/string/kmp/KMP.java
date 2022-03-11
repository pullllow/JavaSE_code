package com.demo.string.kmp;
/*
 *  @author changqi
 *  @date 2021/12/21 15:46
 *  @description
 *  @Version V1.0
 */

public class KMP {
    public static void main(String[] args) {
        String str1 = "mississippi";
        String str2 = "issipi";

        System.out.println(kmpSearch(str1, str2));
    }


    /**
     * 求是否字符串m中含有字符串s
     *
     * @param m 匹配串
     * @param s 模式串
     * @return int
     **/
    public static int kmpSearch(String m, String s) {
        if (m.length() < s.length()) {
            return -1;
        }
        int i = 0;
        int j = 0;
        int[] next = kmpNext(s);
        while (i < m.length() && j < s.length()) {
            if (j == -1 || m.charAt(i) == s.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return j == s.length() ? i - j : -1;

    }

    /**
     * 求模式串的next数组
     *
     * @param str 模式串
     * @return int[]
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
