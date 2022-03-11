package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/10/19 15:27
 *  @description 287 查找数组里的重复数字
 *  @Version V1.0
 */

public class GetDuplicationCase {
    public static void main(String[] args) {
        int N = 5;
        int[] ints = {1, 3, 4, 2, 2};

        int duplication1 = getDuplication(ints);
        System.out.println(duplication1);
        int duplication2 = getDuplicationDoublePoint(ints);
        System.out.println(duplication2);


    }

    public static int getDuplication(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int length = nums.length;
        int start = 1;
        int end = length - 1;

        while (end >= start) {
            int mid = (start + end) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= start && nums[i] <= mid) {
                    count++;
                }
            }
            if (end == start) {
                if (count > 1) {
                    return end;
                } else {
                    break;
                }
            }
            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }


        }
        return -1;
    }


    public static int getDuplicationDoublePoint(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int fast = 0;
        int slow = 0;

        while (true) {
            fast = nums[nums[nums[fast]]];
            slow = nums[slow];
            if (fast == slow) {
               break;
            }
        }
        int finder = 0;
        while (true){
            finder = nums[finder];
            slow = nums[slow];
            if(finder == slow ){
                break;
            }
        }

        return finder;
    }


}
