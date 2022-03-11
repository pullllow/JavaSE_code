package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/23 15:54
 *  @description 29. 两数相除
 *  @Version V1.0
 */

public class DivideCase {

    public static void main(String[] args) {
        int temp = 10000;

        long max = 10;
        long min = -10;
        System.out.println(divide(Integer.MIN_VALUE,2));
        System.out.println(Integer.MIN_VALUE/2);
//        for(int i=0;i<temp;i++){
//            int dividend = (int)(Math.random()* (max-min)-(max-min)/2);
//            int divisor = (int)(Math.random()* (max-min)-(max-min)/2);
//            while(divisor==0){
//                divisor = (int)(Math.random()* (max-min)-(max-min)/2);
//            }
//            if(divide(dividend,divisor)!=dividend/divisor){
//                System.out.println(dividend+"/"+divisor+"=");
//                System.out.println(divide(dividend,divisor)+"  "+dividend/divisor);
//            }
//
//        }

//        for(int i=0;i<temp;i++){
//            int dividend = Integer.MIN_VALUE;
//            int divisor = (int)(Math.random()* (max-min)-(max-min)/2);
//            while(divisor==0){
//                divisor = (int)(Math.random()* (max-min)-(max-min)/2);
//            }
//            if(divide(dividend,divisor)!=dividend/divisor){
//                System.out.println(dividend+"/"+divisor+"=");
//                System.out.println(divide(dividend,divisor)+"  "+dividend/divisor);
//            }
//
//        }
//        for(int i=0;i<temp;i++){
//            int dividend = Integer.MAX_VALUE;
//            int divisor = (int)(Math.random()* (max-min)-(max-min)/2);
//            while(divisor==0){
//                divisor = (int)(Math.random()* (max-min)-(max-min)/2);
//            }
//            if(divide(dividend,divisor)!=dividend/divisor){
//                System.out.println(dividend+"/"+divisor+"=");
//                System.out.println(divide(dividend,divisor)+"  "+dividend/divisor);
//            }
//
//        }
//        for (int i = 0; i < temp; i++) {
//            int dividend = (int) (Math.random() * (max - min) - (max - min) / 2);
//            int divisor = Integer.MIN_VALUE;
//            while (divisor == 0) {
//                divisor = (int) (Math.random() * (max - min) - (max - min) / 2);
//            }
//            if (divide(dividend, divisor) != dividend / divisor) {
//                System.out.println(dividend + "/" + divisor + "=");
//                System.out.println(divide(dividend, divisor) + "  " + dividend / divisor);
//            }
//
//        }
//        for(int i=0;i<temp;i++){
//            int dividend = (int)(Math.random()* (max-min)-(max-min)/2);
//            int divisor = Integer.MAX_VALUE;
//            while(divisor==0){
//                divisor = (int)(Math.random()* (max-min)-(max-min)/2);
//            }
//            if(divide(dividend,divisor)!=dividend/divisor){
//                System.out.println(dividend+"/"+divisor+"=");
//                System.out.println(divide(dividend,divisor)+"  "+dividend/divisor);
//            }
//
//        }
//        for(int i=0;i<temp;i++){
//            int dividend = (int)(Math.random()* (max-min)-(max-min)/2);
//            int divisor = 0;
//            if(divide(dividend,divisor)!=dividend/divisor){
//                System.out.println(dividend+"/"+divisor+"=");
//                System.out.println(divide(dividend,divisor)+"  "+dividend/divisor);
//            }
//
//        }

        //System.out.println(divide(-2147483648,2));

        // 00111111110010010011011001000010
        // 0100111011011000100010000000
    }
//
//    public static int divide(int dividend, int divisor) {
//        if (dividend == Integer.MIN_VALUE) {
//            if (divisor == 1) return Integer.MIN_VALUE;
//            if (divisor == -1) return Integer.MAX_VALUE;
//        }
//        if (divisor == Integer.MIN_VALUE) {
//            if (dividend == Integer.MIN_VALUE) return 1;
//            else return 0;
//        }
//        if (dividend == 0) {
//            return 0;
//        }
//
//        boolean rev = true;
//        if(dividend>0){
//            dividend = -dividend;
//            rev = !rev;
//        }
//        if(divisor>0){
//            divisor = - divisor;
//            rev = !rev;
//        }
//
//        int left = 1, right = Integer.MIN_VALUE;
//        int ans=0;
//        while(left<=right){
//            int mid = left+((right-left)>>1);
//
//        }
//
//
//
//
//        return 0;
//    }


    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) return Integer.MIN_VALUE;
            if (divisor == -1) return Integer.MAX_VALUE;
        }
        if(divisor==Integer.MIN_VALUE) {
            if(dividend==Integer.MIN_VALUE) return 1;
            else return 0;
        }
        if (dividend == 0) {
            return 0;
        }
        //处理不了边界情形 dividend == Integer.MIN_VALUE
        boolean rev = true;
        if (dividend < 0) {
            dividend = ~dividend + 1;
            if (dividend == Integer.MIN_VALUE)
                dividend = Integer.MAX_VALUE;
            rev = !rev;
        }
        if (divisor < 0) {
            divisor = ~divisor + 1;
            if (divisor == Integer.MIN_VALUE)
                divisor = Integer.MAX_VALUE;
            rev = !rev;
        }
        if (dividend < divisor) {
            return 0;
        }

        int maxDividend = 0;
        int maxDivisor = 0;

        for (int i = 0; i <= 31; i++) {
            if ((dividend & (1 << i)) != 0) {
                maxDividend = i;
            }
            if ((divisor & (1 << i)) != 0) {
                maxDivisor = i;
            }
        }
        int max = (maxDividend - maxDivisor);

        int res = 0;
        long temp = dividend;
        while (max > 0) {
            if (divisor << max <= temp) {
                temp = temp - (divisor << max);
                res += 1 << max;
            }
            max--;
        }
        if (divisor <= temp) {
            res += 1 << max;
        }
        dividend = -dividend;
        if(dividend==Integer.MIN_VALUE){
            res++;

        }
        return rev ? res : -res;


    }
}
