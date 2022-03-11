package com.datastructure.trietree;
/*
 *  @author changqi
 *  @date 2021/12/1 15:55
 *  @description
 *  @Version V1.0
 */

import java.util.HashMap;
import java.util.Map;

public class TrieTreeDemo {

    public static void main(String[] args) {

        String[] words = {"abc", "abc", "abe", "be", "ab"};

        Trie trie = new Trie();

        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }

        System.out.println("___________");

        System.out.println(trie.search("abc"));
        System.out.println();

    }
}


class TrieNode {
    public int path;
    public int end;

    public Map<Character, TrieNode> nexts;


    public TrieNode() {
        path = 0;
        end = 0;
        nexts = new HashMap<>();
    }
}


class Trie {
    public TrieNode root;


    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null) {
            return;
        }

        char[] chs = word.toCharArray();
        TrieNode node = root;

        for (int i = 0; i < chs.length; i++) {
            if (!node.nexts.containsKey(chs[i])) {
                node.nexts.put(chs[i], new TrieNode());
            }
            node.path++;
            node = node.nexts.get(chs[i]);

        }
        node.path++;
        node.end++;

    }

    public int search(String word) {
        if (word == null) {
            return 0;
        }

        char[] chs = word.toCharArray();
        TrieNode node = root;

        for(int i=0;i<chs.length;i++){
            if(!node.nexts.containsKey(chs[i])) {
                return 0;
            }
            node = node.nexts.get(chs[i]);
        }

        return node.end;

    }


    public void delete(String word) {
        if(search(word)==0) {
            return;
        }

        char[] chs = word.toCharArray();
        TrieNode node = root;
        for(char ch: chs) {
            if(--node.nexts.get(ch).path==0){
                node.nexts.put(ch,null);
            }

            node = node.nexts.get(ch);

        }

        node.end--;

    }

    public int prefixNum(String word) {
        if(word==null) {
            return 0;
        }

        char[] chs = word.toCharArray();

        TrieNode node = root;

        for(char ch: chs) {
            if(!node.nexts.containsKey(ch)){
                return 0;
            }
            node = node.nexts.get(chs);

        }

        return node.path;
    }


}