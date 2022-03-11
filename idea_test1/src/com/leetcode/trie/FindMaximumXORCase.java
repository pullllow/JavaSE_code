package com.leetcode.trie;
/*
 *  @author changqi
 *  @date 2022/3/9 10:38
 *  @description
 *  @Version V1.0
 */

public class FindMaximumXORCase {
    public static void main(String[] args) {
        int[] nums = {3,10,5,25,2,8};
        findMaximumXOR(nums);
    }

    public static int findMaximumXOR(int[] nums) {

        Trie1 trie = new Trie1();
        int res = 0;
        for(int num: nums) {
            res = Math.max(res,trie.check(num));
            trie.insert(num);

        }

        return res;





    }


}
class Trie1{
    public Node head = new Node();
    public static int MAX_DIGIT = 32;
    public class Node {
        public Node[] nexts = new Node[2];


    }
    public void insert(int num) {
        Node cur = head;
        for(int i=0;i<MAX_DIGIT && (num>>i)!=0;i++) {
            int dig = num>>i &1;

            if(cur.nexts[dig]==null) {
                cur.nexts[dig] = new Node();
            }
            cur = cur.nexts[dig];
        }
    }

    public int check(int num) {
        Node cur = head;
        int res = 0;
        for(int i=0;i<MAX_DIGIT;i++) {
            int dig = ((num>>i)-1)&1;

            if(cur.nexts[dig]!=null) {
                res |= 1<<i;
                cur = cur.nexts[dig];
            } else {
                if(cur.nexts[dig^1]!=null) {
                    //res |= 0<<i;
                    cur = cur.nexts[dig^1];
                } else {
                    break;
                }
            }

        }
        System.out.println(num+"  "+res);
        return res^num;
    }
}