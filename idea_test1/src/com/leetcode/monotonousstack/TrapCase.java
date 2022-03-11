package com.leetcode.monotonousstack;
/*
 *  @author changqi
 *  @date 2022/2/26 12:48
 *  @description
 *  @Version V1.0
 */

import java.util.LinkedList;

public class TrapCase {
    public static void main(String[] args) {


        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        trap(height);
    }


    public static int trap(int[] height) {


        int n = height.length;

        LinkedList<Integer> stack = new LinkedList<>();

        int[] res = new int[n];

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && height[stack.peekLast()]<= height[i]){
                int cur = stack.pollLast();
                if(stack.isEmpty()) {
                    res[cur] = 0;
                } else {
                    res[cur] = Math.min(height[stack.peekLast()],height[i]) - height[cur];
                    res[cur] *= i-stack.peekLast();
                }
            }
            stack.offer(i);
        }

        int ans = 0;

        for(int r :res){
            ans+=r;
        }

        return ans;


    }

}
