package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/25 21:55
 *  @description 134. 加油站
 *  @Version V1.0
 */

public class CanCompleteCircuitCase {
    public static void main(String[] args) {

        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        int N = 100;

        System.out.println(canCompleteCircuit(gas,cost));
        //int[] gas = {}
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;

        int begin = 0;

        while(begin<n) {
            int cnt = 0;
            int sumCost = 0 ,sumGas =0;
            while(cnt<n) {
                int j = cnt + begin;
                sumGas += gas[j%n] ;
                sumCost += cost[j%n];
                if(sumGas<sumCost){
                    break;
                }
                cnt++;
            }
            if(cnt==n){
                return begin;
            } else {
                begin = begin+cnt+1;
            }
        }

        return -1;



    }
}
