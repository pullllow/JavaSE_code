package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/12/21 10:44
 *  @description
 *  @Version V1.0
 */

public class ConnectCase {
    public static void main(String[] args) {


        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n7 = new Node(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.right = n7;

        connect(n1);
        System.out.println(1);


    }
    public static Node last = null;
    public static Node nextStart = null;

    public static Node connect(Node root) {

        if(root==null) {
            return null;
        }

        Node start = root;

        while(start!=null){
            last = null;
            nextStart = null;
            for(Node cur=start;cur!=null;cur=cur.next){
                if(cur.left!=null){
                    next(cur.left);
                }
                if(cur.right!=null){
                    next(cur.right);
                }
            }
            start = nextStart;
        }

        return root;

    }

    public static void next(Node cur){
        if(last!=null){
            last.next = cur;
        }
        if(nextStart==null){
            nextStart=cur;
        }
        last = cur;


    }

    public static class Node{
        int val;
        Node left;
        Node right;
        Node next;

        public Node(int val) {
            this.val = val;
        }


    }



}


