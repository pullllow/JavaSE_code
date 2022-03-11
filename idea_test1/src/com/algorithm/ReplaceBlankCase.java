package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/10/28 15:40
 *  @description
 *  @Version V1.0
 */

public class ReplaceBlankCase {
    public static void main(String[] args) {
        String s = "we are hy.";
        System.out.println(s.length());
        System.out.println(replaceBlank(s));
        System.out.println(replaceBlank(s).length());
    }

    public static String replaceBlank(String s) {
        //StringBuilder stringBuilder = new StringBuilder();
        int countBlank = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                countBlank++;
            }
        }
        //StringBuffer res = new StringBuffer();

        StringBuffer res = new StringBuffer();
        int indexOfOriginal =0 ;
        while (indexOfOriginal < s.length()) {
            if (s.charAt(indexOfOriginal) != ' ') {
                res.append(s.charAt(indexOfOriginal++));
            } else {
                res.append("%20");
                indexOfOriginal++;
            }
        }


        return res.toString();

    }
}
