package com.algorithm;
/*
 *  @author changqi
 *  @date 2022/3/23 16:41
 *  @description
 *  @Version V1.0
 */


import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s  = sc.nextLine();

        String[] word = s.split(" ");

        int sum = 0;
        for(String w : word) {
            sum += w.length();
        }
        int n = word.length;
        double res = (double)sum/(double)n;
        System.out.println(String.format("%.2f", res));


    }
}
