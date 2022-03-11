package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/10 19:56
 *  @description
 *  @Version V1.0
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumCase2 {


    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lists = combinationSum2(nums, 8);
        System.out.println(lists);

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        if(candidates[0]>target||candidates.length==0){
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        backTrack(0, candidates, target, res, ans);

        return res;

    }


    public static void backTrack(int start, int[] nums, int target, List<List<Integer>> res, List<Integer> ans) {
        if(target==0){
            res.add(new ArrayList<>(ans));
        }
        if (start == nums.length) {
            return;
        }
        if (nums[start] > target&&start==0) {
            backTrack(start + 1, nums, target, res, ans);
        }
        for (int i = start; i < nums.length; i++) {
            if(target - nums[i]<0){
                break;
            }
            if(i>start&&nums[i]==nums[i-1]){
                continue;
            }
            ans.add(nums[i]);
            backTrack(i + 1, nums, target - nums[i], res, ans);
            ans.remove(ans.size() - 1);





        }

    }
}
