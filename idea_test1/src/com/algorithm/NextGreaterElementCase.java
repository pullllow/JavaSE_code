package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/12/13 15:46
 *  @description
 *  @Version V1.0
 */

import java.util.*;

public class NextGreaterElementCase {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] ints = nextGreaterElement(nums1, nums2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println( ints[i]);

        }
        System.out.println();

    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {


        int[] res = new int[nums1.length];

        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums2[j]==nums1[i]){
                    map.put(j,i);
                    break;
                }
            }
        }

        for(int i=0;i<nums2.length;i++) {
            while(!stack.isEmpty() && nums2[i]>nums2[stack.peek()]) {
                if(map.containsKey(stack.peek())){
                    res[map.get(stack.pop())] = nums2[i];
                } else {
                    stack.pop();
                }

            }
            if(stack.isEmpty() || nums2[i]<nums2[stack.peek()]) {
                stack.push(i);
            }
        }

        while(!stack.isEmpty()) {
            if(map.containsKey(stack.peek())){
                res[map.get(stack.pop())] = -1;
            } else {
                stack.pop();
            }

        }

        return res;




    }
}
