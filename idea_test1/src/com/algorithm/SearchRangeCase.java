package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/10/19 20:16
 *  @description 34. 在排序数组中查找元素的第一个和最后一个位置
 *  @Version V1.0
 */

import java.util.Arrays;

public class SearchRangeCase {
    public static void main(String[] args) {
        int[] nums = {1,4};
        int target = 4;
        int[] searchRange = searchRange(nums, target);
        System.out.println(Arrays.toString(searchRange));

    }

    public static int[] searchRange(int[] nums, int target) {

        int[] position = new int[2];
        if(nums.length==0){
            position[0] = -1;
            position[1] = -1;
            return position;
        }
        position[0] = 0;
        position[1] = nums.length -1;

        int mid = (position[0]+position[1])/2;
        while(position[0]<position[1]){
            if(target<nums[mid]){
                position[1] = mid;
            } else if (target > nums[mid]) {
                position[0] = mid+1;
            } else {
                break;
            }
            mid = (position[0]+position[1])/2;

        }
        if(nums[mid]!=target && (position[1]==position[0])){
            position[0] = -1;
            position[1] = -1;
            return position;

        }
        for(int i=position[0];i<=position[1];i++){
            if(nums[i]<target){
                position[0]++;
            } else if(nums[i]>target) {
                position[1] = i-1;
                break;
            }
        }
        return position;

    }
}
