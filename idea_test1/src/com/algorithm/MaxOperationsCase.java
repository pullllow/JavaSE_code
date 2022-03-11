package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/10/30 15:39
 *  @description 1679. K 和数对的最大数目
 *  @Version V1.0
 */

import java.util.HashMap;
import java.util.Map;

public class MaxOperationsCase {
    public static void main(String[] args) {
        int[] nums = {63,10,28,31,90,53,75,77,72,47,45,6,49,13,77,61,68,43,33,1,14,62,55,55,38,54,8,79,89,14,50,68,85,12,42,57,4,67,75,6,71,8,61,26,11,20,22,3,70,52,82,70,67,18,66,79,84,51,78,23,19,84,46,61,63,73,80,61,15,12,58,3,21,66,42,55,7,58,85,60,23,69,41,61,35,64,58,84,61,77,45,14,1,38,4,8,42,16,79,60,80,39,67,10,24,15,6,37,68,76,30,53,63,87,11,71,86,82,77,76,37,21,85,7,75,83,80,8,19,25,11,10,41,66,70,14,23,74,33,76,35,89,68,85,83,57,6,72,34,21,57,72,79,29,65,3,67,8,24,24,18,26,27,68,78,64,57,55,68,28,9,11,38,45,61,37,81,89,38,43,45,26,84,62,22,37,51,15,30,67,75,24,66,40,81,74,48,43,78,14,33,19,73,5,1,2,53,29,49,73,23,5};
        System.out.println(maxOperations(nums,59));

    }

    public static int maxOperations(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int count = 0;
        for(int num:nums){
            if(map.containsKey(num)){
                if(map.containsKey(k-num)&&k-num!=num){
                    count++;
                    map.put(num, map.getOrDefault(num,0)-1);
                    map.put(k-num, map.getOrDefault(k-num,0)-1);
                } else if(map.containsKey(k-num)&&k-num==num){
                    if(map.get(num)>=2){
                        count++;
                        map.put(num, map.getOrDefault(num,0)-1);
                        map.put(k-num, map.getOrDefault(k-num,0)-1);
                    }
                }
                if(map.containsKey(k)&&map.get(num)==0){
                    map.remove(num);

                }
                if(map.containsKey(k-num)&&map.get(k-num)==0){
                    map.remove(k-num);

                }
            }
        }

        return count;

    }
}
