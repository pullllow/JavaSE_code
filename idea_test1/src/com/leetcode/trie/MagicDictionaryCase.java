package com.leetcode.trie;
/*
 *  @author changqi
 *  @date 2021/12/29 19:21
 *  @description 676. 实现一个魔法字典
 *  @Version V1.0
 */

public class MagicDictionaryCase {

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();

        String[] dictionary = {"hello", "leetcode"};

        magicDictionary.buildDict(dictionary);

        System.out.println(magicDictionary.search("hello"));
        System.out.println(magicDictionary.search("heelo"));
        System.out.println(magicDictionary.search("hell"));
        System.out.println(magicDictionary.search("leetcoded"));
        System.out.println(magicDictionary.search("helll"));
        System.out.println(magicDictionary.search("loetcode"));
        System.out.println(magicDictionary.search("hllll"));

    }
}

class MagicDictionary {
    public TrieNode root;

    public MagicDictionary() {
        root = new TrieNode();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            if (word == null || word.length() == 0) {
                continue;
            }
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.ch = ch;
            }
            node.end++;
            node.val = word;
        }
    }

    public boolean search(String searchWord) {

        return dfs(searchWord, root, 0, false);

    }


    public boolean dfs(String searchWord, TrieNode node, int cur, boolean isReplaced) {
        if (cur == searchWord.length()) {
            return node.end > 0 && isReplaced;
        }

        char ch = searchWord.charAt(cur);
        int index = ch - 'a';

        //不替换
        boolean noReplaced = node.nexts[index] == null ? false :
                dfs(searchWord, node.nexts[index], cur + 1, isReplaced);

        //替换当前
        boolean replaced = false;
        for (TrieNode next : node.nexts) {
            if (!isReplaced &&next != null && next != node.nexts[index]) {
                replaced |= dfs(searchWord, next, cur + 1, true);
            }
        }

        return noReplaced||replaced;

    }

    public class TrieNode {
        public int end;
        public String val;
        public char ch;

        public TrieNode[] nexts;

        public TrieNode() {
            end = 0;
            val = null;

            nexts = new TrieNode[26];
        }

    }
}