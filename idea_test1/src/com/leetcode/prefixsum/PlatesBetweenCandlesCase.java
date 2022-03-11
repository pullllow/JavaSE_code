package com.leetcode.prefixsum;
/*
 *  @author changqi
 *  @date 2022/3/8 10:45
 *  @description
 *  @Version V1.0
 */

public class PlatesBetweenCandlesCase {

    public static void main(String[] args) {
        String s =  "***|**|*****|**||**|*";

        int[][] queries = {{1,17},{4,5},{14,17},{5,11},{15,16}};

        int[] ints = platesBetweenCandles(s, queries);
    }

    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int n = queries.length;

        int[] res = new int[n];

        int len = s.length();
        int[] prefix = new int[len+1];

        int[] lc = new int[len];
        int[] rc = new int[len];

        for(int i=0;i<len;i++) {
            if(s.charAt(i)=='|') {
                prefix[i+1] = prefix[i]+1;
                lc[i]=i;
            } else {
                prefix[i+1] = prefix[i];
                lc[i] = i==0?-1:lc[i-1];
            }
            if(s.charAt(len-i-1)=='|') {
                rc[len-1-i] = len-1-i;
            } else {
                rc[len-1-i] = i==0?-1:rc[len-i];
            }
        }

        for(int i=0;i<n;i++){
            if(queries[i][0]==queries[i][1]) continue;
            int left = rc[queries[i][0]];
            int right = lc[queries[i][1]];
            res[i] = right-left-(prefix[right+1]-prefix[left]);
        }

        return res;




    }
}
