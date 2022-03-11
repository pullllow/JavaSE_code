package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/10/21 16:09
 *  @description 22. 括号生成

 *  @Version V1.0
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParenthesisCase {
    public static void main(String[] args) {
        String leftParenthesis = "(";
        String rightParenthesis = ")";
        int n = 2;
        List<String> strings = generateParenthesis(n);
        while (!strings.isEmpty()) {
            System.out.println(strings.get(0));
            strings.remove(0);

        }


    }

    /*
    public static List<String> generateParenthesis(int n) {
        List<String> strings = new ArrayList<>();
        String leftParenthesis = "(";
        String rightParenthesis = ")";
        while (n >= 1) {
            if (n == 1) {
                ArrayList<String> strings1 = new ArrayList<>();
                strings1.add(leftParenthesis + rightParenthesis);
                return strings1;
            } else {
                List<String> strings1 = generateParenthesis(n - 1);
                while (!strings1.isEmpty()) {
                    String s = strings1.get(0);
                    strings1.remove(0);
                    strings.add(leftParenthesis + s + rightParenthesis);

                    strings.add(leftParenthesis + rightParenthesis + s);
                    strings.add(s + leftParenthesis + rightParenthesis);

                }
                strings.remove(strings.size() - 1);
                return strings;
            }
        }
        return strings;
    }*/

    /*
    public static void dfs(List<String> res, int l, int r, int n, String ans) {
        if (l > n || r > n) {
            return;
        }
        if (l == n && r == n) {
            res.add(ans);
        }
        if (l >= r) {
            String s = new String(ans);
            dfs(res,l+1,r,n,ans+"(");

            dfs(res,l,r+1,n,ans+")");


        }


    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res,0,0,n,"");
        return res;
    }*/
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrack(0,0,n,res,new StringBuffer());
        return res;

    }

    public static void backTrack(int l, int r, int n,List<String> res, StringBuffer ans){
        if(l>n||r>n){
            ans.deleteCharAt(ans.length()-1);
            return;
        }
        if(l==n&&r==n){
            res.add(ans.toString());
        }
        if(l>=r){
            backTrack(l+1,r,n,res,new StringBuffer(ans).append("("));
            backTrack(l,r+1,n,res,new StringBuffer(ans).append(")"));
        }

    }


}
