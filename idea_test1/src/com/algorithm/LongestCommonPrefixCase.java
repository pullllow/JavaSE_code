package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/12/2 16:22
 *  @description 14. 最长公共前缀
 *  @Version V1.0
 */

public class LongestCommonPrefixCase {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};

        //System.out.println(longestCommonPrefix(strs));
    }

    //    public static String longestCommonPrefix(String[] strs) {
//
//        String ans = "";
//
//
//        int min = Integer.MAX_VALUE;
//        for(int i=0;i<strs.length;i++){
//            min = Math.min(strs[i].length(),min);
//        }
//
//        for(int i=0;i<min;i++) {
//            char ch = '0';
//            for(String str:strs){
//                if(ch=='0'){
//                    ch = str.charAt(i);
//                } else {
//                    if(ch!=str.charAt(i)){
//                        return ans;
//                    }
//                }
//            }
//            ans = ans + ch;
//        }
//
//        return ans;
//
//
//    }
    public static String longestCommonPrefix(String[] strs) {
        String ans = strs[0];

        for (int i = 1; i < strs.length; i++) {
            ans = longestCommonPrefix(ans, strs[i]);
            if (ans.length() == 0) {
                return ans;
            }
        }
        return ans;

    }

    public static String longestCommonPrefix(String str1, String str2) {

        int index = 0;

        int l = Math.min(str1.length(), str2.length());
        while (index < l && str1.charAt(index) == str2.charAt(index)) {

            index++;

        }
        return str1.substring(0,index);
    }
}
