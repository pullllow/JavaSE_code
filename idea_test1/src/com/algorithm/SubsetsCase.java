package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/10/21 20:25
 *  @description 78子集
 *  @Version V1.0
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsCase {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = subsets(nums);
        System.out.println(res);
        System.out.println(1<<1);

        //System.out.println(Arrays.toString(res.get(0)));

    }

    public static List<List<Integer>> subsets(int[] nums) {
        /*
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i =0;i<(1<<n);i++){
            ans.clear();
            for(int j=0;j<nums.length;j++){
                if((1<<j & i)!=0){
                    ans.add(nums[j]);
                }
            }
            res.add(new ArrayList<>(ans));
        }
        return res;
        */
        //回溯
        List<List<Integer>> res = new ArrayList<>();
        backTrack(0,nums,res,new ArrayList<Integer>());
        return res;

    }

    public static void backTrack(int start, int[] nums, List<List<Integer>> res, List<Integer> ans){
        res.add(new ArrayList<Integer>(ans));
        for(int i=start;i<nums.length;i++){
            ans.add(nums[i]);
            backTrack(i+1,nums,res,ans);
            ans.remove(ans.size()-1);
        }



    }


}
