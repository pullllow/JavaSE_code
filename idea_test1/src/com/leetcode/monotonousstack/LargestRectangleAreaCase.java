package com.leetcode.monotonousstack;
/*
 *  @author changqi
 *  @date 2022/2/26 10:23
 *  @description
 *  @Version V1.0
 */

public class LargestRectangleAreaCase {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        largestRectangleArea(heights);
    }

    public static int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] stack = new int[n];
        int cur = -1;

        int ans = 0;

        for(int i=0;i<n;i++) {
            while(cur>=0 && heights[stack[cur]]>heights[i]) {
                ans = Math.max(ans, heights[stack[cur]] * (i-1-(cur==0?-1:stack[cur-1])));
                stack[cur--] = 0;
            }

            stack[++cur] = i;
        }

        while(cur>=0){
            ans = Math.max(ans, heights[stack[cur]] *(n-1-cur>0?-1:stack[cur-1]));
            stack[cur--] = 0;
        }

        return ans;


    }
}
