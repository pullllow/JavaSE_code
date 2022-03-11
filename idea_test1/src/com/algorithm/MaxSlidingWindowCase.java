package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/24 15:34
 *  @description 239. 滑动窗口最大值
 *  @Version V1.0
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxSlidingWindowCase {

    public static void main(String[] args) {
        int[] nums = {9, 10, 9, -7, -4, -8, 2, -6};
        int k = 5;
        int[] ints = maxSlidingWindow(nums, k);

        for (int i : ints) {
            System.out.println(i);
        }


    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        int n = nums.length;
        int[] res = new int[n-k+1];

        for(int i=0;i<k;i++){
            pq.offer(new int[]{nums[i],i});
        }

        res[0] = pq.peek()[0];

        for(int cur=1;cur<res.length;cur++){
            pq.offer(new int[]{nums[cur+k-1],cur+k-1});
            while(pq.peek()[1]<cur){
                pq.poll();
            }
            res[cur] = pq.peek()[0];
        }

        return res;

    }

    /*
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n==1){
            return nums;
        }
        int[] res = new int[n-k+1];
        int[] arr = new int[n];

        for(int i=0;i<k;i++){
            arr[i] = nums[i];
            heapify(arr,0,i+1);
        }
        int heapSize = k;
        int cur=0;
        res[cur++] = arr[0];
        for(;cur<=res.length-1;cur++){
            if(arr[0]==nums[cur-1]){
                arr[0] = nums[cur+k-1];
                heapify(arr,0,heapSize);
            } else {
                heapSize++;
                arr[heapSize-1] = nums[cur+k-1];
                heapInsert(arr,heapSize-1);
            }
            res[cur] = arr[0];


        }
        return res;

    }
    public static void heapInsert(int[] arr, int index){
        while(arr[index]>arr[(index-1)/2]){
            int temp = arr[index];
            arr[(index-1)/2] = arr[index];
            arr[index] = temp;
            index = (index-1)/2;
        }
    }
    public static void heapify(int[] arr, int index, int heapSize){
        int left = index*2+1;
        while(left<heapSize) {
            int largest = (left+1<heapSize&&arr[left+1]>arr[left])?left+1:left;
            largest = arr[largest]>arr[index]?largest:index;
            if(largest==index) break;
            //swap
            int temp = arr[largest];
            arr[largest] = arr[index];
            arr[index] = temp;

            index = largest;
            left = 2*index+1;
        }
    }*/
}
