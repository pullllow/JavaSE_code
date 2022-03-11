package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/20 13:14
 *  @description 594. 最长和谐子序列
 *  @Version V1.0
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FindLHSCase {
    public static void main(String[] args) {
        int[] nums = {0,3,1,3,3,3,0,1,0,2,0,3,1,3,-3,2,0,3,1,2,2,-3,2,2,3,3};

        System.out.println(findLHS(nums));
    }

    public static int findLHS(int[] nums) {
        //Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        if(map.size()==1){
            return 0;
        }
        int maxLength = 0;

        for(int k: map.keySet()){
            if(map.containsKey(k+1)){
                maxLength = Math.max(maxLength, map.get(k)+map.get(k+1));
            }
        }

        return maxLength;


    }
}
