package com.writtenexam.test;
/*
 *  @author changqi
 *  @date 2022/3/5 13:01
 *  @description
 *  @Version V1.0
 */

import java.util.*;


public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        5 7
        1 2 3 4 5
        Q 1 5
        U 3 6
        Q 3 4
        Q 4 5
        U 4 5
        U 2 9
        Q 1 5
        */
        /*int[] socres = new int[1];
        int index = 1;
        int num = 0;*/

        while(sc.hasNext()) {
            int num = sc.nextInt();
            int manage = sc.nextInt();
            int[] socres = new int[num];
            for(int i=0;i<num;i++) {
                socres[i] = sc.nextInt();
            }
            String[] p =new String[manage];
            int[][] proces  = new int[manage][2];
            for(int i=0;i<manage;i++) {
                p[i] = sc.next();
                proces[i][0] = sc.nextInt();
                proces[i][1] = sc.nextInt();

            }

            for(int i=0;i<manage;i++) {
                if(p[i].equals("U")) {
                    update(socres,proces[i][0], proces[i][1]);
                } else {
                    System.out.println();
                    System.out.println(max(socres,proces[i][0], proces[i][1]));
                }
            }

        }


    }

    public static int max(int[] arr ,int left, int right) {
        int l = Math.min(left,right)-1;
        int r=  Math.max(left,right)-1;
        int res = Integer.MIN_VALUE;
        for(int i=Math.max(0,l);i<=r&&i<arr.length;i++) {
            res = Math.max(res,arr[i]);
        }
        return res;
    }

    public static void update(int[] arr, int index, int socre) {
        if(index<=0 || index>arr.length) return;
        arr[index-1] = socre;
    }

}
