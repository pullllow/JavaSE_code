package com.leetcode.trie;
/*
 *  @author changqi
 *  @date 2022/3/8 21:59
 *  @description
 *  @Version V1.0
 */

public class MinimumLengthEncodingCase {
    public static int sum;
    public static void main(String[] args) {
        String[] words = {"time","me","bell"};
        System.out.println(minimumLengthEncoding(words));
    }

    public static int minimumLengthEncoding(String[] words) {
        //int[] res = new int[words.length];

        Trie trie = new Trie();

        for(String word: words) {
            trie.insert(word);
        }
        Trie.len(trie.head,1);
        return Trie.sum;



    }


}
class Trie{
    public static int sum =0;
    public Node head = new Node();

    public class Node{
        public boolean isEnd;
        public Node[] nexts;
        public int out;
        public Node() {
            isEnd = false;
            nexts = new Node[26];
        }
    }

    public void insert(String word) {
        if(word==null || word.length()==0) {
            return;
        }

        Node cur = head;

        for(int i=word.length()-1;i>=0;i--) {
            int index = word.charAt(i)-'a';
            if(cur.nexts[index]==null) {
                cur.nexts[index] = new Node();
            }
            cur.out++;
            cur = cur.nexts[index];
        }


    }

    public static void len(Node head,int l){
        if(head.out==0) {
            sum += l+1;
            return;
        }

        for(Node next: head.nexts) {
            if(next!=null) {
                len(next,l+1);
            }

        }


    }
}