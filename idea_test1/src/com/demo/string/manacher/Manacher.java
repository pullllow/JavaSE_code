package com.demo.string.manacher;
/*
 *  @author changqi
 *  @date 2021/12/21 20:35
 *  @description
 *  @Version V1.0
 */

public class Manacher {

    public static void main(String[] args) {
        String str = "ababacdaba";

        System.out.println(manacherString(str));
        System.out.println(manacher(str));
    }


    /**
     * 将str每个字符之间加入特殊字符辅助
     *
     * @param str
     * @return char[]
     **/
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }


    /**
     * 最长回文字符串
     *
     * @param str
     * @return int
     **/
    public static int manacher(String str) {
        if (str == null) {
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];
        int C = -1;
        int R = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != charArr.length; i++) {
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;

    }


}
