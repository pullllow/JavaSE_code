package com.leetcode.train;
/*
 *  @author changqi
 *  @date 2022/2/16 9:45
 *  @description
 *  @Version V1.0
 */

public class Solution1 {
    public static void main(String[] args) {

        String test1 = "xzzzy";
        System.out.println(solution(test1));
        String test2 = "toyxmy";
        System.out.println(solution(test2));
        String test3 = "apple";
        System.out.println(solution(test3));
        String test4 = "ayxbx";
        System.out.println(solution(test4));

    }

    public static int solution(String s) {

        int xCount = 0;
        int yCount = 0;

        for(char ch: s.toCharArray()) {
            if(ch=='x') xCount++;
            if(ch=='y') yCount++;
        }

        int res = 0;

        int leftX = 0;
        int leftY = 0;

        for(int i=0;i<s.length()-1;i++) {
            if(s.charAt(i)=='x') leftX++;
            if(s.charAt(i)=='y') leftY++;
            if(leftX==leftY || xCount-leftX==yCount-leftY) res++;
        }


        return res;
    }
}
