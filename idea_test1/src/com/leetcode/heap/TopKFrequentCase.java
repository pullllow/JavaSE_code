package com.leetcode.heap;
/*
 *  @author changqi
 *  @date 2022/3/3 20:59
 *  @description
 *  @Version V1.0
 */

import java.util.PriorityQueue;

public class TopKFrequentCase {
    public static void main(String[] args) {
        /*int[] nums = {1,1,1,2,2,3};
        int k = 2;

        Solution s = new Solution();
        int[] ints = s.topKFrequent(nums, k);
        for(int i:ints) {
            System.out.println(i);
        }*/

        int k =5;
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (o1,o2)-> o2-o1);

        for(int i=0;i<k;i++){
            heap.add(i);
            System.out.println(heap.peek());

        }

        heap.add(10);

        System.out.println("容量"+heap.size());

    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Heap heap = new Heap(nums.length);
        for(int i: nums) {
            heap.add(i);
        }
        int[] res = new int[k];

        for(int i=0;i<k;i++) {
            res[i] = heap.arr[0][0];
            heap.remove();
        }

        return res;

    }

    public class Heap{
        //大根堆

        public int[][] arr;
        public int heapSize;

        public Heap(int maxSize) {
            arr = new int[maxSize][2];
            heapSize = 0;
        }

        public void add(int num) {
            int index = contains(num);
            //如果不存在
            if(index==-1) {

                arr[heapSize][0] = num;
                arr[heapSize++][1] = 1;
                heapInsert(heapSize-1);
                //不存在堆满情形

            } else {
                //如果存在
                arr[index][1]++;
                //向上更新
                heapInsert(index);
            }
        }

        public void remove() {
            //移出头
            arr[0][1] = -1;
            heapify(0);
        }

        public void heapInsert(int index) {
            //向上更新
            while(arr[index][1]>arr[(index-1)/2][1]) {
                swap(index, (index-1)/2);
                index = (index-1)/2;
            }
        }

        public void heapify(int index){
            //向下更新
            int left = 2 *index+1;

            while(left<heapSize) {
                int largest = left+1<heapSize && arr[left+1][1]>arr[left][1]?left+1:left;
                largest = arr[largest][1]>arr[index][1]?largest:index;
                if(largest==index) {
                    break;
                }
                swap(largest,index);
                index = largest;
                left = 2*index+1;
            }



        }

        public int contains(int num) {
            for(int i=0;i<heapSize;i++){
                if(arr[i][0]==num) return i;
            }

            return -1;
        }

        public void swap(int i, int j) {
            int temp = arr[i][0];
            arr[i][0] = arr[j][0];
            arr[j][0] = temp;
            temp = arr[i][1];
            arr[i][1] = arr[j][1];
            arr[j][1] = temp;
        }

    }
}