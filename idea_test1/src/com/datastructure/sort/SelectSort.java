package com.datastructure.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {78, -9, 23, 23232, -123, 3333, 0, 11};
        selectSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));


    }

    public static void selectSort(int[] arr, int left, int right){
        int l = left;
        int r = right;
        int temp = 0;
        for(int i = 0;i<=right;i++){
            int max = arr[0];
            int maxIndex = 0;
            for(int j = 0;j<= right-i;j++){
                if(arr[j]>max){
                    max = arr[j];
                    maxIndex = j;
                }
            }
            temp = arr[right-i];
            arr[right-i] = max;
            arr[maxIndex] = temp;


        }

    }
}
