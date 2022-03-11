package com.learnJava7;

public class ThreadPriorityDemo {
    public static void main(String[] args) {

        ThreadPriority tp1 = new ThreadPriority();
        ThreadPriority tp2 = new ThreadPriority();
        ThreadPriority tp3 = new ThreadPriority();

        tp1.setName("001");
        tp2.setName("002");
        tp3.setName("003");

        System.out.println(tp1.getPriority());
        System.out.println(tp2.getPriority());
        System.out.println(tp3.getPriority());

        tp1.setPriority(1);
        tp2.setPriority(4);
        tp3.setPriority(3);
        tp1.start();
        tp2.start();
        tp3.start();
    }
}
