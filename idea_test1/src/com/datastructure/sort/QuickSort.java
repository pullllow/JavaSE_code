package com.datastructure.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {

        int[] arr = {-9, 78, 0, 23, -7, 70, -29};
        quickSort2(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }



    public static void quickSort1(int[] arr, int left, int right) {
        int l = left;//左下标
        int r = right;//右下标

        int temp = 0;

        int pivot = arr[(left + right) / 2];//中轴值


        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivot) {
                r -= 1;
            }
            if (arr[r] == pivot) {
                l += 1;
            }


        }

        if (l == r) {
            l += 1;
            r -= 1;
        }

        if (left < r) {
            quickSort1(arr, left, r);
        }
        if (right > l) {
            quickSort1(arr, l, right);
        }

    }


    //快速排序，基数为任意位置的数
    public static void quickSort2(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        Random random = new Random();
        //int basisIndex = random.nextInt(right - left + 1) + left;
        //System.out.println(basisIndex);
        //int basis = arr[basisIndex];//任意值

        int basis = arr[random.nextInt(right - left + 1) + left];
        int temp = 0;
        while (l < r) {
            while (arr[l] < basis) {
                l++;
            }
            while (arr[r] > basis) {
                r--;
            }

            if (l >= r) {
                break;
            }
            temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;
        }

        if(l==r){
            l++;
            r--;
        }
        if(l<right){
            quickSort2(arr,l,right);
        }
        if(r>left){
            quickSort2(arr,left,r);
        }
    }


}
