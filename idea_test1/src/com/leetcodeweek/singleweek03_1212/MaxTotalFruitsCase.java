package com.leetcodeweek.singleweek03_1212;
/*
 *  @author changqi
 *  @date 2021/12/12 11:29
 *  @description
 *  @Version V1.0
 */

import java.util.HashMap;
import java.util.HashSet;

public class MaxTotalFruitsCase {

    public static void main(String[] args) {
        int[][] fruits = {{0,9},{4,1},{5,7},{6,2},{7,4},{10,9}};

        int startPos = 5;
        int k =4;
        System.out.println(maxTotalFruits(fruits,startPos,k));

    }

    public static int maxTotalFruits(int[][] fruits, int startPos, int k) {

        int res = 0;

        //只向右走

        HashMap<Integer,Integer> map = new HashMap<>();


        for(int[] fruit:fruits){
            map.put(fruit[0],fruit[1]);
        }
        return backTrack(map,startPos,k,0 ,new HashSet<>());




    }



    public static int backTrack(HashMap<Integer,Integer> map,int startPos, int k, int res,HashSet<Integer> set) {
        if(k==0){
            return res;
        }


        int cur = 0;
        if(map.containsKey(startPos) && !set.contains(startPos)){
            cur = map.get(startPos);

        }
        set.add(startPos);
        int left = backTrack(map,startPos-1,k-1, res+cur,new HashSet<>(set));
        int right = backTrack(map,startPos+1,k-1,res+cur,new HashSet<>(set));

        return Math.max(left,right);

    }

}
