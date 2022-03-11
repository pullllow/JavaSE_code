package com.datastructure.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {78, -9, 23, 23232, -123, 3333, 0, 11};
        insertSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr, int left, int right) {
        int temp = 0;

        for (int i = left + 1; i <= right; i++) {
            temp = arr[i];
            int j = i;
            while (j > left && arr[j-1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }

    }
}
