package com.datastructure.tree;
/*
 *  @author changqi
 *  @date 2021/6/9 19:08
 *  @description
 *  @Version V1.0
 */

import java.util.Arrays;

public class HeapSort1 {
    public static void main(String[] args) {
        //int[] arr = {4, 6, 8, 5, 9,-2,-334};



        int[] arr = {11, 138, 460, 401, 657, 542, 559, 480, 420, 92};
        System.out.println(Arrays.toString(arr));
        heapSort(arr,false);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr){
        //默认升序排序
        heapSort(arr,true);
    }

    public static void heapSort(int[] arr, boolean flag) {
        int temp = 0;
        //构建大顶堆
        if(flag==true) {
            for (int i = arr.length / 2 - 1; i >= 0; i--) {
                adjustBigHeap(arr, i, arr.length);
            }

            for (int j = arr.length - 1; j > 0; j--) {
                temp = arr[0];
                arr[0] = arr[j];
                arr[j] = temp;
                adjustBigHeap(arr, 0, j);
            }
        } else {
            for (int i = arr.length / 2 - 1; i >= 0; i--) {
                adjustSmallHeap(arr, i, arr.length);
            }

            for (int j = arr.length - 1; j > 0; j--) {
                temp = arr[0];
                arr[0] = arr[j];
                arr[j] = temp;
                adjustSmallHeap(arr, 0, j);
            }
        }

    }

    public static void adjustBigHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if ((k+1<length)&&(arr[k] < arr[k + 1])) {//说明左子节点的值小于右子节点的值
                k++;
            }
            if (arr[k] > temp) {//子节点大于父节点
                arr[i] = arr[k];
                i = k; // i指向k继续循环比较
            } else {
                break;
            }
        }

        arr[i] = temp;
    }
    public static void adjustSmallHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        /*int k =i*2+1;
        if((k+1<arr.length)&&(arr[k+1]>arr[k])){
            k++;
        }
        if(temp<arr[k]){
            arr[i] = arr[k];
            i = k;
        }*/
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if ((k+1<length)&&(arr[k] > arr[k + 1])) {//说明左子节点的值小于右子节点的值
                k++;
            }
            if (arr[k] < temp) {//子节点大于父节点
                arr[i] = arr[k];
                i = k; // i指向k继续循环比较
            } else {
                break;
            }
        }

        arr[i] = temp;
    }

}
