package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/2 19:56
 *  @description 92. 反转链表 II
 *  @Version V1.0
 */

public class ReverseBetweenCase {
    public static void main(String[] args) {
        ListNode l8 = new ListNode(9);
        ListNode l7 = new ListNode(8, l8);
        ListNode l6 = new ListNode(7, l7);
        ListNode l5 = new ListNode(6, l6);
        ListNode l4= new ListNode(5);
        ListNode l3 = new ListNode(4, l4);
        ListNode l2 = new ListNode(3, l3);
        ListNode l1 = new ListNode(5);
        ListNode head = new ListNode(3, l1);
        ListNode listNode = reverseBetween(head, 1,2);
        System.out.println(listNode);

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next==null||left==right){
            return head;
        }

        ListNode curNode = head;
        ListNode lastNode = new ListNode(0,head);

        int count =0;
        while(curNode!=null){
            count++;
            if(count==left){
                break;
            }
            lastNode = curNode;
            curNode = curNode.next;
        }

        for(int i=0;i<right-left;i++){
            ListNode temp = curNode.next;
            curNode.next = curNode.next.next;
            temp.next = lastNode.next;
            lastNode.next = temp;

        }
        if(left==1){
            return lastNode.next;
        }
        return head;


    }
}
