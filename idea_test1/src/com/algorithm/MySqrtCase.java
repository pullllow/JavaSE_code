package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/25 10:55
 *  @description 69. Sqrt(x)
 *  @Version V1.0
 */

public class MySqrtCase {
    public static void main(String[] args) {
        System.out.println(mySqrt(Integer.MAX_VALUE));
    }

    public static int mySqrt(int x) {

        if(x==1||x==0){
            return x;
        }
        int l =0;
        int r = x-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(mid*mid>x){
                r = mid;
            } else if(mid*mid<x){
                if((mid+1)*(mid+1)>x){
                    l = mid;
                    r = mid;
                    break;
                } else {
                    l = mid+1;
                }
            } else {
                l = mid;
                r = mid;
                break;
            }
        }
        return l*l>x?l-1:l;

    }
}
