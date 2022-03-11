package com.datastructure.algorithm;
/*
 *  @author changqi
 *  @date 2021/6/6 16:02
 *  @description
 *  @Version V1.0
 */

public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr= {-1,2,3,533,-9};

        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums){

        int sum = 0;
        int res = nums[0];
        for(int num: nums){
            if(sum>0){
                sum+=num;
            } else {
                sum=num;
            }
            res = Math.max(res,sum);
        }

        return res;
    }
}
