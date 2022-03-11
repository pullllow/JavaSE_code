package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/10/27 16:49
 *  @description 129 最长连续序列
 *  @Version V1.0
 */

import java.util.*;

public class LongestConsecutiveCase {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));


    }

    /*
    public static int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Map<Integer, Integer> endMap = new HashMap<>();

        for(int num:nums){
            queue.offer(num);
        }
        int length =1;
        for(int i=0;i<nums.length;i++){
            int cur = queue.poll();
            if(!endMap.containsKey(cur)) {
                if (endMap.containsKey(cur - 1)) {
                    endMap.put(cur, endMap.getOrDefault(cur - 1, 0) + 1);
                    endMap.remove(cur - 1);
                } else {
                    endMap.put(cur, 1);
                }
            }

        }

        Set<Map.Entry<Integer,Integer>> entries = endMap.entrySet();
        for(Map.Entry<Integer,Integer> entry: entries){
            if(entry.getValue()>length){
                length = entry.getValue();
            }
        }
        return length;

    }*/



    //并查集
    public static int longestConsecutive(int[] nums) {

        if(nums.length<=1){
            return nums.length;
        }

        UnionFind uf = new UnionFind(nums);
        for(int num:nums){
            uf.union(num,num+1);
        }

        int max = 1;
        for(int num:nums){
            max = Math.max(max,uf.findHead(num)-num+1);
        }
        return max;


    }

    public static class UnionFind{
        public Map<Integer,Integer> fatherMap;

        public UnionFind(int[] nums) {
            fatherMap = new HashMap<>();

            for(int num: nums){
                fatherMap.put(num,num);
            }
        }

        public int findHead(int a){
            Stack<Integer> path = new Stack<>();

            while(a!=fatherMap.get(a)) {
                path.push(a);
                a = fatherMap.get(a);
            }
            while(!path.isEmpty()) {
                fatherMap.put(path.pop(),a);
            }
            return a;
        }

        public void union(int a, int b) {
            if(fatherMap.containsKey(a) && fatherMap.containsKey(b)) {
                int aF = findHead(a);
                int bF = findHead(b);
                if(aF!= bF) {
                    fatherMap.put(Math.min(aF,bF),Math.max(aF,bF));
                }
            }
        }
    }

}
