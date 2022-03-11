package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/11 14:13
 *  @description
 *  @Version V1.0
 */

public class PrintToMaxOfNDigitsCase {
    public static void main(String[] args) {
        printToMaxNDigits(3);

    }

    public static void printToMaxNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        number[0] = '0';
        recursively(number, 0);

    }

    public static void recursively(char[] number, int index) {
        if (index == number.length) {
            print(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index] = (char) ('0' + i);
            recursively(number, index + 1);
        }

    }

    public static void print(char[] number) {
        boolean isBegin0 = false;
        for (int i = 0; i < number.length; i++) {
            if (!isBegin0 && number[i] != '0') {
                isBegin0 = true;
            }
            if(isBegin0) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }
}
