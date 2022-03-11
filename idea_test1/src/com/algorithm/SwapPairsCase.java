package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/1 19:20
 *  @description 24. 两两交换链表中的节点
 *  @Version V1.0
 */

public class SwapPairsCase {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(3, l1);
        ListNode l3 = new ListNode(2, l2);
        ListNode head1 = new ListNode(1, l3);
        ListNode listNode = swapPairs(head1);


    }

    public static ListNode swapPairs(ListNode head) {
        if(head==null||head.next ==null){
            return head;
        }
        ListNode l1 = head;
        ListNode l2 = head.next;
        ListNode temp1 = head.next;
        ListNode temp2 = null;
        while(l1!=null&& l2!=null){
            l1.next = l2.next;
            l2.next = l1;
            ListNode temp = l1;
            if(temp2!=null){
                temp2.next = l2;
            }
            temp2 = temp;
            l1 = l1.next;
            if(l1!=null){
                l2 = l1.next;
            } else {
                break;
            }



        }
        return temp1;

    }
}
