package com.leetcodeweek.singleweek04_0410;
/*
 *  @author changqi
 *  @date 2022/4/10 11:15
 *  @description
 *  @Version V1.0
 */

public class MinimizeResultCase {

    public static void main(String[] args) {
        String expression = "247+38";
        System.out.println(minimizeResult(expression));
    }


    public static String minimizeResult(String expression) {

        int plus  = expression.indexOf('+');
        int n = expression.length();

        System.out.println(plus);

        int res = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;

        for(int i=0;i<plus;i++) {
            for(int j=plus+2;j<=n;j++) {
                int leftMul = Integer.parseInt(expression.substring(0,i).equals("")?"1":expression.substring(0,i));
                int leftPlus = Integer.parseInt(expression.substring(i,plus).equals("")?"1":expression.substring(i,plus));

                int rightPlus = Integer.parseInt(expression.substring(plus+1,j).equals("")?"1":expression.substring(plus+1,j));
                int rightMul = Integer.parseInt(expression.substring(j,n).equals("")?"1":expression.substring(j,n));
                if(res>leftMul*(leftPlus+rightPlus)*rightMul) {
                    res = leftMul*(leftPlus+rightPlus)*rightMul;
                    left = i;
                    right =j;
                }

            }
        }

        return expression.substring(0,left)+"("+expression.substring(left,right)+")"+expression.substring(right,n);

    }

}
