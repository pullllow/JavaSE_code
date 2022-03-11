package com.demo.trietree;
/*
 *  @author changqi
 *  @date 2021/12/6 20:34
 *  @description
 *  @Version V1.0
 */

import java.util.HashSet;
import java.util.Set;

public class Trie {
    public TrieNode root;


    private class TrieNode {

        public int path;
        public int end;

        public String val;//记录字符串

        public TrieNode[] nexts;

        public TrieNode() {

            path = 0;
            end = 0;
            val = null;
            nexts = new TrieNode[26];

        }
    }

    public Trie(){
        root = new TrieNode();
    }

    /**
     * @Description insert 将字符串str插入到字符串中
     * @param str
     * @return void
     **/
    public void insert(String str ){
        if(str==null) {
            return;
        }

        char[] chs = str.toCharArray();
        TrieNode node = root;
        int index = 0;

        for(char ch: chs) {
            index = ch-'a';
            if(node.nexts[index]==null){
                node.nexts[index]  = new TrieNode();
            }

            node = node.nexts[index];
            node.path++;
        }

        node.end++;
        node.val = str;

    }

    /**
     * @Description search 搜索str在前缀树中出现的次数
     * @param str
     * @return int
     **/
    public int search(String str) {
        if (str==null) {
            return 0;
        }
        char[] chs = str.toCharArray();
        TrieNode node = root;
        int index = 0;

        for(char ch: chs) {
            index = ch-'a';
            if(node.nexts[index]==null){
                return 0;
            }
            node = node.nexts[index];
        }
         return node.end;
    }

    /**
     * @Description delete删除一个字符串，若存在多个则只删除一个
     * @param str
     * @return void
     **/
    public void delete(String str) {
        if(search(str)==0){
            return;
        }
        char[] chs = str.toCharArray();
        TrieNode node = root;
        int index = 0;

        for(char ch: chs) {
            index = ch-'a';

            if(--node.nexts[index].path==0){
                node.nexts[index]=null;
                return;
            }
            node = node.nexts[index];
        }
        node.end--;
        node.val = null;

    }

    /**
     * @Description prefixNum以字符串str为前缀的字符串的数量
     * @param str
     * @return int
     **/
    public int prefixNum(String str) {
        if(str==null) {
            return 0;
        }

        char[] chs = str.toCharArray();
        TrieNode node = root;
        int index = 0;

        for(char ch: chs) {
            index = ch-'a';
            if(node.nexts[index]==null){
                return 0;
            }
            node = node.nexts[index];
        }
        return node.path;
    }




}

