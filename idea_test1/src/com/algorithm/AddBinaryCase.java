package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/9 19:22
 *  @description 67. 二进制求和
 *  @Version V1.0
 */

public class AddBinaryCase {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a,b));
    }
    public static String addBinary(String a, String b) {

        int carry =0;
        StringBuffer res = new StringBuffer();
        int max = a.length()>b.length()?a.length():b.length();
        for(int i =0;i<max;i++){
            //a.charAt(a.length()-1-i)-'0'
            //b.charAt(b.length()-1-i)-'0'
            carry += i<a.length()?a.charAt(a.length()-1-i)-'0':0;
            carry += i<b.length()?b.charAt(b.length()-1-i)-'0':0;
            res.append((char)( carry % 2 + '0'));
            carry = carry/2;
        }
        if(carry==1){
            res.append('1');
        }
        res.reverse();
        return res.toString();
    }
}
