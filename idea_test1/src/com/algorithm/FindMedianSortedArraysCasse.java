package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/24 21:54
 *  @description
 *  @Version V1.0
 */

public class FindMedianSortedArraysCasse {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;


        int s1 = 0;
        int s2 = 0;


        int index = 0;
        int cur = 0;
        int last = 0;
        while (index < m + n) {
            if (s1 < m && s2 < n) {
                if (nums1[s1] <= nums2[s2]) {
                    cur = nums1[s1];
                    s1++;
                } else {
                    cur = nums2[s2];
                    s2++;
                }

            } else if (s2 < n) {
                cur = nums2[s2];
                s2++;
            } else if (s1 < m) {
                cur = nums1[s1];
                s1++;
            }
            if (index == (m + n) / 2) break;
            index++;
            last = cur;
        }

        return ((m + n) & 1) == 1 ? (double) cur : (double) (cur + last) / 2.0;


    }
}
