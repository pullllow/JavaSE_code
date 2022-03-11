package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/16 10:53
 *  @description 53. 最大子序和
 *  @Version V1.0
 */

public class MaxSubArrayCase {
    public static void main(String[] args) {
        int[] nums = {1};
        maxSubArray(nums);
    }
    public static int maxSubArray(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        dp[0]=nums[0];
        int max = dp[0];

        for(int i=1;i<n;i++){
            if(nums[i]+dp[i-1]>=nums[i]){
                dp[i] = dp[i-1]+nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(dp[i],max);
        }
        return max;

    }
}
