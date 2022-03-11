package com.leetcode.prefixsum;
/*
 *  @author changqi
 *  @date 2022/2/17 15:36
 *  @description
 *  @Version V1.0
 */

import java.util.HashMap;
import java.util.Map;

public class FindMaxLengthCase {
    public static void main(String[] args) {

        int[] nums = {0,1,1,0,0,0,0,0,1,1,1,0,0,0,0,0};

        findMaxLength(nums);
    }


    public static int findMaxLength(int[] nums) {

        int n = nums.length;

        int[] sum = new int[n];

        sum[0] = nums[0];

        for(int i=1;i<n;i++) {
            sum[i] = nums[i] + sum[i-1];
        }

        int res = 0;

        //Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(i+1==2*sum[i]) res = Math.max(res,i+1);
            for(int j=0;j<i-1;j++){

                if(i-j+1==2*(sum[i]-sum[j])) res = Math.max(res,i-j+1);
                System.out.println(i+" "+j+" "+res);
            }
        }

        return res;

    }
}
