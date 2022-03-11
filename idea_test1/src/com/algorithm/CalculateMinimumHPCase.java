package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/18 15:19
 *  @description 174. 地下城游戏
 *  @Version V1.0
 */

public class CalculateMinimumHPCase {
    public static void main(String[] args) {
        int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(calculateMinimumHP(dungeon));
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1) {
                    if (j == n - 1) {
                        dp[i][j] = dungeon[i][j] > 0 ? 1 : 1 - dungeon[i][j];
                        //dp[i][j] = dungeon[i][j]   > 0 ? dungeon[i][j] - : 1 + ( - dungeon[i][j]);
                    } else {
                        dp[i][j] = dungeon[i][j] >= dp[i][j + 1] ? 1 : (dp[i][j + 1] - dungeon[i][j]);
                    }
                } else if (j == n - 1) {
                    dp[i][j] = dungeon[i][j] >= dp[i + 1][j] ? 1 : (dp[i + 1][j] - dungeon[i][j]);
                } else {
                    int temp = Math.min(dp[i + 1][j], dp[i][j + 1]);
                    dp[i][j] = dungeon[i][j] >= temp ? 1 : (temp - dungeon[i][j]);

                }
            }
        }


        return dp[0][0];

    }
}
