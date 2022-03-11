package com.leetcode.trie;
/*
 *  @author changqi
 *  @date 2021/12/28 10:05
 *  @description 472. 连接词
 *  @Version V1.0
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllConcatenatedWordsInADictCase {

    public static void main(String[] args) {
        String[] words =
                {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};

        List<String> allConcatenatedWordsInADict = findAllConcatenatedWordsInADict(words);
        System.out.println(allConcatenatedWordsInADict);
    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {

        Trie root = new Trie();

        List<String> res = new ArrayList<>();

        Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());

        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            if (!dfs(word, 0, root)) {
                root.insert(word);
            } else {
                res.add(word);
            }


        }
        return res;


    }

    public static boolean dfs(String str, int start, Trie trie) {
        if (str == null || str.length() == 0||str.length()==start) {
            return true;
        }
        TrieNode node = trie.root;
        for (int i = start; i < str.length(); i++) {
            char ch = str.charAt(i);
            int index = ch - 'a';

            if (node.nexts[index] == null) {
                return false;
            }
            if(node.nexts[index].end>0){
                if(dfs(str,i+1,trie)){
                    return true;
                }
            }
            node = node.nexts[index];

        }
        return false;
    }

    public static class TrieNode {
        public int path;
        public int end;
        public TrieNode[] nexts;

        public TrieNode() {
            this.path = 0;
            this.end = 0;

            this.nexts = new TrieNode[26];
        }


    }

    public static class Trie {
        public TrieNode root;


        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String str) {
            if (str == null || str.length() == 0) {
                return;
            }

            char[] chs = str.toCharArray();

            TrieNode node = root;
            int index = 0;

            for (char ch : chs) {
                index = ch - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                node.path++;
                node = node.nexts[index];
            }
            node.path++;
            node.end++;


        }


    }

}
