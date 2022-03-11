package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/10/19 20:49
 *  @description 39 组合总和
 *  @Version V1.0
 */

import java.util.ArrayList;
import java.util.List;

public class CombinationSumCase {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> combine = new ArrayList<>();
        dfs(candidates,target,0,res,combine);


        return res;



    }

    public static void dfs(int[] candidates, int target, int num, List<List<Integer>> res, List<Integer> combine){
        if(num == candidates.length) {
            return;
        }

        if(target==0){
            res.add(new ArrayList<>(combine));
            return;
        }
        dfs(candidates,target,num+1,res,combine);
        if(target-candidates[num]>=0){
            combine.add(candidates[num]);
            dfs(candidates,target-candidates[num],num,res,combine);
            combine.remove(combine.size()-1);

        }



    }

}
