package com.datastructure.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {1101, 53, 12,3, 542, 748,14,2};
        radixSort2(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void radixSort1(int[] arr) {
        //查找最高位
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }


        int maxLength = (max + "").length();

        int[][] bucket = new int[10][arr.length];

        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {

            for (int j = arr.length - 1; j >= 0; j--) {
                int digitalOfElements = arr[j] / n % 10;
                bucket[digitalOfElements][bucketElementCounts[digitalOfElements]] = arr[j];
                bucketElementCounts[digitalOfElements]++;
                //bucket[arr[j]%(Math.pow(10,i)][bucketElementCounts[]]=j;
            }
           /* for(int t=0;t<10;t++){
                System.out.println(Arrays.toString(bucket[t]));
            }
            System.out.println(Arrays.toString(bucketElementCounts));
            System.out.println("----------");*/
            int index = 0;
            int count = 0;
            while (count < bucketElementCounts.length) {
                if (bucketElementCounts[count] != 0) {
                    arr[index++] = bucket[count][(bucketElementCounts[count]--) - 1];
                    bucket[count][bucketElementCounts[count]] = 0;
                } else {
                    count++;
                }
            }
        }
    }


    public static void radixSort2(int[] arr) {
        int positiveNum = 0;
        int negativeNum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                positiveNum++;
            } else {
                negativeNum++;
            }
        }
        if (negativeNum > 0 && positiveNum > 0) {
            int[] positiveArr = new int[positiveNum];
            int[] negativeArr = new int[negativeNum];
            int tempPositive = positiveNum;
            int tempNegativeNum = negativeNum;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 0) {
                    positiveArr[(tempPositive--) - 1] = arr[i];
                } else {
                    negativeArr[(tempNegativeNum--) - 1] = -arr[i];
                }
            }

            radixSort1(positiveArr);
            radixSort1(negativeArr);
            for (int i = negativeNum - 1; i >= 0; i--) {
                arr[negativeNum - i - 1] = -negativeArr[i];
            }
            for (int i = 0; i < positiveNum; i++) {
                arr[i + negativeNum] = positiveArr[i];
            }
        } else if (negativeNum == 0) {
            radixSort1(arr);
        } else if (positiveNum == 0) {
            int[] temp = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = -arr[i];
            }
            radixSort1(temp);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = -temp[arr.length - i - 1];
            }
        }


    }
}
