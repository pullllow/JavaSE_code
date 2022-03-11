package com.demo.linkedlist;
/*
 *  @author changqi
 *  @date 2022/3/10 12:52
 *  @description
 *  @Version V1.0
 */

public class NodeDemo {
    public static void main(String[] args) {
        Node n5 = new Node (5);
        Node n4 = new Node (4,n5);
        Node n3 = new Node (3,n4);
        Node n2 = new Node (2,n3);
        Node n1 = new Node (1,n2);
        System.out.println(n1);
        //System.out.println(reverse(n1));
        System.out.println(findLastK(n1,3));

    }


    public static Node reverse(Node root) {
        if(root==null) {
            return null;
        }

        Node cur = root.next;
        Node last = root;

        while(cur!=null) {
            Node temp = cur.next;
            cur.next = root;
            last.next = temp;
            root = cur;
            cur = temp;

        }


        return root;
    }


    public static Node findLastK(Node root, int k) {
        if(root==null) {
            return null;
        }
        Node slow = root;
        Node fast = root;

        for(int i=0;i<k;i++) {
            fast = fast.next;
        }
        while(fast!=null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
