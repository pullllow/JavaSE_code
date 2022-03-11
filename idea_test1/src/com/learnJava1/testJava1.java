package com.learnJava1;

import java.util.Scanner;

public class testJava1 {
    public static void main(String[] args) {
        String s1 = "abc";
        System.out.println(s1);

        char[] c1 = {'a', 'b', 'c'};
        String s2 = new String(c1);
        System.out.println(s2);
        System.out.println(s1 == s2);

    }
}
