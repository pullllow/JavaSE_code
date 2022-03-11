package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/4 19:18
 *  @description 147. 对链表进行插入排序
 *  @Version V1.0
 */

public class InsertionSortListCase {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(1, l1);
        ListNode l3 = new ListNode(5, l2);
        ListNode head = new ListNode(4, l3);
        System.out.println(insertionSortList(head));


    }

    public static ListNode insertionSortList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode curNode = head.next;
        ListNode tailNode = head;
        ListNode temp = head;
        ListNode front = null;
        while (curNode != null) {
            while (temp != tailNode.next) {
                if (curNode.val > temp.val) {
                    front = temp;
                    temp = temp.next;
                } else {
                    tailNode.next = curNode.next;
                    if (front != null) {
                        front.next = curNode;
                        curNode.next = temp;
                    } else {
                        head = curNode;
                        curNode.next = temp;
                    }
                    curNode = tailNode.next;
                    temp = head;
                    front = null;
                    break;
                }
            }
            if (front == tailNode) {
                tailNode = curNode;
                curNode = curNode.next;
                temp = head;
                front = null;
            }
        }
        return head;

    }
}
