package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/25 10:26
 *  @description
 *  @Version V1.0
 */

public class SearchCase {
    public static void main(String[] args) {
        int[] nums = {1,0,1,1,1};
        int target = 0;
        System.out.println(search1(nums,target));
    }

    public static int search(int[] nums, int target) {
        /*
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==target) return i;
        }
        return -1;
        */
        int l = 0;
        int r = nums.length-1;

        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]>=nums[l]){
                if(nums[mid]<target){
                    l = mid+1;
                } else {
                    if(target>=nums[l]){
                        r=mid;
                    } else {
                        l = mid+1;
                    }
                }
            } else{
                if(nums[mid]>=target){
                    r = mid;
                } else {
                    if(target<nums[l]){
                        l = mid+1;
                    } else {
                        r= mid;
                    }
                }
            }
        }
        return nums[l]==target?l:-1;
    }


    public static boolean search1(int[] nums, int target) {
        if(nums.length==1){
            return nums[0]==target;
        }
        int l = 0;
        int r = nums.length-1;

        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[l]==nums[mid]&&nums[r]==nums[mid]){
                l++;
                r--;
            } else if(nums[mid]>=nums[l]){
                if(nums[l]<=target&&nums[mid]>=target){
                    r = mid;
                } else {
                    l = mid+1;
                }
            } else if(nums[mid]<=nums[r]){
                if(nums[r]>=target&&nums[mid]<=target){
                    l = mid;
                } else {
                    r = mid-1;
                }
            }


        }
        return nums[l]==target;

    }
}
