package com.leetcode.monotonousstack;
/*
 *  @author changqi
 *  @date 2022/2/25 11:04
 *  @description
 *  @Version V1.0
 */

import java.util.LinkedList;

public class DailyTemperaturesCase {
    public static void main(String[] args) {

        int[] t = {89,62,70,58,47,47,46,76,100,70};

        int[] d = dailyTemperatures(t);

    }

    public static int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;

        int[] res = new int[n];

        LinkedList<Integer> stack = new LinkedList<>();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && temperatures[stack.peekLast()]<=temperatures[i]){
                stack.pollLast();
            }
            if(!stack.isEmpty()){
                res[i] = stack.peekLast()-i;
            }
            stack.add(i);
        }


        return res;


    }
}
