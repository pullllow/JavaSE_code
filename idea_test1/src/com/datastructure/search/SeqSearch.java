package com.datastructure.search;

public class SeqSearch {
    public static void main(String[] args) {
        int[] arr ={1,9,11,-1,34,90};

    }

    public static int seqSearch(int[] arr, int val){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==val){
                return i;
            }
        }
        return -1;
    }
}
