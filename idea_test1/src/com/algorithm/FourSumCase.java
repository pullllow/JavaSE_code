package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/12/13 16:53
 *  @description
 *  @Version V1.0
 */

import java.util.*;

public class FourSumCase {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target =0;

        System.out.println(fourSum(nums,target));
    }


    static boolean[] visited;
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        backTrack(nums,0,res,new ArrayList<>(),target);
        return res;
    }


    public static void backTrack(int[] nums, int index, List<List<Integer>> res, List<Integer> ans,int target) {

        if(ans.size()==4 && target==0) {
            res.add(ans);
            return;
        }
        if(ans.size()==4||index== nums.length){
            return;
        }

        for(int i=index;i<nums.length;i++) {
            if(visited[i]||(i>0&&nums[i]==nums[i-1]&&!visited[i-1])){
                continue;
            }
            visited[i] = true;
            ans.add(nums[i]);
            backTrack(nums,i+1,res,new ArrayList<>(ans),target-nums[i]);
            ans.remove(ans.size()-1);
            visited[i] = false;
        }
    }

}
