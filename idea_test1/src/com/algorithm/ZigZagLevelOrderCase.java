package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/15 20:34
 *  @description 103. 二叉树的锯齿形层序遍历
 *  @Version V1.0
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagLevelOrderCase {
    public static void main(String[] args) {
        TreeNode t4 = new TreeNode(7);
        TreeNode t3 = new TreeNode(15);
        TreeNode t2 = new TreeNode(20,t3,t4);
        TreeNode t1 = new TreeNode(9);
        TreeNode head = new TreeNode(3,t1,t2);
        List<List<Integer>> lists = zigzagLevelOrder(head);
        System.out.println(lists);


    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Stack<TreeNode> record = new Stack<>();
        record.push(root);
        List<List<Integer>> res = new ArrayList<>();
        zigzagLevelOrder(record,res,true);
        return res;




    }

    public static void zigzagLevelOrder(Stack<TreeNode> record,List<List<Integer>> res,boolean reverse) {
        if(record.isEmpty()){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(!record.isEmpty()){
            List<Integer> ans = new ArrayList<>();
            int n = record.size();
            for(int i =0;i<n;i++){
                if(reverse){
                    if(record.peek().left!=null){
                        stack.push(record.peek().left);
                    }
                    if(record.peek().right!=null){
                        stack.push(record.peek().right);
                    }
                } else {

                    if(record.peek().right!=null){
                        stack.push(record.peek().right);
                    }
                    if(record.peek().left!=null){
                        stack.push(record.peek().left);
                    }
                }
                ans.add(record.pop().val);
            }
            res.add(ans);
        }
        zigzagLevelOrder(stack,res,!reverse);
    }
}
