package com.leetcode.heap;
/*
 *  @author changqi
 *  @date 2022/3/3 20:32
 *  @description
 *  @Version V1.0
 */

public class KthLargestCase {
    public static void main(String[] args) {

        int[] nums = {4,5,8,2};
        int k = 3;

        KthLargest kth = new KthLargest(k,nums);
        System.out.println(kth.add(3));

        System.out.println(kth.add(5));
        System.out.println(kth.add(10));
        System.out.println(kth.add(9));
        System.out.println(kth.add(4));;

    }
}


class KthLargest {

    public Heap heap;

    public KthLargest(int k, int[] nums) {
        heap = new Heap(k);
        for(int i:nums){
            heap.add(i);
        }
    }

    public int add(int val) {
        heap.add(val);
        return heap.arr[0];
    }

    public class Heap{
        //小根堆

        public int[] arr;
        public int heapSize;


        public Heap(int n) {
            heapSize = 0;
            arr = new int[n];
        }

        public void add(int num) {
            //增加数据num

            if( heapSize < arr.length){
                //如果堆未满，直接插入堆底
                //向上排序
                arr[heapSize++] = num;
                heapInsert(heapSize-1);
            } else {
                //如果堆已满，替换堆顶元素
                //向下排序
                if(arr[0]<num) {
                    arr[0] = num;
                    heapify(0);
                }
            }
        }

        public void heapInsert(int index) {
            while(arr[index]<arr[(index-1)/2]) {
                swap(index,(index-1)/2);
                heapInsert((index-1)/2);
            }
        }

        public void heapify(int index) {
            int left = index*2+1;
            while(left<heapSize) {
                int smallest = left+1<heapSize && arr[left+1]<arr[left]?left+1:left;
                smallest = arr[index]>arr[smallest]?smallest:index;
                if(smallest==index) {
                    break;
                }

                swap(smallest,index);
                index = smallest;
                left = index*2+1;
            }
        }

        public void swap(int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }


    }
}