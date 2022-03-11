package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/6 19:44
 *  @description 279. 完全平方数
 *  @Version V1.0
 */

public class NumSquaresCase {
    public static void main(String[] args) {
        System.out.println(numSquares(48));

    }

    public static int numSquares(int n) {
        return countSquares1(n);

    }

    public static int countSquares1(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int nSqrt = (int)Math.sqrt((double)n);
        int count1 = countSquares1(n-nSqrt*nSqrt);
        int count2 =count1;
        if(n-nSqrt*nSqrt>0&&nSqrt>1){
            count2 = countSquares1(n-nSqrt*nSqrt+2*nSqrt-1);
        }

        return count1>count2?count2+1:count1+1;

    }



}
