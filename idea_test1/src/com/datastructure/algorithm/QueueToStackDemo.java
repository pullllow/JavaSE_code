package com.datastructure.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/24 14:46
 *  @description
 *  @Version V1.0
 */

import java.util.LinkedList;
import java.util.Queue;

public class QueueToStackDemo {

    public static void main(String[] args) {
        MyStack ms = new MyStack();

        ms.push(1);
        ms.push(2);
        ms.push(3);

        ms.pop();
        ms.top();
        ms.empty();
    }


}


class MyStack {
    private Queue<Integer> a;
    private Queue<Integer> b;

    public MyStack() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }

    public void push(int x) {
        a.offer(x);
        while (!b.isEmpty()) {
            a.offer(b.poll());
        }
        Queue<Integer> temp = a;
        a = b;
        b = temp;
    }

    public int pop() {
        return b.poll();
    }

    public int top() {

        return b.peek();

    }

    public boolean empty() {
        return b.isEmpty();
    }
}




