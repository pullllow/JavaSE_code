package com.learnJava4;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/*
 * 统计键盘录入字符串中每个字符出现的次数
 * */
public class HashMapDemo5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("键盘输入字符串：");
        String line = sc.nextLine();

//        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        TreeMap<Character, Integer> hm = new TreeMap<Character, Integer>();
        for (int i = 0; i < line.length(); i++) {
            char key = line.charAt(i);

            Integer value = hm.get(key);
            if(value == null) {
                hm.put(key, 1);// !!!!!!!!!!

            } else {
                value++;
                hm.put(key, value);

            }

        }

        StringBuilder sb = new StringBuilder();
        Set<Character> keySet = hm.keySet();
        for(Character c: keySet){
            sb.append(c).append("(").append(hm.get(c)).append(")");
        }
        String result = sb.toString();

        System.out.println(result);

    }


}
