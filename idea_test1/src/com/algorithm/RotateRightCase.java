package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/1 20:00
 *  @description 61. 旋转链表
 *  @Version V1.0
 */

public class RotateRightCase {
    public static void main(String[] args) {
        ListNode l4 = new ListNode(5);
        ListNode l3 = new ListNode(4, l4);
        ListNode l2 = new ListNode(3);
        ListNode l1 = new ListNode(2);
        ListNode head = new ListNode(1, l1);
        ListNode listNode = rotateRight(head, 1);
        System.out.println(listNode);

    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int listLength = 1;
        ListNode curNode = head;
        while (curNode.next != null) {
            listLength++;
            curNode = curNode.next;
        }
        int cur = k % (listLength);

        curNode.next = head;
        curNode = head;

        for (int i = 0; i < listLength-cur; i++) {
            curNode = curNode.next;
        }
        head = curNode.next;
        curNode.next = null;

        return head;


    }
}
