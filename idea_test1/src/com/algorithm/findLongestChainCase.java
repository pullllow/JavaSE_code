package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/10/22 13:13
 *  @description 646 最长数对链
 *  @Version V1.0
 */

import java.util.ArrayList;
import java.util.List;

public class findLongestChainCase {
    public static void main(String[] args) {
        int[][] nums ={{1,2},{2,3},{3,4}};
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> ans= new ArrayList<>();
        solve(0,nums,res,ans);

    }
    public static void solve(int place, int[][] pairs,List<List<Integer>> res, List<Integer> ans){
        if(place>=pairs.length){
            ans.add(res.size());
            res.remove(res.size()-1);
            return;
        }

        if(res.size()==0){
            List<Integer> temp = new ArrayList<>();
            temp.add(pairs[place][0]);
            temp.add(pairs[place][1]);
            res.add(new ArrayList<>(temp));

        }

        if(res.get(res.size()-1).get(1)<pairs[place][0]) {
            List<Integer> temp = new ArrayList<>();
            temp.add(pairs[place][0]);
            temp.add(pairs[place][1]);
            res.add(new ArrayList<>(temp));
            solve(place + 1, pairs, res, ans);


        }
        solve(place + 1, pairs, res, ans);




    }
}
