package com.learnJava6;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public GuessNumber() {
    }

    public static void start() {
        //首先需要猜一个数字，使用随机数生成数字，范围1-100
        Random r = new Random();
        int number = r.nextInt(100) + 1;

        while (true) {
            //使用程序实现猜数字，每次均要输入猜测数字值，键盘录入
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你要猜的数字:");

            int guessNumber = sc.nextInt();
            if (guessNumber > number) {
                System.out.println("你猜的数字" + guessNumber + "大了");
            } else if (guessNumber < number) {
                System.out.println("你猜的数字" + guessNumber + "小了");
            }else {
                System.out.println("猜中了");
                break;
            }
        }
    }
}
