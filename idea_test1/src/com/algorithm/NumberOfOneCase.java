package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/10/21 10:25
 *  @description
 *  @Version V1.0
 */

public class NumberOfOneCase {
    public static void main(String[] args) {
        int num = 0xFFFFFFFF;
        System.out.println(numberOfOne(num));

    }


    public static int numberOfOne(int num) {
        int count = 0;

        while(num!=0){
            count++;
            num = num & (num-1);
        }


        return count;
    }
}
