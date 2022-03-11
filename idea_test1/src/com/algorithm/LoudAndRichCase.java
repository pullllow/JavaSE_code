package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/12/15 10:34
 *  @description
 *  @Version V1.0
 */

import java.util.Arrays;

public class LoudAndRichCase {
    public static void main(String[] args) {
        int[][] richer = {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};

        int[] quiet = {3,2,5,4,6,1,7,0};

        int[] ints = loudAndRich(richer, quiet);

        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

    public static int[] loudAndRich(int[][] richer, int[] quiet) {

        Arrays.sort(richer,(o1, o2)->o1[1]-o2[1]);
        int n = quiet.length;

        int[] res = new int[n];

        Arrays.fill(res,-1);

        for(int i=0;i<n;i++){
            dfs(richer,quiet,res,i,i,0);
            if(res[i]==-1){
                res[i] = i;
            }
        }
        return res;

    }


    public static void dfs(int[][] richer, int[] quiet, int[] res,int person, int cur,int index){
        if(index==richer.length){
            return;
        }


        for(int i=index;i<richer.length;i++){
            if(richer[i][1]==cur){
                int temp = quiet[richer[i][0]]>quiet[richer[i][1]]?richer[i][1]:richer[i][0];
                if(res[person]==-1){
                    res[person] = temp;
                } else {
                    res[person] = quiet[temp]>quiet[res[person]]?res[person]:temp;
                }
                dfs(richer,quiet,res,person,richer[i][0],0);
            }
        }

    }
}
