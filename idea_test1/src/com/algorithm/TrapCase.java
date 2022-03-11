package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/18 20:00
 *  @description 面试题 17.21. 直方图的水量
 *  @Version V1.0
 */

import java.util.*;

public class TrapCase {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapMonotoneStack(height));
    }
    public static int trap(int[] height) {
        int n = height.length;
        if(n<=2){
            return 0;
        }
        int maxLeft = height[0];
        int maxRight = height[n-1];
        int all = 0;
        int left = 1;
        int right = n-2;
        while(left<=right){
            if(maxLeft>maxRight){
                all += Math.max(maxRight-height[right],0);
                maxRight = Math.max(maxRight,height[right]);
                right--;
            } else if(maxLeft<maxRight) {
                all += Math.max(maxLeft-height[left],0);
                maxLeft = Math.max(maxLeft,height[left]);
                left++;
            } else {
                if(height[right]<height[left]){
                    all += Math.max(maxRight-height[right],0);
                    maxRight = Math.max(maxRight,height[right]);
                    right--;
                } else {
                    all += Math.max(maxLeft-height[left],0);
                    maxLeft = Math.max(maxLeft,height[left]);
                    left++;
                }
            }
        }
        return all;
    }

    public static int trapMonotoneStack(int[] height) {
        int n = height.length;

        int res = 0;
        Deque<List<Integer>> stack = new ArrayDeque<>();

        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && height[i]>height[stack.peek().get(0)]) {
                List<Integer> temp = stack.pop();

                int left = stack.isEmpty()?-1:stack.peek().get(stack.peek().size()-1);

                for(int cur: temp) {
                    if(left!=-1){
                        res += Math.min(height[i],height[left])-height[cur];
                    }

                }

            }
            if(stack.isEmpty()|| height[i]<height[stack.peek().get(0)]) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                stack.push(temp);
            } else if(height[i]>height[stack.peek().get(0)]){
                stack.peek().add(i);
            }
        }

        return res;

    }
}
