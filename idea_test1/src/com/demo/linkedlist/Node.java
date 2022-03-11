package com.demo.linkedlist;
/*
 *  @author changqi
 *  @date 2022/3/10 12:51
 *  @description
 *  @Version V1.0
 */

public class Node {
    public int val;
    public Node next;

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}


