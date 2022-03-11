package com.leetcode.backtrack;
/*
 *  @author changqi
 *  @date 2022/1/10 10:18
 *  @description
 *  @Version V1.0
 */

import java.util.ArrayList;
import java.util.List;

public class IsAdditiveNumberCase {
    public static void main(String[] args) {
        String num = "199100199";
        isAdditiveNumber(num);
    }

    public static boolean isAdditiveNumber(String num) {
        return backTrack(num,0,new ArrayList<Integer>());
    }

    public static boolean backTrack(String num, int index, List<Integer> ans) {
        if(index==num.length() && ans.size()>2){
            return true;
        }
        int n = ans.size();
        int cur = 0;
        boolean flag = false;
        for(int i=index;i<num.length();i++) {
            cur = cur*10 + (num.charAt(i)-'0');
            ans.add(cur);
            //ans.add(cur);
            System.out.println(i+"   "+cur+"   "+ans);
            if( n<2 || (n>1&& cur==ans.get(n-1)+ans.get(n-2))){
                flag |=backTrack(num,i+1,ans);
            } else if(n>1&& cur>ans.get(n-1)+ans.get(n-2)){
                break;
            }


            ans.remove(n);

        }

        return flag;



    }
}
