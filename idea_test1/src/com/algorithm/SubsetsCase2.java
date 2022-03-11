package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/10 10:21
 *  @description 90. 子集 II
 *  @Version V1.0
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsCase2 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,2};
        List<List<Integer>> res = subsetsWithDup(nums);
        System.out.println(res);
        System.out.println(2<<30);

    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backTrack(0,nums,res,new ArrayList<Integer>());
        return res;

    }

    public static void backTrack(int start,int[] nums, List<List<Integer>> res, List<Integer> temp) {
        res.add(new ArrayList<>(temp));
        int last = -11;
        for(int i=start;i<nums.length;i++){
            if(nums[i]!=last){
                temp.add(nums[i]);
                backTrack(i+1,nums,res,temp);
                temp.remove(temp.size()-1);
                last = nums[i];
            }

        }
    }
}
