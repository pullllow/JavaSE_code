package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/1 19:43
 *  @description 25. K 个一组翻转链表
 *  @Version V1.0
 */

public class ReverseKGroupCase {
    public static void main(String[] args) {
        ListNode l8 = new ListNode(9);
        ListNode l7 = new ListNode(8, l8);
        ListNode l6 = new ListNode(7, l7);
        ListNode l5 = new ListNode(6, l6);
        ListNode l4= new ListNode(5, l5);
        ListNode l3 = new ListNode(4, l4);
        ListNode l2 = new ListNode(3, l3);
        ListNode l1 = new ListNode(2, l2);
        ListNode head = new ListNode(1, l1);
        ListNode listNode = reverseKGroup(head, 3);
        System.out.println(listNode);

    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        int listLength = 0;
        ListNode curNode = head;
        while(curNode!=null){
            listLength++;
            curNode = curNode.next;
        }
        if(listLength==1||k==1){
            return head;
        }
        int count = listLength/k;
        ListNode l1 = head;
        ListNode l2 = head.next;
        ListNode temp1 = head;
        ListNode temp2 = null;
        for(int i=0;i<count;i++){
            for(int j=1;j<k;j++){
                l1.next = l2.next;
                l2.next = temp1;
                temp1 = l2;
                l2 = l1.next;
                if(i==0){
                    head = temp1;
                }
            }
            if(temp2!=null){
                temp2.next = temp1;
            }
            temp2 = l1;
            if(l1.next!=null) {
                l1 = l1.next;
                l2 = l1.next;
                temp1 = l1;
            }
        }

        return head;

    }
}
