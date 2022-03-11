package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/12/22 9:57
 *  @description
 *  @Version V1.0
 */

public class RepeatedStringMatchCase {
    public static void main(String[] args) {
        String a = "a";
        String b = "aa";

        System.out.println(repeatedStringMatch(a,b));
    }

    public static int repeatedStringMatch(String a, String b) {

        int aLen = a.length();
        int bLen = b.length();

        int count = 0;

        String appendStrA = "";

        System.out.println(bLen/aLen);
        while(++count<(bLen/aLen)+1){
            appendStrA += a;

        }
        System.out.println(appendStrA);
        System.out.println(count);
        int index = appendStrA.indexOf(b);
        if(index==-1){
            return -1;
        }

        return index+bLen> aLen*(count-1)?count:count-1;




    }
}
