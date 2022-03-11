package com.datastructure.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibonacciSearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89,999, 1000, 1034};

        //List<Integer> fibArray = fib(arr.length);
        //System.out.println(fibArray);


        int findValue = 1;
        System.out.println(arr[fibonacciSearch(arr, findValue)]==findValue);

    }


    //根据查找线性表的长度生成对应的斐波那契数列
    public static List<Integer> fib(int num) {

        List<Integer> fibArrayList = new ArrayList<>();

        fibArrayList.add(1);
        fibArrayList.add(1);
        while (num >= fibArrayList.size()) {
            fibArrayList.add(fibArrayList.get(fibArrayList.size() - 1) + fibArrayList.get(fibArrayList.size() - 2));

        }

        return fibArrayList;
    }


    public static int fibonacciSearch(int[] arr, int findValue) {

        List<Integer> fibArr = fib(arr.length);
        int k = 0;
        while (arr.length > (fibArr.get(k) - 1)) {
            k++;
        }

        int[] temp = Arrays.copyOf(arr, fibArr.get(k));
        for (int i = arr.length; i < fibArr.get(k); i++) {
            temp[i] = arr[arr.length - 1];
        }

        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        //System.out.println(mid);
        while (l <= r) {
            mid = l + fibArr.get(k - 1) - 1;
            if (temp[mid] > findValue) {
                r = mid;
                k--;

            } else if (temp[mid] < findValue) {
                l = mid + 1;
                k = k - 2;
            } else {
                if (mid >= arr.length) {
                    return arr.length - 1;
                } else {
                    return mid;
                }

            }
        }


        return -1;
    }
}
