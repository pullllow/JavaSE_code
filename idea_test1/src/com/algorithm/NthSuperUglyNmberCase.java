package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/26 22:03
 *  @description 313. 超级丑数
 *  @Version V1.0
 */

import java.util.Arrays;

public class NthSuperUglyNmberCase {
    public static void main(String[] args) {

    }

    public static int nthSuperUglyNumber(int n, int[] primes) {

        if(n==1){
            return n;
        }
        /*
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        long res = 1L;
        heap.offer(1L);
        set.add(1L);

        for(int i=1;i<=n;i++){
            res = heap.poll();
            for(int j=0;j<primes.length;j++){
                if(set.add((long)res*primes[j])){
                    heap.offer((long)res*primes[j]);
                }
            }
        }
        return (int)res;
        */
        int m = primes.length;
        int[] dp = new int[n+1];
        int[] p = new int[primes.length];
        int[] nums = new int[primes.length];
        Arrays.fill(p,1);
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            int min = dp[i-1];
            int place = 0;
            for(int j=0;j<m;j++){
                nums[j] = dp[p[j]]*primes[j];
                if(nums[j]>dp[i-1]&&nums[j]<min){
                    min = nums[j];
                    place= j;
                }
            }
            p[place]++;
            dp[i] = min;
        }

        return dp[n];

    }
}
