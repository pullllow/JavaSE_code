package com.demo.sort;
/*
 *  @author changqi
 *  @date 2022/3/8 14:49
 *  @description
 *  @Version V1.0
 */


import java.util.Arrays;
import java.util.Map;
import java.util.Queue;

public class Sort {
    public static void main(String[] args) {

        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        //BubbleSort(arr);
        //InsertSort(arr);
        //SelectSort(arr);
        //MergeSort(arr,0, arr.length-1);
        //QuickSort(arr, 0, arr.length - 1);
        ShellSort(arr);
        System.out.println(Arrays.toString(arr));


    }


    /**
     * 1.冒泡排序 时间复杂度O(N^2) 空间复杂度O(1) 稳定
     *
     * @param arr
     * @return void
     **/
    public static void BubbleSort(int[] arr) {
        for (int e = arr.length - 1; e >= 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }

    }

    /**
     * 2.插入排序 时间复杂度O(N^2) 空间复杂度O(1) 稳定
     *
     * @param arr
     * @return void
     **/
    public static void InsertSort(int[] arr) {
        for (int j = 1; j < arr.length; j++) {
            for (int i = j - 1; i >= 0 && arr[i] > arr[i + 1]; i--) {
                swap(arr, i, i + 1);
            }
        }
    }


    /**
     * 3.选择排序 时间复杂度O(N^2) 空间复杂度O(1) 不稳定
     *
     * @param arr
     * @return void
     **/
    public static void SelectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }


    /**
     * 4.归并排序 时间复杂度O(NlogN) 空间复杂度O(N) 稳定
     *
     * @param arr
     * @param left
     * @param right
     * @return void
     **/
    public static void MergeSort(int[] arr, int left, int right) {
        if (left == right) return;
        int mid = left + (right - left) / 2;
        MergeSort(arr, left, mid);
        MergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);


    }


    public static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];

        int p1 = left;
        int p2 = mid + 1;
        int p = 0;
        while (p1 <= mid && p2 <= right) {
            help[p++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[p++] = arr[p1++];
        }
        while (p2 <= right) {
            help[p++] = arr[p2++];
        }


        for (int i = left; i <= right; i++) {
            arr[i] = help[i - left];
        }


    }


    /**
     * 5.快速排序 时间复杂度O(NlogN) 空间复杂度O(logN) 不稳定
     *
     * @param arr
     * @param left
     * @param right
     * @return void
     **/
    public static void QuickSort(int[] arr, int left, int right) {

        if (left < right) {
            int partitionIndex = Partition(arr, left, right);
            QuickSort(arr, left, partitionIndex - 1);
            QuickSort(arr, partitionIndex + 1, right);
        }

    }

    public static int Partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = left + 1;


        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);

        return index - 1;

    }

    /**
     * 希尔排序 时间复杂度O（NlogN） 空间复杂度O(1) 不稳定
     * @param arr
     * @return void
     **/
    public static void ShellSort(int[] arr) {
        for (int gap = arr.length / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0 && arr[j] > arr[j + gap]; j -= gap) {
                    swap(arr, j, j + gap);
                }
            }
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
