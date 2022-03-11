package com.datastructure.sort;
/*
 *  @author changqi
 *  @date 2021/11/23 19:17
 *  @description
 *  @Version V1.0
 */

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {2,4,3,353,11,10,22};
        heapSort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }


    }


    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }

    }


    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }


    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = (left + 1) < heapSize && (arr[left + 1] > arr[left]) ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (index == largest) break;
            swap(arr, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }


    public static void swap(int[] arr, int a, int b) {
//        arr[a] = arr[a] ^ arr[b];
//        arr[b] = arr[a] ^ arr[b];
//        arr[a] = arr[a] ^ arr[b];
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
