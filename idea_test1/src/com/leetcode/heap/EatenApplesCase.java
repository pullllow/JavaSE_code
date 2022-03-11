package com.leetcode.heap;
/*
 *  @author changqi
 *  @date 2021/12/24 9:53
 *  @description 1705. 吃苹果的最大数目
 *  @Version V1.0
 */

import java.util.PriorityQueue;

public class EatenApplesCase {

    public static void main(String[] args) {
        int[] apples = {3,0,0,0,0,2};
        int[] days = {3,0,0,0,0,2};

        eatenApples(apples, days);

    }

    public static int eatenApples(int[] apples, int[] days) {

        //每天优先吃快要烂的苹果
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);


        int res = 0;
        int curDay = 0;

        while (!heap.isEmpty() || curDay < apples.length) {

            if (curDay < apples.length) {
                heap.add(new int[]{curDay + days[curDay], apples[curDay]});
            }
            while (!heap.isEmpty() && (heap.peek()[0] <= curDay || heap.peek()[1] == 0)) {
                heap.poll();
            }

            if (!heap.isEmpty() && heap.peek()[1] != 0) {
                heap.peek()[1]--;
                res++;
            }


            curDay++;

        }

        return res;

    }
}
