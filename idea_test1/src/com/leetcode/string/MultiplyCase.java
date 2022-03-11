package com.leetcode.string;
/*
 *  @author changqi
 *  @date 2021/12/22 10:55
 *  @description 43 字符串相乘
 *  @Version V1.0
 */

import java.util.*;
import java.util.ArrayList;

public class MultiplyCase {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";

        System.out.println(multiply(num1,num2));





    }

    public static String multiply(String num1, String num2) {


        int j = num2.length()-1;

        String res = "";
        String temp = "";
        String zero = "0";
        while(j>=0){
            int i = num1.length()-1;
            String cur = temp;
            int n = num2.charAt(j--)-'0';
            int carry = 0;
            while(i>=0){
                int n1 = num1.charAt(i--)-'0';

                char ch = (char)('0' + (n1*n)%10 + carry);

                cur = ch+ cur;

                carry = (n1*n)/10;
            }
            if(carry>0){
                cur = (char)('0' +  carry)+ cur;
            }

            res = add(res,cur);
            temp = temp+zero;




        }

        return res;


    }

    public static String add(String str1, String str2) {
        if(str1==null){
            return str2;
        }
        if(str2==null){
            return str1;
        }

        int i = str1.length()-1;
        int j = str2.length()-1;
        int carry = 0;

        String cur = "";
        while(i>=0&&j>=0){
            int n1 = str1.charAt(i--)-'0';
            int n2 = str2.charAt(j--)-'0';
            char ch = (char)('0' + (n1+n2+carry)%10 );

            cur = ch+ cur;

            carry = (n1+n2+carry)/10;
        }

        while(i<0 && j>=0){
            int n2 = str2.charAt(j--)-'0';
            char ch = (char)('0' + (n2 + carry)%10);
            cur = ch+ cur;

            carry = (n2 + carry)/10;
        }

        while(j<0 && i>=0){
            int n2 = str1.charAt(i--)-'0';
            char ch = (char)('0' + (n2 + carry)%10);
            cur = ch+ cur;

            carry = (n2 + carry)/10;
        }
        if(carry>0){
            char ch = (char)('0' +  carry);
            cur = ch+ cur;
        }
        return cur;
    }

}
