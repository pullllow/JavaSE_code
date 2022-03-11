package com.datastructure.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1034};

        System.out.println(binarySearch(arr, 89));
        //System.out.println(insertValueSearch(arr, 0, arr.length - 1, 1000));

    }

    //查找要找的数据
    public static int binarySearch1(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (midVal > findVal) {
            return binarySearch1(arr, left, mid - 1, findVal);
        } else if (midVal < findVal) {
            return binarySearch1(arr, mid + 1, right, findVal);
        } else {
            return mid;
        }
    }


    //查找要找的数据，并返回所有可能的位置
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (midVal > findVal) {
            return binarySearch2(arr, left, mid - 1, findVal);
        } else if (midVal < findVal) {
            return binarySearch2(arr, mid + 1, right, findVal);
        } else {
            ArrayList<Integer> valueIndexList = new ArrayList<>();
            int temp = mid;
            while ((temp < arr.length) && (arr[temp] == findVal)) {
                valueIndexList.add(temp);
                temp++;
            }
            temp = mid - 1;
            while ((temp >= 0) && (arr[temp] == findVal)) {
                valueIndexList.add(temp);
                temp--;
            }
            return valueIndexList;
        }
    }


    //插值查找找到要找的数据
    //查找要找的数据
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        if ((left > right) || (findVal < arr[0]) || (findVal > arr[arr.length - 1])) {
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (midVal > findVal) {
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else if (midVal < findVal) {
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else {

            return mid;
        }
    }


    //非递归实现二分查找
    public static int binarySearch(int[] arr, int findVal) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left+right)/2;
            if (arr[mid] > findVal) {
                right = mid - 1;
            } else if (arr[mid] < findVal) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;


    }
}
