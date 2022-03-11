package com.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


/*
 * 方法1比方法2耗时在于方法1中每一次调用merge方法都需要创建一次temp数组
 * */

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -7, 70, -29};
        //int[] arr = {78, -9, 23, 23232, -123, 3333, 0, 11};
        /*int[] arr = new int[800000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }*/
        int[] temp = new int[arr.length];

        //System.out.println(Arrays.toString(arr));
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println(date1Str);

        //mergeSort1(arr, 0, arr.length - 1);
        //mergeSort2(arr, 0, arr.length - 1, temp);
        mergeSort3(arr,0,arr.length-1,temp);
        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println(date2Str);

        System.out.println(Arrays.toString(arr));
    }


    public static void mergeSort1(int[] arr, int left, int right) {

        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort1(arr, left, mid);
            mergeSort1(arr, mid + 1, right);

            merge1(arr, left, right);

        }


    }

    public static void merge1(int[] arr, int left, int right) {
        int mid = (right + left) / 2;

        int i = left;
        int j = mid + 1;
        int t = 0;

        int[] temp = new int[right - left + 1];

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        for (int x = left; x <= right; x++) {
            arr[x] = temp[x - left];
        }

    }


    public static void mergeSort2(int[] arr, int left, int right, int[] temp) {

        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort2(arr, left, mid, temp);
            mergeSort2(arr, mid + 1, right, temp);

            merge2(arr, left, right, temp);

        }


    }

    public static void merge2(int[] arr, int left, int right, int[] temp) {
        int mid = (right + left) / 2;

        int i = left;
        int j = mid + 1;
        int t = left;


        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        for (int x = left; x <= right; x++) {
            arr[x] = temp[x];
        }

    }


    public static void mergeSort3(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (right + left) / 2;
            mergeSort3(arr, left, mid, temp);
            mergeSort3(arr, mid + 1, right, temp);

            merge3(arr, left, right, temp);
        }
    }


    public static void merge3(int[] arr, int left, int right, int[] temp) {

        int mid = (left + right) / 2;

        int i = left;
        int j = mid + 1;
        int t = left;

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        for (int l = left; l <= right; l++) {
            arr[l] = temp[l];
        }
    }
}
