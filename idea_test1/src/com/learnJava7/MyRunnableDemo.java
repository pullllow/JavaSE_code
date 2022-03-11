package com.learnJava7;
/*
* 实现Runnable接口比继承Thread类优势
*
* 1.避免java单继承的局限性
* 2.适合多个相同程序的代码去处理同一个资源的情况，把线程和程序的代码、数据有效分离，面向对象编程思想
*
*
* */
public class MyRunnableDemo {
    public static void main(String[] args) {
        MyRunnable my = new MyRunnable();

        Thread t1 = new Thread(my,"嘎子");
        Thread t2 = new Thread(my,"潘子");

        t1.start();
        t2.start();
    }
}
