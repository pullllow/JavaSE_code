package com.datastructure.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {78, -9, 23, 23232, -123, 3333, 0, 11};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /*
    public static void bubbleSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int temp = 0;

        boolean flag = true;

        while (r >= left) {
            while (l < r) {
                if (arr[l] > arr[l + 1]) {
                    temp = arr[l];
                    arr[l] = arr[l + 1];
                    arr[l + 1] = temp;
                    flag = false;
                }
                l++;
            }
            l=0;
            r--;
            if(flag){
                break;
            }
            flag = true;
        }

    }?

     */

    public static void bubbleSort(int[] arr){


        for(int i=1;i<arr.length;i++){
            boolean swap = true;
            for(int j=0;j<arr.length-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1] = temp;
                    swap = false;
                }
                if(swap){
                    break;
                }
            }
        }

    }
}
