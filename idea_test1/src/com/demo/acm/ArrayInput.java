package com.demo.acm;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayInput {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            long l=sc.nextLong();
            long[] nums=new long[n];
            for(int i=0;i<n;i++){
                nums[i]=sc.nextLong();
            }
            Arrays.sort(nums);
            long gap=nums[1]-nums[0];
            for(int i=1;i<n;i++){
                gap=Math.max(gap,nums[i]-nums[i-1]);
            }
            //下标最小和最大位置的路灯需要单独判断
            //如下标为3是最小，那么0-3这一段必须被覆盖到，所以最小下标必须单独判断
            gap=Math.max(gap,nums[0]*2);
            gap=Math.max(gap,(l-nums[n-1])*2);
            System.out.println(String.format("%.2f",gap/2.0));
        }
    }
}