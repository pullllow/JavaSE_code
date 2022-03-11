package com.datastructure.algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Queue8 {
    static int num = 0;

    public static void main(String[] args) {
        int max = 8; //定义最大queue数量
        List<List<String>> res = solveNQueens(max);
        for (int i = 0; i < max; i++) {
            List<String> strings = res.get(i);
            for (int j = 0; j < max; j++) {
                System.out.println(strings.get(j));
            }
            System.out.println();
        }


    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        int[] res1 = new int[n];
        queens(res, res1, n, 0);
        return res;


    }

/*
    //放置
    public static void check(int n, int max, int[] arr) {
        if (n == 8) {
            num++;
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i + 1;
            if (judge(arr, n)) {
                check(n + 1, max, arr);
            }
        }


    }

    //检查目前的放置是否正确
    public static boolean judge(int[] arr, int length) {
        for (int i = length; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if ((arr[i] == arr[j]) || (Math.abs(arr[i] - arr[j]) == (i - j))) {
                    return false;
                }
            }
        }

        return true;

    }*/


    public static void queens(List<List<String>> res, int[] res1, int n, int place) {
        if (place == 8) {
            List<String> ans = new ArrayList<String>();

            for (int i = 0; i < n; i++) {
                String s = "";
                for (int j = 0; j < n; j++) {
                    if (j != res1[i]) {
                        s = s + ".";
                    } else {
                        s = s + "Q";
                    }
                }
                ans.add(s);
            }
            for (int i = 0; i < n; i++) {

            }
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < n; i++) {
            res1[place] = i;
            if (check(res1, place + 1)) {
                queens(res, res1, n, place + 1);
            }
        }
    }

    public static boolean check(int[] res, int length) {
        //检查位置是否可行
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (res[i] == res[j] || res[i] - res[j] == i - j || res[i] - res[j] == j - i) {
                    return false;
                }
            }

        }
        return true;


    }

}
