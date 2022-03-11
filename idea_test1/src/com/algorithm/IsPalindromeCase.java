package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/4 20:31
 *  @description 234. 回文链表
 *  @Version V1.0
 */

public class IsPalindromeCase {
    public static void main(String[] args) {
        ListNode l6 = new ListNode(1);
        ListNode l5 = new ListNode(2,l6);
        ListNode l4 = new ListNode(3, l5);
        ListNode l3 = new ListNode(4, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(3, l2);
        ListNode head = new ListNode(1, l1);
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {

        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        /*if(head.next.next==null){
            return head.val==head.next.val?true:false;
        }
        /*
        栈 时间复杂度O(n) 空间复杂度O(n)
        Stack<ListNode> stack = new Stack<>();
        ListNode curNode = head;
        while(curNode!=null){
            stack.push(curNode);
            curNode = curNode.next;

        }
        curNode = stack.pop();
        while(curNode!=head&&head.next!=curNode){
            if(curNode.val==head.val){
                head = head.next;
                curNode = stack.pop();
            }else{
                return false;
            }
        }
        return curNode.val==head.val;
        */
        //时间复杂度O(n) 空间复杂度O(1)
        //寻找中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next != null) {
            fast = fast.next;
        }

        ListNode cur = slow.next;
        ListNode mid = slow;
        ListNode tail = fast;
        slow = slow.next;
        while (cur != fast && slow != fast) {
            mid.next = cur.next;
            cur.next = null;
            tail.next = cur;
            tail = cur;
            cur = mid.next;
        }
        cur = mid.next;
        while (head.val == cur.val) {
            if (cur == slow) {
                if (head.val == cur.val) {
                    return true;
                }
                break;
            }
            head = head.next;
            cur = cur.next;

        }
        return false;
    }

}
