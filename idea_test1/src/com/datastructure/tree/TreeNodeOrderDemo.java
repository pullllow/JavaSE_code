package com.datastructure.tree;
/*
 *  @author changqi
 *  @date 2021/11/30 14:18
 *  @description
 *  @Version V1.0
 */

import java.util.*;

public class TreeNodeOrderDemo {
    public static void main(String[] args) {

        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);
        preOrder(node1);
        System.out.println("-------");
        inOrder(node1);
        System.out.println("-------");
        postOrder(node1);

        System.out.println("-------------");

        System.out.println(getMaxWidth(node1));
        System.out.println(getMaxWidthNoHashMap(node1));

    }


    /**
     * @param root
     * @return void
     * @Description preOrderRecur 迭代前序遍历
     **/
    public static void preOrderRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }


    /**
     * @param root
     * @return void
     * @Description inOrederRecur 迭代中序遍历
     **/
    public static void inOrederRecur(TreeNode root) {

        if (root == null) {
            return;
        }

        preOrderRecur(root.left);
        System.out.println(root.val);
        preOrderRecur(root.right);


    }

    /**
     * @param root
     * @return void
     * @Description postOrderRecur 迭代后序遍历
     **/
    public static void postOrderRecur(TreeNode root) {

        if (root == null) {
            return;
        }

        preOrderRecur(root.left);

        preOrderRecur(root.right);
        System.out.println(root.val);
    }


    /**
     * @param root
     * @return void
     * @Description preOrder 非迭代前序遍历
     **/
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curNode = root;
        stack.push(curNode);
        while (!stack.isEmpty()) {
            curNode = stack.pop();
            System.out.print(curNode.val + " ");
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }

        System.out.println();

    }

    /**
     * @param root
     * @return void
     * @Description inOrder 非迭代中序遍历
     **/
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while (!stack.isEmpty() || curNode !=null) {
            if (curNode!= null) {
                stack.push(curNode);
                curNode = curNode.left;
            } else {
                curNode = stack.pop();
                System.out.print(curNode.val + " ");
                curNode = curNode.right;

            }
        }
        System.out.println();


    }


    /**
     * @param root
     * @return void
     * @Description postOrder 非迭代后序遍历
     **/
    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        TreeNode curNode = root;
        s1.push(root);
        while (!s1.isEmpty()) {
            curNode = s1.pop();
            s2.push(curNode);
            if(curNode.left!=null){
                s1.push(curNode.left);
            }
            if (curNode.right!=null){
                s1.push(curNode.right);
            }
        }

        while (!s2.isEmpty()){
            System.out.print(s2.pop().val + " ");
        }


        System.out.println();


    }

    public static int getMaxWidth(TreeNode root) {
        if(root==null){
            return 0;
        }


        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode,Integer> map = new HashMap<>();

        int curLevel = 1;
        int curLevelNodes = 0;
        int max = Integer.MIN_VALUE;

        map.put(root,curLevel);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur =queue.poll();
            if(curLevel == map.get(cur)){
                curLevelNodes++;
            } else {
                curLevel = map.get(cur);
                curLevelNodes = 1;
            }
            if (cur.left!=null){
                queue.add(cur.left);
                map.put(cur.left,curLevel+1);
            }
            if (cur.right!=null){
                queue.add(cur.right);
                map.put(cur.right,curLevel+1);
            }
            max = Math.max(max,curLevelNodes);

        }

        return  max;



    }


    public static int getMaxWidthNoHashMap(TreeNode root) {
        if(root ==null){
            return 0;

        }

        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode curEnd = root;
        TreeNode nextEnd = null;
        int curLevelNodes = 0;
        int max = 0;

        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            if (cur.left!=null) {
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right!=null){
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            curLevelNodes++;
            if (cur==curEnd){
                curLevelNodes=1;
                curEnd = nextEnd;
                nextEnd = null;
            }

            max = Math.max(max,curLevelNodes);

        }

        return max;


    }






}
