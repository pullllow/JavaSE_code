package com.datastructure.tree;
/*
 *  @author changqi
 *  @date 2021/6/8 19:46
 *  @description 堆排序
 *  @Version V1.0
 */

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {

        int[] arr = {4, 6, 8, 5, 9};

        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        //System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        int temp = 0;
        //1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从最后一个非叶子节点，自下向上，自左向右
            adjustHeap(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("------------");
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length-1 ; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
            System.out.println(Arrays.toString(arr));
        }
    }

    //将数组（二叉树）调整成堆

    /**
     * @Description : 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @Params : arr 待调整的数组
     * @Params : i 表示非叶子节点在数组中的索引
     * @Params : length 表示对多少个元素继续调整，逐渐递减的
     * @Return :
     */

    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        //开始调整
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
}
