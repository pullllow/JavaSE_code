package com.leetcode.train;
/*
 *  @author changqi
 *  @date 2022/2/21 10:17
 *  @description
 *  @Version V1.0
 */

import java.util.LinkedList;
import java.util.Queue;

public class PushDominoesCase {

    public static void main(String[] args) {
        String dominoes = "L.....RR.RL.....L.R.";
        String s = "RR.L";
        System.out.println(pushDominoesBFS(s));
        //System.out.println(pushDominoesBFS(s));
    }


    public static String pushDominoes(String dominoes) {

        char[] chs = dominoes.toCharArray();

        int n = dominoes.length();


        for (int i = 0; i < n; i++) {
            if (chs[i] == '.') continue;
            if (chs[i] == 'L') {
                for (int j = i - 1; j >= 0; j--) {
                    chs[j] = 'L';
                }

                continue;
            }

            int len = 0;
            for (int j = i + 1; j < n && chs[j] == '.'; j++) {
                chs[j] = 'R';
                len++;
            }
            int end = i + len + 1;
            if (end == n) break;
            if (chs[end] == 'R') {
                continue;
            }

            int mid = i + len / 2 + 1;
            if (len % 2 == 1) {
                chs[mid++] = '.';
            }
            while (mid < end) {
                chs[mid++] = 'L';
            }
            i = end;
        }

        return new String(chs);


    }

    public static String pushDominoesBFS(String dominoes) {
        int n = dominoes.length();

        char[] chs = dominoes.toCharArray();

        int[] times = new int[n];

        //Arrays.fill(times,-1);

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == '.') continue;
            times[i] = 1;
            queue.offer(new int[]{i, times[i], dominoes.charAt(i) == 'L' ? -1 : 1});
        }


        while (!queue.isEmpty()) {
            int[] status = queue.poll();
            int loc = status[0] + status[2];
            int time = status[1]+1;
            int f = status[2];

            if (loc < 0 || loc == n) {
                continue;
            }

            if (times[loc] < time) {
                times[loc] = time ;
                queue.offer(new int[]{loc, time , f});
                chs[loc] = f == 1 ? 'R' : 'L';
            } else {

                chs[loc] = '.';
            }
        }

        return new String(chs);


    }
}
