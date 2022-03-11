package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/28 17:30
 *  @description
 *  @Version V1.0
 */

import java.util.Arrays;

public class ThreeSumClosestCase {

    public static void main(String[] args) {

        int[] nums = {-3,-2,-5,3,-4};

        int target = -1;
        System.out.println(threeSumClosest(nums,target));

    }

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int n = nums.length;

        int res = Integer.MAX_VALUE/2;
        for(int first = 0; first<n; first++){
            if(first>0&&nums[first]==nums[first-1]){
                continue;
            }


            int last = n-1;
            int second = first+1;

            while(second<last){
                int sum = nums[first]+nums[second] + nums[last];
                if(second>first+1 && nums[second]==nums[second-1]){
                    second++;
                    continue;
                }
                if(last<n-1 && nums[last]==nums[last+1]){

                    last--;
                    continue;
                }
                res = Math.abs(sum-target)>Math.abs(res-target)?res:sum;
                if(sum==target){
                    return target;
                } else if(sum<target) {
                    second++;
                } else {
                    last--;
                }

            }
        }


        return res;
    }
}
