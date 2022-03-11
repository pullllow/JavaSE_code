package com.leetcode.slidingwindow;
/*
 *  @author changqi
 *  @date 2022/2/16 14:54
 *  @description 30. 串联所有单词的子串
 *  @Version V1.0
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubstringCase {
    public static void main(String[] args) {
        //String s = "barfoothefoobarman";
        //String[] words = {"foo","bar"};
        String s = "ababababab";
        String[] words = {"ababa","babab"};




        List<Integer> subString = findSubString(s, words);


    }


    public static List<Integer> findSubString(String s, String[] words) {

        List<Integer> res = new ArrayList<>();

        int l = words[0].length();
        int count = words.length;
        int len = l*count;

        Map<String, Integer> map = new HashMap<>();

        for(String word:words){
            map.put(word, map.getOrDefault(word,0)+1);
        }

        Map<String, Integer>[] slidingMap = new Map[count];


        for(int i=0;i<count;i++) {

            slidingMap[i] = new HashMap<>();
            int start = i;
            int end = len+i-1;

            for(int j=0;j<count;j++){
                String cur = s.substring(start+j*l,start+(j+1)*l);
                slidingMap[i].put(cur,slidingMap[i].getOrDefault(cur,0)+1);
            }

            while(end<s.length()){
                if(slidingMap[i].equals(map)){
                    res.add(start);
                }
                String begin = s.substring(start,start+l);
                slidingMap[i].put(begin,slidingMap[i].get(begin)-1);
                if(slidingMap[i].get(begin)==0) slidingMap[i].remove(begin);

                start += l;
                end += l;
                String cur = s.substring(end-l+1,end+1);
                slidingMap[i].put(cur,slidingMap[i].getOrDefault(cur,0)+1);

            }


        }

        return res;

    }
}
