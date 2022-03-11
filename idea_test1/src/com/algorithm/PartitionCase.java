package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/1 21:32
 *  @description 86. 分隔链表 131. 分割回文串
 *  @Version V1.0
 */

import java.util.ArrayList;
import java.util.List;

public class PartitionCase {
    public static void main(String[] args) {
        /*
        ListNode l6 = new ListNode(5);
        ListNode l5 = new ListNode(2);
        ListNode l4 = new ListNode(5,l5);
        ListNode l3 = new ListNode(2, l4);
        ListNode l2 = new ListNode(3,l3);
        ListNode l1 = new ListNode(1);
        ListNode head = new ListNode(1, l1);
        ListNode listNode = partition(head,3);
        System.out.println(listNode);*/
        String s = "aba";
        System.out.println(partition(s));


    }
    public static ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode l1 = head.val>=x?head:null;
        ListNode l2 = head.val<x?head:null;
        ListNode head1 = l1;
        ListNode head2 = l2;

        ListNode temp =head.next;
        while(temp!=null){
            if(temp.val>=x){
                if(head1==null){
                    l1 = temp;
                    head1=l1;

                } else{
                    l1.next = temp;
                    l1 = temp;
                }


            } else {
                if(head2==null){
                    l2 = temp;
                    head2=l2;

                } else{
                    l2.next = temp;
                    l2 = temp;
                }

            }
            temp = temp.next;
        }
        if(head1==null||head2==null){
            return head;
        }
        l1.next = null;
        l2.next = head1;
        return head2;


    }

    public static  List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n+1][n+1];

        for(int i=1;i<=n;i++){
            dp[i][i] = true;
        }
        for(int l=2;l<=n;l++){
            for(int i=1;i<=n;i++){
                int j = i+l-1;
                if(j<=n){
                    dp[i][j] = (s.charAt(i-1)==s.charAt(j-1));
                    if(j-i>1){
                        dp[i][j] = dp[i][j] && dp[i+1][j-1];
                    }
                }

            }
        }

        List<List<String>> res = new ArrayList<>();

        backTrack(s,dp,res,new ArrayList<String>(),1);
        return res;

    }

    public static void backTrack(String s, boolean[][] dp, List<List<String>> res, List<String> ans, int index){
        if(index==dp.length){
            res.add(new ArrayList<>(ans));
            return;
        }

        for(int j=index;j<dp.length;j++){

            if(dp[index][j]){
                List<String> a = new ArrayList<>(ans);
                a.add(s.substring(index-1,j));
                backTrack(s,dp,res,new ArrayList<>(a),j+1);
            }
        }


    }
}
