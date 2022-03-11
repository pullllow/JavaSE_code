package com.datastructure.tree;
/*
 *  @author changqi
 *  @date 2021/11/11 19:30
 *  @description
 *  @Version V1.0
 */

public class MorrrisTraversalDemo {
    public static void main(String[] args) {
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        Node n2 = new Node(2, n4, n5);
        Node n3 = new Node(3, n6, n7);

        Node head = new Node(1, n2, n3);

        //morrisTraversal(head);

        morrisPost(head);

    }


    public static class Node {
        private int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    public static void morrisTraversal(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            System.out.println(cur.toString());
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {

                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
    }

    public static void morrisPost(Node head) {
        if (head == null) {
            return;
        }

        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if(mostRight.right==null){ //两次遍历的第一次
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else { //两次遍历的第二次
                    //逆序打印左树右边界

                    mostRight.right = null;
                    printEdge(cur.left);
                }


            }
            cur = cur.right;
        }
        printEdge(head);


    }

    public static void printEdge(Node edge){
        Node reverse = reverse(edge);
        Node cur = reverse;
        while(cur!=null){
            System.out.println(cur.toString());
            cur = cur.right;
        }
        reverse(reverse);

    }

    public static Node reverse(Node node){
        Node last = null;
        Node cur = node;
        Node next  = node.right;
        while(next!=null){
            cur.right = last;
            last = cur;
            cur = next;
            next = cur.right;
        }
        cur.right = last;
        return cur;
    }
}
