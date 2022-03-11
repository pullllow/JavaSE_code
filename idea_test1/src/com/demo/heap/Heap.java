package com.demo.heap;
/*
 *  @author changqi
 *  @date 2021/12/7 9:58
 *  @description 默认小根堆
 *  @Version V1.0
 */

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Heap {

    public static void main(String[] args) {
//        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1]-o2[1];
//            }
//        });

        PriorityQueue<int[]> heap = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        int[] arr1 = {1,2};
        int[] arr2 = {1,3};

        heap.add(arr1);
        heap.add(arr2);

        heap.add(arr1);
        heap.add(arr2);

//        heap.add(new int[]{1,2});
//        heap.add(new int[]{2,1});
//        heap.add(new int[]{2,3});

        System.out.println(1);

    }

    public void heapSort(int[] arr) {
        if(arr==null || arr.length<2) {
            return;
        }

        for(int i=0;i<arr.length;i++) {
            heapInsert(arr,i);
        }

        int size = arr.length;
        while(size>0){
            heapify(arr,0,size);
        }
    }


    /**
     * @Description heapInsert 在堆底插入值后重新排序
     * @param arr
     * @param index
     * @return void
     **/
    public void heapInsert(int[] arr, int index) {
        while (arr[index] < arr[(index - 1) / 2]) {

            //swap
            arr[index] ^= arr[(index - 1) / 2];
            arr[(index - 1) / 2] ^= arr[index];
            arr[index] ^= arr[(index - 1) / 2];

            index = (index - 1) / 2;
        }
    }

    /**
     * @Description heapify
     * @param arr
     * @param index
     * @param heapSize
     * @return void
     **/
    public void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;

        while (left < heapSize) {
            int largerst = left + 1 < heapSize && arr[left + 1] < arr[left] ? left + 1 : left;
            largerst = arr[index] < arr[largerst] ? index : largerst;

            if (largerst == index) {
                break;
            }

            //swap
            arr[index] ^= arr[largerst];
            arr[largerst] ^= arr[index];
            arr[index] ^= arr[largerst];

            index = largerst;
            left = index * 2 + 1;
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
