package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/12/13 14:37
 *  @description
 *  @Version V1.0
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LargestRectangleAreaCase {
    public static void main(String[] args) {


        int[] heights = {2,4};
        System.out.println(largestRectangleArea(heights));
        
        
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(20);


        for (int i : list) {
            System.out.println(i);
        }

    }

    public static int largestRectangleArea(int[] heights) {

        int n =heights.length;

        Stack<List<Integer>> stack = new Stack<>();

        int[][] info = new int[n][2];


        for(int i=0;i<n;i++) {

            while(!stack.isEmpty() && heights[i]<heights[stack.peek().get(0)]) {
                List<Integer> temp = stack.pop();
                int left = stack.isEmpty()?-1:stack.peek().get(stack.peek().size()-1);

                for(int j=0;j<temp.size();j++){
                    info[temp.get(j)][1]=i;
                    info[temp.get(j)][0]=left;
                }
            }
            if(stack.isEmpty() || heights[i]>heights[stack.peek().get(0)]){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                stack.push(temp);
            } else if(heights[i]==heights[stack.peek().get(0)]) {
                stack.peek().add(i);
            }
        }

        while(!stack.isEmpty()){
            List<Integer> temp = stack.pop();
            int left = stack.isEmpty()?-1:stack.peek().get(stack.peek().size()-1);

            for(int j=0;j<temp.size();j++){
                info[temp.get(j)][1]=n;
                info[temp.get(j)][0]=left;
            }
        }
        int res = 0;
        for(int i=0;i<n;i++){
            res = Math.max(res,heights[i]*(info[i][1]-1-(info[i][0]+1)+1));

        }

        return res;
    }
}
