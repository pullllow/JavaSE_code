package com.leetcodeweek.singleweek03_1212;
/*
 *  @author changqi
 *  @date 2021/12/12 11:15
 *  @description
 *  @Version V1.0
 */

public class MinimumRefillCase {

    public static void main(String[] args) {

        int[] plants = {274,179,789,417,293,336,133,334,569,355,813,217,80,933,961,271,294,933,49,980,685,470,186,11,157,889,299,493,215,807,588,464,218,248,391,817,32,606,740,941,505,533,289,306,490};


        minimumRefill(plants,996,1172);
    }


    public static int minimumRefill(int[] plants, int capacityA, int capacityB) {


        int res = 0;

        int n = plants.length;

        int left = 0;
        int right = n-1;

        int curA = capacityA;
        int curB = capacityB;

        while(left<right) {


            if(curA>=plants[left]){
                curA -= plants[left];
                left++;
            } else {
                res++;
                curA = capacityA;
            }

            if(curB>=plants[right]){
                curB -= plants[right];
                right--;
            } else {
                res++;
                curB = capacityB;
            }
        }

        if(right==left) {
            int cur = Math.max(curA,curB);
            if(cur<plants[right]) {
                res++;
            }
        }
        return res;
    }
}
