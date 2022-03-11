package com.leetcode.tree;
/*
 *  @author changqi
 *  @date 2021/12/27 10:32
 *  @description 105. 从前序与中序遍历序列构造二叉树
 *  @Version V1.0
 */


import java.util.HashMap;
import java.util.Map;

public class BuildTreeCase {
    public static void main(String[] args) {
        int[] preorder = {1,2,3};
        int[] inorder = {3,2,1};
        buildTree(preorder,inorder);
    }


    public static Map<Integer, Integer> indexMap = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return build(preorder, inorder, 0, inorder.length - 1, 0, inorder.length - 1);

    }

    public static TreeNode build(int[] preorder, int[] inorder, int left_preorder, int right_preorder, int left_inorder, int right_inorder) {
        if (left_preorder > right_preorder) {
            return null;
        }
        //构建根
        TreeNode root = new TreeNode(preorder[left_preorder]);

        //得到根节点位于中序遍历位置
        int root_inorder = indexMap.get(preorder[left_preorder]);

        //处理左子树

        int left_size = root_inorder - left_inorder;

        //处理右子树
        int right_size = right_inorder - root_inorder;

        System.out.println(left_size + "  " + right_size);
        root.left = build(preorder, inorder, left_preorder + 1, left_preorder + left_size, left_inorder, root_inorder - 1);


        root.right = build(preorder, inorder, left_preorder + left_size + 1, right_preorder, root_inorder + 1, right_inorder);


        return root;


    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
