package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/18 11:14
 *  @description
 *  @Version V1.0
 */

import java.util.ArrayList;
import java.util.List;

public class WordBreakCase {
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        String s = "catsanddog";
        System.out.println(wordBreak(s,wordDict));

    }

    public static List<String> wordBreak(String s, List<String> wordDict) {

        int n = s.length();
        boolean[][] dp = new boolean[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                dp[i][j] = wordDict.contains(s.substring(i-1,j));
            }
        }
        List<String> res = new ArrayList<>();
        backTrack(dp,res,1,new String(),s);

        return res;


    }

    public static void backTrack(boolean[][] dp, List<String> res, int index, String ans, String s){
        if(index==dp.length){
            res.add(ans.substring(1,ans.length()));
            return;
        }
        for(int j=index;j<dp[0].length;j++){
            if(dp[index][j]){
                String a = ans +" "+ s.substring(index-1,j);
                backTrack(dp,res,j+1,new String(a),s);
            }
        }

    }
}
