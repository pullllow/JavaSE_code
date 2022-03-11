package com.leetcodeweek.singleweek01_1128;
/*
 *  @author changqi
 *  @date 2021/11/28 10:53
 *  @description
 *  @Version V1.0
 */

import java.util.*;

public class GetAveragesCase {

    public static void main(String[] args) {

        int n = 6;
        int[][] meetings = {{1, 2, 5}, {2, 3, 5}, {2, 3, 8}, {1, 5, 10}};

        int firstPerson = 1;

        System.out.println(findAllPeople(n, meetings, firstPerson));
    }


    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        ArrayList<int[]>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] meeting : meetings) {
            lists[meeting[0]].add(new int[]{meeting[1], meeting[2]});
            lists[meeting[1]].add(new int[]{meeting[0], meeting[2]});
        }
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((o, p) -> o[1] - p[1]);
        for (queue.addAll(Set.of(new int[2], new int[]{firstPerson, 0})); !queue.isEmpty(); ) {
            int[] poll = queue.poll();
            if (lists[poll[0]] != null) {
                list.add(poll[0]);
                for (int[] i : lists[poll[0]]) {
                    if (i[1] >= poll[1]) {
                        queue.offer(i);
                    }
                }
                lists[poll[0]] = null;
            }
        }
        return list;
    }

    public static List<Integer> findAllPeople1(int n, int[][] meetings, int firstPerson) {
        List<Integer> res = new ArrayList<>();


        Set<Integer> set = new HashSet<>();
        set.add(0);
        set.add(firstPerson);

        int m = meetings.length;

        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        int max = 0;
        for (int i = 0; i < m; i++) {
            heap.offer(meetings[i]);
            max = Math.max(max, meetings[i][2]);
        }
        Map<Integer, Set<Integer>> temp = new HashMap<>();
        int curNum = 0;
        int curTime = 0;
        while (heap.size() != 0) {
            int[] cM = heap.poll();
            if (curTime != cM[2]) {
                temp = new HashMap<Integer, Set<Integer>>();
                curTime = cM[2];
                curNum = 0;
            } else {
                curNum++;
            }

            int x = cM[0];
            int y = cM[1];
            Set<Integer> xMeeting = temp.getOrDefault(x, new HashSet<Integer>());
            Set<Integer> yMeeting = temp.getOrDefault(y, new HashSet<Integer>());
            xMeeting.add(curNum);
            yMeeting.add(curNum);
            temp.put(x, xMeeting);
            temp.put(y, yMeeting);
            if (set.contains(x) && !set.contains(y)) {
                Set<Map.Entry<Integer, Set<Integer>>> entries = temp.entrySet();
                for (Map.Entry<Integer, Set<Integer>> entry : entries) {
                    Iterator<Integer> i = yMeeting.iterator();
                    while (i.hasNext()) {
                        int next = i.next();
                        if (entry.getValue().contains(next)) {
                            set.add(entry.getKey());
                        }
                    }
                }

            }


        }

        Iterator<Integer> i = set.iterator();
        while (i.hasNext()) {
            res.add(i.next());
        }

        return res;


    }
}
