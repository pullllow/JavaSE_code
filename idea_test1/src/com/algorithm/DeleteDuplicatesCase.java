package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/1 20:38
 *  @description
 *  @Version V1.0
 */

import java.util.HashMap;
import java.util.Map;

public class DeleteDuplicatesCase {
    public static void main(String[] args) {

        ListNode l6 = new ListNode(5);
        ListNode l5 = new ListNode(4, l6);
        ListNode l4 = new ListNode(4,l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(3);
        //ListNode l1 = new ListNode(2,l2);
        //ListNode head = new ListNode(1, l1);
        //ListNode l2 = new ListNode(3);
        ListNode l1 = new ListNode(3,l2);
        ListNode head = new ListNode(1, l1);
        ListNode listNode = deleteDuplicates(head);
        System.out.println(listNode);

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode temp = null;
        int flag = -101;
        while(slow!=null && fast!=null){
            if(slow.val!=fast.val){
                if(flag==-101){
                    temp = slow;
                    slow = slow.next;
                    fast = fast.next;
                } else{
                    flag = -101;
                    if(temp!=null){
                        temp.next = fast;


                    } else {
                        head = fast;
                    }
                    slow = fast;
                    fast = fast.next;
                }
            } else {
                flag = slow.val;
                fast = fast.next;
            }

        }
        if(flag==head.val){
            return null;
        } else if(flag>-101) {
            temp.next =null;
        }

        return head;


    }


}
