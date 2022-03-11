package com.leetcode.trie;
/*
 *  @author changqi
 *  @date 2021/12/29 15:04
 *  @description
 *  @Version V1.0
 */

import java.util.ArrayList;
import java.util.List;

public class FindWordsCase {
    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain", "hklf", "hf","oao"};

        List<String> res = findWords(board, words);
        System.out.println(res);
    }

    public static List<String> findWords(char[][] board, String[] words) {

        int m = board.length;
        int n = board[0].length;

        List<String> res = new ArrayList<>();
        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int size = res.size();

                dfs(board, trie.root, "", i, j, res,new boolean[m][n]);

                if (size != res.size()) {
                    trie.delete(res.get(res.size() - 1));
                }
            }
        }

        return res;

    }

    public static void dfs(char[][] board, TrieNode node, String cur, int x, int y, List<String> res,boolean[][] visited) {
        if (node.end > 0) {
            //System.out.println(cur);

            res.add(cur);
            node.end = 0;

        }

        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length|| visited[x][y]) {
            return;
        }
        int index = board[x][y] - 'a';
        TrieNode next = node.nexts[index];
        if (next != null) {
            String temp = cur + board[x][y];
            visited[x][y] = true;
            dfs(board, next, temp, x + 1, y, res,visited);
            dfs(board, next, temp, x - 1, y, res,visited);
            dfs(board, next, temp, x, y - 1, res,visited);
            dfs(board, next, temp, x, y + 1, res,visited);
            visited[x][y] = false;
        }


    }


    public static class TrieNode {
        public int end;
        public int path;
        public TrieNode[] nexts;

        public TrieNode() {
            end = 0;
            path = 0;
            nexts = new TrieNode[26];
        }

    }

    public static class Trie {

        public TrieNode root;


        public Trie() {
            root = new TrieNode();
        }

        public void insert(String str) {

            char[] chs = str.toCharArray();

            int index = 0;
            TrieNode node = root;

            for (char ch : chs) {
                index = ch - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }

                node = node.nexts[index];
                node.path++;
            }
            node.end++;

        }

        public void delete(String str) {
            char[] chs = str.toCharArray();

            int index = 0;
            TrieNode node = root;

            for (char ch : chs) {
                index = ch - 'a';
                if (--node.nexts[index].path == 0) {
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];

            }
            node.end--;
        }
    }
}
