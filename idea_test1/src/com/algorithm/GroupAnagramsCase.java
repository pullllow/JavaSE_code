package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/12/13 10:08
 *  @description
 *  @Version V1.0
 */

import java.util.*;

public class GroupAnagramsCase {
    public static void main(String[] args) {

        String[] str = {"","b"};

        System.out.println(groupAnagrams(str));

    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();
        List<int[]> counts = new ArrayList<>();


        for(String str:strs) {
            boolean check = false;

            for(int i=0;i<res.size();i++){
                check = true;
                List<String> cur = res.get(i);
                int[] count = counts.get(i);
                if(cur.get(0).length()!=str.length()){
                    check = false;
                }
                for(char ch:str.toCharArray()) {

                    if(count[ch-'a']!=1){
                        check = false;
                        break;
                    }
                }
                if(check){
                    cur.add(str);
                    break;
                }
            }
            if(!check){
                int[] curCount = new int[26];
                for(char ch:str.toCharArray()) {
                    curCount[ch-'a'] = 1;
                }
                List<String> cur = new ArrayList<>();
                cur.add(str);
                res.add(cur);
                counts.add(curCount);
            }
        }

        return res;

    }
}
