package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/1 18:44
 *  @description 23. 合并K个升序链表
 *  @Version V1.0
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKListsCase {
    public static void main(String[] args) {
        ListNode l13 = new ListNode(5);
        ListNode l12 = new ListNode(4, l13);
        ListNode l11 = new ListNode(1, l12);

        ListNode l23 = new ListNode(5);
        ListNode l22 = new ListNode(3, l23);
        ListNode l21 = new ListNode(1, l22);

        ListNode l32 = new ListNode(6);
        ListNode l31 = new ListNode(2, l32);


        ListNode[] lists = new ListNode[3];
        lists[0] = null;
        lists[1] = l11;
        lists[2] = null;
        ListNode listNode = mergeKLists(lists);
        System.out.println(listNode);
    }

//    public static ListNode mergeKLists(ListNode[] lists) {
//        if(lists.length==0){
//            return null;
//        }
//        int[] nums = new int[lists.length];
//        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return o1.val-o2.val;
//            }
//        });
//        for(ListNode list : lists){
//            while(list!=null){
//                queue.offer(list);
//                list = list.next;
//            }
//        }
//        ListNode res = queue.poll();
//        ListNode temp = res;
//        while(queue.size()!=0){
//            temp.next = queue.poll();
//            temp = temp.next;
//        }
//        temp.next = null;
//        return res;
//
//
//    }

    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;

        }
        int heapSize = lists.length;

        for (int i = lists.length - 1; i >= 0; i--) {
            heapify(lists, i, heapSize);
        }

        ListNode res = new ListNode();
        ListNode cur = res;
        while (heapSize > 0) {
            if (lists[0] == null) {
                if (heapSize > 1) {
                    swap(lists, 0, --heapSize);
                    cur.val = lists[0].val;
                    lists[0] = lists[0].next;
                    heapify(lists, 0, heapSize);
                } else {
                    return res;
                }
            } else {
                cur.val = lists[0].val;
                lists[0] = lists[0].next;
                heapify(lists, 0, heapSize);
            }
            cur.next = new ListNode();
            cur = cur.next;
        }

        return res;


    }

    //小根堆
    public static void heapInsert(ListNode[] ans, int index) {
        while (ans[index] != null && ans[(index - 1) / 2] != null && ans[index].val < ans[(index - 1) / 2].val) {
            swap(ans, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
        while (ans[index] == null && ans[(index - 1) / 2] != null) {
            swap(ans, index, (index - 1) / 2);
            index = (index - 1) / 2;

        }
    }

    public static void heapify(ListNode[] ans, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int smallest = left;
            if (ans[left] != null) {
                if (left + 1 < heapSize) {
                    if (ans[left + 1] != null) {
                        smallest = ans[smallest].val < ans[left + 1].val ? smallest : left + 1;
                        smallest = ans[smallest].val < ans[index].val ? smallest : index;
                    }
                }
            } else {
                if (left + 1 < heapSize) {
                    if (ans[left + 1] != null) {
                        smallest = left + 1;
                        smallest = ans[smallest].val < ans[index].val ? smallest : index;
                    } else {
                        smallest = index;
                    }
                }
            }
            if (smallest == index) break;
            swap(ans, index, smallest);
            index = smallest;
            left = 2 * index + 1;

        }
    }

    public static void swap(ListNode[] ans, int i, int j) {
        ListNode temp = ans[i];
        ans[i] = ans[j];
        ans[j] = temp;
    }


}


class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
