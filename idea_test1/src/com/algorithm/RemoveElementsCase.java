package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/4 19:43
 *  @description 203. 移除链表元素
 *  @Version V1.0
 */

public class RemoveElementsCase {
    public static void main(String[] args) {
        ListNode l6 = new ListNode(6);
        ListNode l5 = new ListNode(5, l6);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(6, l3);
        ListNode l1 = new ListNode(2, l2);
        ListNode head = new ListNode(1, l1);
        System.out.println(removeElements(head, 6));

    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode curNode = head;
        ListNode front = null;
        while (curNode != null) {
            if (curNode.val == val) {
                if (front == null) {
                    head = curNode.next;
                    curNode = curNode.next;
                } else {
                    front.next = curNode.next;
                    curNode = curNode.next;
                }
            } else {
                front = curNode;
                curNode = curNode.next;
            }

        }
        return head;

    }

}
