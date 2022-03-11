package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/10 20:51
 *  @description 79. 单词搜索
 *  @Version V1.0
 */

import java.io.*;

public class ExistCase {



    public static void main(String[] args) {
        char[][] board =
                {
                        {'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}
                };
        String word = "ABCCED";
        //exist(board,word);

        String s = new String("123");
        System.out.println(s);
        s = s+"231";
        System.out.println(s);
    }

    public static boolean exist(char[][] board, String word) {
        //暴力匹配
        int i=0;

        for(char[] chars:board){
            for(char ch: chars){
                if(word.charAt(i)==ch){
                    i++;
                }
            }
        }
        if(i<word.length()){
            return false;
        } else {
            return true;
        }



    }


}
