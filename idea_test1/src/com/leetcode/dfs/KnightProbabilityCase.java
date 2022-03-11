package com.leetcode.dfs;
/*
 *  @author changqi
 *  @date 2022/2/17 9:44
 *  @description
 *  @Version V1.0
 */

public class KnightProbabilityCase {


    public static void main(String[] args) {

        knightProbability(3,2,0,0);

    }

    static int success;
    static int fail;

    public static double knightProbability(int n, int k, int row, int column) {
        success = 0;
        fail = 0;
        dfs(n,k,row,column);
        return (double)fail/(double)(success+fail);



    }


    public static void dfs(int n, int k, int row, int column) {
        if(row>=n || column >=n || row<0 || column<0) {
            success++;
            return;
        }
        if(k==0){
            fail++;
            return;
        }

        dfs(n,k-1,row-2,column+1);
        dfs(n,k-1,row-1,column+2);

        dfs(n,k-1,row+1,column+2);
        dfs(n,k-1,row+2,column+1);

        dfs(n,k-1,row+2,column-1);
        dfs(n,k-1,row+1,column-2);

        dfs(n,k-1,row-1,column-2);
        dfs(n,k-1,row-2,column-1);


    }


}
