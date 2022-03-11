package com.learnJava7;

public class MyThreadDemo {
    public static void main(String[] args) {
        MyThread my1 = new MyThread("1");
        MyThread my2 = new MyThread("2");

        //void start 导致此线程开始执行；java虚拟机jvm调用此线程的run方法
        my1.setName("01");
        my2.setName("02");
        my1.start();
        my2.start();

        System.out.println(Thread.currentThread().getName());
    }
}
