package com.learnJava3;

import java.util.HashSet;
import java.util.Set;

public class SetDemo1 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("123");
        set.add("123");
        set.add("123");

        for(String s : set){
            System.out.println(s);
            System.out.println(s.hashCode());
        }
        System.out.println(set.hashCode());

    }
}
