package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/10/28 14:59
 *  @description 95. 不同的二叉搜索树 II
 *  @Version V1.0
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateTreesCase {
    public static void main(String[] args) {
        for(int i=0;i<20;i++){
            System.out.println(generateTrees(i).size());
        }

    }
    public static List<TreeNode> generateTrees(int n){
        if(n==0){
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1,n);

    }

    public static List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> allTrees = new LinkedList<>();
        if(start>end){
            allTrees.add(null);
            return allTrees;
        }
        for(int i=start;i<=end;i++){

            List<TreeNode> leftTree = generateTrees(start,i-1);
            List<TreeNode> rightTree = generateTrees(i+1,end);

            for(TreeNode left:leftTree){
                for(TreeNode right: rightTree){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;

    }

}

class TreeNode{
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
