package com.newcoder;
/*
 *  @author changqi
 *  @date 2022/3/26 10:50
 *  @description
 *  @Version V1.0
 */

/*
N 位同学站成一排，音乐老师要请最少的同学出列，使得剩下的 K 位同学排成合唱队形。

设KK位同学从左到右依次编号为 1，2…，K ，他们的身高分别为T_1,T_2,…,T_KT
 ，则称这KK名同学排成了合唱队形。
通俗来说，能找到一个同学，他的两边的同学身高都依次严格降低的队形就是合唱队形。
例子：
123 124 125 123 121 是一个合唱队形
123 123 124 122不是合唱队形，因为前两名同学身高相等，不符合要求
123 122 121 122不是合唱队形，因为找不到一个同学，他的两侧同学身高递减。

你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。

注意：不允许改变队列元素的先后顺序 且 不要求最高同学左右人数必须相等

数据范围： 1 \le n \le 3000 \1≤n≤3000

输入描述：
用例两行数据，第一行是同学的总数 N ，第二行是 N 位同学的身高，以空格隔开

输出描述：
最少需要几位同学出列*/

import java.util.Arrays;
import java.util.Scanner;

public class HJ24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }
        //lefts[i] i左方最长连续递增子序列长度
        int[] lefts = new int[n];
        //lefts[i] i右方最长连续递增子序列长度
        int[] rights = new int[n];
        Arrays.fill(lefts, 1);
        Arrays.fill(rights, 1);
        lefts[0] = 1;
        rights[n - 1] = 1;
        for (int i = 1; i < n; i++) {

            for (int j = i - 1; j >= 0; j--) {
                if (h[i] > h[j]) {
                    lefts[i] = Math.max(lefts[i], lefts[j] + 1);
                }
                if (h[n - i - 1] > h[n - j - 1]) {
                    rights[n - i - 1] = Math.max(rights[n - i - 1], rights[n - j - 1] + 1);
                }
            }
        }
        //        System.out.println(Arrays.toString(lefts));
        //        System.out.println(Arrays.toString(rights));
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (rights[i] == 1 || lefts[i] == 1) continue;
            res = Math.max(lefts[i] + rights[i] - 1, res);
        }
        System.out.println((res==0)?-1:n - res);


    }
}
