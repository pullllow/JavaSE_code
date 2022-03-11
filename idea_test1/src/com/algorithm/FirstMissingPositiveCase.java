package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/10/27 16:25
 *  @description 41. 缺失的第一个正数
 *  @Version V1.0
 */

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FirstMissingPositiveCase {
    public static void main(String[] args) {
        int[] nums = {1,2,3,10,2147483647,9};
        System.out.println(firstMissingPositive(nums));

    }

    public static int firstMissingPositive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        int max =  0;
        for(int num:nums){
            if(num>0){
                map.put(num, map.getOrDefault(num,0)+1);
            }
            if(num>max){
                max = num;
            }
        }
        if(max>0){
            for(int i=1;i<max+2;i++){
                if(!map.containsKey(i)){
                    return i;
                }
            }
        }
        return 1;
    }
}
