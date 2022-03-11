package com.leetcode.dfs;
/*
 *  @author changqi
 *  @date 2022/2/28 14:38
 *  @description 1601. 最多可达成的换楼请求数目
 *  @Version V1.0
 */

import java.util.Arrays;

public class MaximumRequestsCase {
    public static void main(String[] args) {
        int n = 5;
        int[][] requests = {{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}};
        maximumRequests(n, requests);

    }

    private static int res = 0;

    public static int maximumRequests(int n, int[][] requests) {

        dfs(requests, new int[n], 0, 0);
        return res;


    }

    public static void dfs(int[][] requests, int[] info, int cur, int ans) {
        if (cur == requests.length) {
            for (int i : info) {
                if (i != 0) return;
            }
            res = Math.max(ans, res);
            return;
        }


        //不选择
        dfs(requests, Arrays.copyOf(info, info.length), cur + 1, ans);
        //选择该用户
        info[requests[cur][0]]--;
        info[requests[cur][1]]++;

        dfs(requests, Arrays.copyOf(info, info.length), cur + 1, ans + 1);
        info[requests[cur][0]]++;
        info[requests[cur][1]]--;

        final Word w = new Word();
        //w = new Word();
        //w.name = 2;
        //return Math.max(yes,no);
    }

}


class Word{
    public final int name = 1;
}