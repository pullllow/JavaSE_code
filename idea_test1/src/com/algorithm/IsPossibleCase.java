package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/10/25 16:34
 *  @description 659. 分割数组为连续子序列
 *  @Version V1.0
 */

import java.util.*;

public class IsPossibleCase {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 7, 8, 8, 9, 10, 11};//{1, 2, 3, 3, 4, 4, 5, 5};//

        System.out.println(isPossible(nums));

    }

    public static boolean isPossible(int[] nums) {
        Map<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, new ArrayList<>());
            }
            if (map.containsKey(num - 1)) {
                ArrayList<Integer> integers = map.get(num - 1).get(0);
                integers.add(num);
                map.get(num).add(0,integers);
                if (map.get(num - 1).size() == 1) {
                    map.remove(num - 1);
                } else {
                    map.get(num-1).remove(0);
                }
            } else {
                ArrayList<Integer> integers1 = new ArrayList<>();
                integers1.add(num);
                map.get(num).add(0,integers1);


            }


        }
        Set<Map.Entry<Integer, ArrayList<ArrayList<Integer>>>> entries = map.entrySet();
        for (Map.Entry<Integer, ArrayList<ArrayList<Integer>>> entry : entries) {
            Iterator<ArrayList<Integer>> iterator = entry.getValue().iterator();
            while (iterator.hasNext()) {
                if (iterator.next().size() < 3) {
                    return false;
                }
            }
        }


        return true;
    }
}
