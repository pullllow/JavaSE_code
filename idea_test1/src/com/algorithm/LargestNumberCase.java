package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/12/2 15:58
 *  @description
 *  @Version V1.0
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestNumberCase {
    public static void main(String[] args) {

        int[] nums = {111311, 1113};

        System.out.println(largestNumber(nums));

    }

    public static String largestNumber(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new MaxheapComparator());

        for(int num:nums){
            heap.add(num);
        }
        StringBuilder sb = new StringBuilder();
        while(!heap.isEmpty()) {
            sb.append(heap.poll());
        }

        return sb.toString();



    }


    public static class MaxheapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer n1, Integer n2) {
            int dig1 = digNum(n1);
            int dig2 = digNum(n2);
            if(dig1==dig2){
                return n2-n1;
            }
            int dig = dig1>dig2?dig1:dig2;

            n1 = dig==dig1?n1:n1*(int)Math.pow(10,dig2-dig1);
            n2 = dig==dig2?n2:n2*(int)Math.pow(10,dig1-dig2);

            if(n2==n1){
                return dig1-dig2;
            } else {
                return n2-n1;
            }


        }
    }


    public static  int digNum(int num) {
        int dig = 9;
        for(int i=dig;i>=0;i--) {
            if(num/(int)Math.pow(10,i)!=0){
                return i;
            }
        }

        return 0;

    }
}
