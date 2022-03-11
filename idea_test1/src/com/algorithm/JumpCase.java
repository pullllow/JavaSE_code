package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/16 10:38
 *  @description 45. 跳跃游戏 II
 *  @Version V1.0
 */

public class JumpCase {
    public static void main(String[] args) {
        int[] nums = {2,3,0,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];


        for(int i=n-2;i>=0;i--){
            if(nums[i]>=n-i-1){
                dp[i] = 1;
            } else{
                int min = Integer.MAX_VALUE-1;
                dp[i] = min;
                for(int j=1;j<=nums[i]&&nums[i]>0;j++){
                    min = Math.min(min,1+dp[i+j]);
                    dp[i] = min;
                }
            }
        }
        return dp[0];

    }
}
