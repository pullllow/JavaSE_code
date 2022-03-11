package com.datastructure.tree;
/*
 *  @author changqi
 *  @date 2021/10/28 16:17
 *  @description
 *  @Version V1.0
 */

import java.util.Stack;

public class TreeNodeDemo {
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(16);
        TreeNode node6 = new TreeNode(12);
        TreeNode node5 = new TreeNode(8);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(14, node6, node7);
        TreeNode node2 = new TreeNode(6, node4, node5);
        TreeNode node1 = new TreeNode(10, node2, node3);
        inOrder(node1);
        System.out.println("-------");
        postOrder(node1);
        System.out.println("-------");
        inOrderCycle(node1);
        System.out.println("-------");
        postOrderCycle(node1);


    }

    /**
     * @param root
     * @return void
     * @Description preOrder 前序遍历 迭代
     **/
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }

    /**
     * @param root
     * @return void
     * @Description inOrder 中序遍历 迭代
     **/
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inOrder(root.left);
        }
        System.out.println(root.val);
        if (root.right != null) {
            inOrder(root.right);
        }

    }

    /**
     * @param root
     * @return void
     * @Description postOrder 后序遍历 迭代
     **/
    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            postOrder(root.left);
        }

        if (root.right != null) {
            postOrder(root.right);
        }
        System.out.println(root.val);

    }

    /**
     * @param root
     * @return void
     * @Description preOrderCycle 前序遍历 循环
     **/
    public static void preOrderCycle(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            System.out.println(curNode.val);
            stack.push(curNode);
            curNode = curNode.left;
            while (curNode == null && !stack.isEmpty()) {
                curNode = stack.pop();
                curNode = curNode.right;
            }

        }
    }

    /**
     * @param root
     * @return void
     * @Description inOrderCycle 中序遍历，循环
     **/
    public static void inOrderCycle(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;


    }

    /**
     * @param root
     * @return void
     * @Description postOrderCycle 后序遍历，循环
     **/
    public static void postOrderCycle(TreeNode root) {
        if(root ==null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        //stack.add(root);

        while(!stack.isEmpty() || cur!=null) {
            if(cur!=null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.println(cur);
                cur = cur.right;
            }
        }


    }


}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
