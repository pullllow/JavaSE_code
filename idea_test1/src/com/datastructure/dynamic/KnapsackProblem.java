package com.datastructure.dynamic;


//01背包问题

import java.util.ArrayList;
import java.util.Arrays;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1, 4, 3,2};
        int[] val = {1500, 3000, 2000,2700};
        int m = 5;
        int n = val.length;
        int[][] v = new int[n + 1][m + 1];

        int[][] path = new int[n + 1][m + 1];


        /*
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i - 1] > j) {//新加的物品超过了背包的重量
                    v[i][j] = v[i - 1][j];
                } else {
                    //v[i][j] = Math.max(v[i - 1][j], val[i] + v[i - 1][j - w[i]]);
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }

            }
        }
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.println(v[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------");
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
             性表   System.out.printf("第%d个商品被放入背包\n", i);
                j -= w[i - 1];
            }
            i--;
        }
        for(int ii=0;ii<m;ii++){
            System.out.println(Arrays.toString(path[ii]));
        }(*/

        for(int i=1;i< v.length;i++){
            for(int j=1;j<v[0].length;j++){
                if(j>=w[i]){
                    if((val[i-1]+v[i-1][j-w[i-1]])>v[i-1][j]){
                        v[i][j] = (val[i-1]+v[i-1][j-w[i-1]]);
                        path[i][j]=1;
                    } else {
                        v[i][j] = v[i-1][j];
                    }
                } else {
                    v[i][j]=v[i-1][j];
                }
            }

        }


    }
}
