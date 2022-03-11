package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/28 17:10
 *  @description
 *  @Version V1.0
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumCase {
    public static void main(String[] args) {

        int[] nums = {-1,0,1,2,-1,-4};

        System.out.println(threeSum(nums));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        //O(N^3)
        /*
        for(int first = 0; first < n; first++){
            if(first > 0 && nums[first] == nums[first-1]){
                continue;
            }

            for(int second = first + 1; second < n; second++){
                if(second>first+1 &&nums[second] == nums[second-1]) {
                    continue;
                }
                for(int last = second+1; last<n; last++) {
                    if(last>second+1 &&nums[last] == nums[last-1]) {
                        continue;
                    }
                    if(nums[first]+nums[second]+nums[last]==0){
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[first]);
                        ans.add(nums[second]);
                        ans.add(nums[last]);
                        res.add(ans);

                    }
                }
            }


        }
        */

        //O(N^2)

        for(int first = 0; first<n; first++){
            if(first>0&&nums[first]==nums[first]){
                continue;
            }
            int target = -nums[first];

            int last = n-1;

            for(int second = first + 1; second < n; second++){
                if(second>first+1 && nums[second]==nums[second-1]){
                    continue;
                }
                while(last>second && nums[second]+nums[last]>target){
                    last--;
                }
                if(second==last){
                    break;
                }
                if(nums[second]+nums[last]==target){
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[first]);
                    ans.add(nums[second]);
                    ans.add(nums[last]);
                    res.add(ans);
                }

            }

        }


        return res;

    }

}
