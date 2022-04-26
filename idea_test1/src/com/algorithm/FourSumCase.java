package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/12/13 16:53
 *  @description
 *  @Version V1.0
 */

import java.util.*;

public class FourSumCase {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 10000, 10000, 10000};
        int target = 10000;

        System.out.println(fourSum(nums, target));
    }


    static boolean[] visited;

    public static List<List<Integer>> fourSum(int[] nums, int target) {
//        visited = new boolean[nums.length];
//        Arrays.sort(nums);
//        List<List<Integer>> res = new ArrayList<>();
//
//        backTrack(nums,0,res,new ArrayList<>(),target);
//        return res;

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        int n = nums.length;


        for (int i = 0; i < n; i++) {
            System.out.println("11");
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            if (i > n - 4 || nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {
                System.out.println("22");
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if (j > n - 3 || nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) {
                    continue;
                }
                int left = j + 1;
                int right = n - 1;
                int cur = target - nums[i] - nums[j];

                while (left < right) {
                    System.out.println("33");
                    if (nums[left] + nums[right] < cur) {
                        left++;
                    } else if (nums[left] + nums[right] > cur) {
                        right--;
                    } else {
                        ans.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    }
                }

            }


        }

        return ans;


    }


    public static void backTrack(int[] nums, int index, List<List<Integer>> res, List<Integer> ans, int target) {

        if (ans.size() == 4 && target == 0) {
            res.add(ans);
            return;
        }
        if (ans.size() == 4 || index == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            ans.add(nums[i]);
            backTrack(nums, i + 1, res, new ArrayList<>(ans), target - nums[i]);
            ans.remove(ans.size() - 1);
            visited[i] = false;
        }
    }

}
