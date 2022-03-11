package com.leetcodeweek.singleweek02_1205;
/*
 *  @author changqi
 *  @date 2021/12/5 11:42
 *  @description
 *  @Version V1.0
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ValidArrangementCase {
    public static void main(String[] args) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int N = 100;
//        for(int i=0;i<N;i++){
//            heap.add(i);
//        }
        heap.add(1);
        heap.add(2);
        heap.add(-1);
        heap.add(100);
        Object[] nums = heap.toArray();
        for(Object num: nums)  {
            System.out.println((int)num);
        }

        //System.out.println(heap.toArray().toString());


        //int[][] pairs = //{[999,990],[356,511],[192,879],[246,945],[322,602],[776,246],[248,126],[503,284],[126,164],[494,731],[862,382],[731,578],[511,277],[122,731],[578,99],[731,277],[847,538],[246,494],[284,138],[382,899],[811,439],[164,99],[485,307],[618,320],[494,511],[413,248],[945,356],[990,614],[138,18],[164,862],[277,164],[826,737],[277,322],[618,122],[291,639],[288,11],[624,485],[740,452],[614,740],[307,903],[457,412],[538,961],[439,122],[961,999],[639,822],[903,503],[961,776],[138,538],[122,826],[99,138],[949,175],[452,847],[320,624],[879,457],[511,961],[835,692],[18,949],[737,413],[822,999],[11,726],[692,618],[899,835],[726,192],[999,452],[602,811],[452,618],[175,246],[99,291],[412,494]]};

        //validArrangement(pairs);

    }

    public static int[][] validArrangement(int[][] pairs) {

        int n = pairs.length;

        for (int i = 0; i < pairs.length; i++) {
            List<int[]> res = new ArrayList<>();
            res.add(new int[]{pairs[i][0], pairs[i][1]});
            boolean[] flag = new boolean[n];
            flag[i] = true;
            int count = 1;
            int lastcount = count;
            while (count < n) {
                int index = 0;
                lastcount = count;
                while (index < n) {
                    if (flag[index]) {
                        index++;
                        continue;
                    } else {
                        if (res.get(0)[0] == pairs[index][1]) {
                            res.add(0, new int[]{pairs[index][0], pairs[index][1]});
                            flag[index] = true;
                            count++;
                            index = 0;
                        } else if (res.get(res.size() - 1)[1] == pairs[index][0]) {
                            res.add(new int[]{pairs[index][0], pairs[index][1]});
                            flag[index] = true;
                            count++;
                            index = 0;
                        } else {
                            index++;
                        }
                    }
                }
                if (lastcount == count) {
                    break;
                }
            }
            if (count == n) {
                return res.toArray(new int[n][2]);
            }
        }

        return new int[n][2];

    }

}
